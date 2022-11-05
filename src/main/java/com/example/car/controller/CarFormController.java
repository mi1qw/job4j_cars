package com.example.car.controller;

import com.example.car.dto.CarDto;
import com.example.car.dto.CarMapper;
import com.example.car.dto.FileImageDto;
import com.example.car.dto.OptionsDto;
import com.example.car.exception.StorageException;
import com.example.car.model.*;
import com.example.car.service.*;
import com.example.car.util.CarState;
import com.example.car.util.ImageUtil;
import com.example.car.util.JsonUtil;
import com.example.car.util.State;
import com.example.car.validation.ValidationGroupSequence;
import com.example.car.web.UserSession;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/cars")
@Slf4j
@AllArgsConstructor
public class CarFormController {
    private final State state;
    private final UserSession userSession;
    private final MarkService markService;
    private final CarService carService;
    private final FileService fileService;
    private final CarMapper carMapper;
    private final ModelService modelService;
    private final JsonUtil jsonUtil;
    private final OptionsService optionsService;

    @PostMapping("/reorder")
    public ResponseEntity<?> reorder(final @RequestParam("value") String name) {
        String[] array = StringUtils.split(name, "|");
        Car car = userSession.getNewCar();
        userSession.setNewCar(carService.reorderImg(car, array));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/removeImg")
    public ResponseEntity<?> removeImg(final @RequestParam("value") String name) {
        Car car = userSession.getNewCar();
        try {
            car = carService.deleteImageByName(car, name);
            if (car == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            userSession.setNewCar(car);
            fileService.deleteByName(name);
        } catch (StorageException e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userSession.getOrder().set(car.getImages().size());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/img/{img}")
    public ResponseEntity<?> getImg(final @PathVariable("img") String img,
                                    final Model model) {
        try {
            Resource resource = fileService.download(img);
            return ResponseEntity.ok()
                    .headers(new HttpHeaders())
                    .contentLength(resource.contentLength())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(resource);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/add")
    public String add(final Model model) {
        Car newCar = userSession.getNewCar();
        if (newCar == null || !newCar.getStatus().equals(Status.newItem)) {
            newCar = carService.createCarWithAccount();
            userSession.setNewCar(newCar);
            userSession.setCarState(null);
        }
        CarDto carDto = getCarDtoAndState(newCar);
        model.addAttribute("carform", carDto);
        model.addAttribute("reverse", Comparator.reverseOrder());
        return "addCar";
    }


    @GetMapping("/edit/{id}")
    public String edit(final @PathVariable long id, final Model model) {
        Car car = carService.getCar(id);
        Account account = userSession.getAccount();
        if (!car.getAccount().getId().equals(account.getId())) {
            return "redirect:/posts";
        }
        userSession.setNewCar(car);
        if (car.getStatus().equals(Status.newItem)) {
            return "redirect:/cars/add";
        }
        userSession.getOrder().set(car.getImages().size());
        CarDto carDto = carMapper.carToDto(car);
        model.addAttribute("carform", carDto);
        model.addAttribute("reverse", Comparator.reverseOrder());
        CarState state = this.state.fillList(car);
        userSession.setCarState(state);
        return "addCar";
    }

    @GetMapping("/addState")
    public String add(final @RequestParam(name = "id", required = false) Long id,
                      final @RequestParam(name = "stateID", required = false) Integer stateID,
                      final Model model) {
        CarState carState = userSession.getCarState();
        if (carState == null) {
            return "addCar";
        }
        if (id != null && stateID != null) {
            state.makeSteps(id, stateID);
        }
        if (carState.isDone()) {
            Long genID = carState.getGenerationID();
            Map<String, Map<Boolean, Map<Boolean, List<OptionsDto>>>> optionsDto
                    = optionsService.getOptionsDto(new HashSet<>(), genID);
            carState.setOptionsDto(optionsDto);

            CarDto carDto = getCarDtoAndState(userSession.getNewCar());
            model.addAttribute("carform", carDto);
        }
        model.addAttribute("reverse", Comparator.reverseOrder());
        return "addCar";
    }

    @GetMapping("/resetState")
    public String resetState(final @RequestParam(name = "stateID") int stateID,
                             final Model model) {
        CarState state = userSession.getCarState();
        if (state == null) {
            return "addCar";
        }
        if (stateID < 9) {
            state.getStepList().get(stateID).resetStatusGen(state.getGenerations());
            for (int i = stateID + 1; i < 9; i++) {
                state.getStepList().get(i).resetOption();
            }
        } else {
            state.getStepList().get(stateID).resetStatus();
        }
        return "redirect:/cars/addState";
    }


    @PostMapping("/upload")
    public ResponseEntity<?> upload(
            final @RequestParam("files") MultipartFile file,
            final @RequestParam("order") int order,
            final @RequestParam("totalFiles") int totalFiles) {
        Car newCar = userSession.getNewCar();
        String filename = file.getOriginalFilename();
        if (newCar == null || !ImageUtil.isValid(filename)) {
            return new ResponseEntity<>("Wrong image type.", HttpStatus.BAD_REQUEST);
        }
        AtomicInteger maxID = userSession.getMaxID();
        if (maxID == null) {
            int maxIDa = ImageUtil.findImageMaxID(newCar);
            maxID = new AtomicInteger(maxIDa);
            userSession.setMaxID(maxID);
        }
        int tabOrder = userSession.getOrder().getAndIncrement();
        filename = ImageUtil.rename(filename, maxID.incrementAndGet(), newCar);
        FileImageDto imageDto = new FileImageDto(filename, tabOrder);

        boolean upload = fileService.upload(file, imageDto);
        if (!upload) {
            return new ResponseEntity<>(filename, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(filename, HttpStatus.OK);
    }

    @PostMapping("/add")
    public String savePost(final @Validated(ValidationGroupSequence.class)
                           @ModelAttribute("carform") CarDto carDto,
                           final BindingResult bindingResult,
                           final Model model) {
        if (bindingResult.hasErrors()) {
            log.error("{}", bindingResult);
            return "addCar";
        }
        Set<Options> options = carDto.getOptions();
        if (options == null) {
            HashSet<Options> set = new HashSet<>();
            carDto.setOptions(set);
            options = set;
        }
        CarState carState = userSession.getCarState();
        options.addAll(carState.getOptionsGeneration());

        Car newCar = state.getResultCar();
        carMapper.updateCar(carDto, newCar);
        newCar.setStatus(Status.onSale);
        carService.merge(newCar);
        userSession.setCarState(null);
        userSession.setNewCar(null);
        return "redirect:/myposts";
    }

    /**
     * Get models in Json.
     * http://127.0.0.1:8080/cars/models?id=1
     *
     * @param id id
     * @return string
     */
    @GetMapping(value = "/models", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getModels(final @RequestParam Integer id) {
        Map<Long, String> namesByMarkId = modelService.getModelNamesByMarkId(id);
        return jsonUtil.mapToJson(namesByMarkId);
    }


    private CarDto getCarDtoAndState(final Car newCar) {
        CarDto carDto = null;
        CarState state = userSession.getCarState();
        if (state == null) {
            CarState carState = this.state.createCarState();
            userSession.setCarState(carState);
            carState.getStepList().get(0).makeOptions();
        } else {
            if (state.isDone()) {
                carDto = carMapper.carToDto(newCar);
                userSession.getOrder().set(newCar.getImages().size());
            }
        }
        return carDto;
    }
}
