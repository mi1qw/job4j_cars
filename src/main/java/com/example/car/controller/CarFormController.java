package com.example.car.controller;

import com.example.car.dto.CarDto;
import com.example.car.dto.CarMapper;
import com.example.car.dto.FileImageDto;
import com.example.car.exception.StorageException;
import com.example.car.model.Car;
import com.example.car.model.Generations;
import com.example.car.model.Mark;
import com.example.car.model.Status;
import com.example.car.service.CarService;
import com.example.car.service.FileService;
import com.example.car.service.MarkService;
import com.example.car.service.ModelService;
import com.example.car.util.CarState;
import com.example.car.util.ImageUtil;
import com.example.car.util.JsonUtil;
import com.example.car.util.State;
import com.example.car.validation.ValidationGroupSequence;
import com.example.car.web.UserSession;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/cars")
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

    @PostMapping("/reorder")
    public ResponseEntity<?> reorder(final @RequestParam("value") String name) {
        String[] array = StringUtils.split(name, "|");
        Car car = userSession.getNewCar();
        userSession.setNewCar(carService.reorderImg(car, array));
        // TODO возможно лучше сразу не сохранять в базу, а целиком вместе с формой !
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/removeImg")
    public ResponseEntity<?> removeImg(final @RequestParam("value") String name) {
        Car car = userSession.getNewCar();
        try {
            fileService.deleteByName(name);
            log.info("{}", car.getImages());
            car = carService.deleteImageByName(car, name);
            userSession.setNewCar(car);
            log.info("{}", userSession.getNewCar().getImages());
        } catch (StorageException e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        // сбросить счётчик первого order,
        // надо начинать не 0, со следующего List/size
//        session.getTabOrder().setPrevTotal(car.getImages().size());

        userSession.getOrder().set(car.getImages().size());

        return new ResponseEntity<>(HttpStatus.OK);
//      return   ResponseEntity.ok()
//                .headers(new HttpHeaders())
//                .build();
    }

    @GetMapping("/img/{img}")
    public ResponseEntity<?> getImg(final @PathVariable("img") String img,
                                    final Model model) {
        try {
            Resource resource = fileService.download(img);
            return ResponseEntity.ok()
//                .header("Content-Disposition", "attachment; filename=" + img)
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

        //        Car newCar;
        Car newCar = userSession.getNewCar();
        if (newCar == null || !newCar.getStatus().equals(Status.newItem)) {
            newCar = carService.createCarAccount();
            userSession.setNewCar(newCar);
            userSession.setCarState(null);
        }


        CarDto carDto = null;
        CarState state = userSession.getCarState();
        if (state == null) {
            CarState carState = this.state.createCarState();
            userSession.setCarState(carState);
            carState.getStepList().get(0).makeOptions();
        } else {
            if (state.isDone()) {
                carDto = carMapper.carToDto(newCar);
            }
        }
        model.addAttribute("carform", carDto);

//        model.addAttribute("carform",
//                CarDto.builder()
//                        .description("aaa")
//                        .price(BigDecimal.valueOf(1100L))
//                        .yearPurchase((short) 2001)
//                        .odometer((short) 0)
//                        .build()
//        );

//        else {
//            CarState.State<?, ?> state0 = state.getStepList().get(0);
//            if (state0.getOptions().isEmpty()) {
//                state0.makeOptions();
//            }
//        }

        // TODO упростить в один метод
        //  как проверить что в сесии ошибка наличия файлов


//        log.info("{}", newCar);
        // надо начинать не 0, со следующего List/size image
        userSession.getOrder().set(newCar.getImages().size());
        return "addCar";
    }

    @GetMapping("/edit/{id}")
    public String edit(final @PathVariable long id, final Model model) {
        Car car = carService.getCar(id);
        userSession.setNewCar(car);
        if (car.getStatus().equals(Status.newItem)) {
            return "redirect:/cars/add";
        }
        userSession.getOrder().set(car.getImages().size());
        CarDto carDto = carMapper.carToDto(car);
        model.addAttribute("carform", carDto);

//        CarState carState = state.createCarState();
        CarState state = this.state.fillList(car);
        userSession.setCarState(state);
        return "addCar";
    }

    @GetMapping("/addState")
    public String add(final @RequestParam(name = "id") long id,
                      final @RequestParam(name = "stateID") int stateID,
                      final Model model) {
        CarState state = userSession.getCarState();
        if (state == null) {
            return "addCar";
        }

        // TODO упростить в один метод
        CarState.State<?, ?> step = state.getStepList().get(stateID);
        Object optionByID = step.getOptionByID(id);
        step.setValue(optionByID);

        step.setPrevGenerations(state.getGenerations());

        int step1 = stateID;
        CarState.State<?, ?> stepNext;

        while (step1 + 1 < state.getStepList().size()) {
            ++step1;
            stepNext = state.getStepList().get(step1);
            stepNext.setPrevGenerations(state.getGenerations());
            Map<Long, ?> options = stepNext.makeOptions();
            if (options.size() > 1) {
                break;
            }
            if (options.size() == 0) {
                log.error(step.getName() + "  options.size() ==0");
                break;
            }
            optionByID = options.values().iterator().next();
            stepNext.setValue(optionByID);
            stepNext.setStatus(true);
        }
//        return "addCar";
        return "redirect:/cars/add";
    }

    @GetMapping("/resetState")
    public String resetState(final @RequestParam(name = "stateID") int stateID,
                             final Model model) {
        CarState state = userSession.getCarState();
        if (state == null) {
            // TODO куда перенаправить
            return "cars/add";
        }
        CarState.State<?, ?> step = state.getStepList().get(stateID);
        if (stateID < 9) {
            List<Generations> generations = state.getGenerations();
            state.getStepList().get(stateID).resetStatusGen(state.getGenerations());
            int step1 = stateID + 1;
            for (int i = stateID + 1; i < 9; i++) {
                state.getStepList().get(i).resetOption();
            }
        } else {
            state.getStepList().get(stateID).resetStatus();
        }
        return "redirect:/cars/add";
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
//        TabOrder tabOrder = session.getTabOrder();
//        if (tabOrder == null) {
//            System.out.println("tabOrder == null");
//            tabOrder = new TabOrder(totalFiles);
//            session.setTabOrder(tabOrder);
//        }


        AtomicInteger maxID = userSession.getMaxID();
        if (maxID == null) {
            int maxIDa = ImageUtil.findMaxID(newCar);
            maxID = new AtomicInteger(maxIDa);
            userSession.setMaxID(maxID);
        }


//        int tabOrder = session.getTabOrder()
//                .getOrder(order, totalFiles);
        int tabOrder = userSession.getOrder().getAndIncrement();

        filename = ImageUtil.rename(filename, maxID.incrementAndGet(), newCar);
        FileImageDto imageDto = new FileImageDto(filename, tabOrder);

        log.info("totalFiles={}  order={}  tabOrder={}  filename={}",
                totalFiles, order, tabOrder, filename);


        boolean upload = fileService.upload(file, imageDto);
        if (!upload) {
            return new ResponseEntity<>(filename, HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        return new ResponseEntity<>("Successfully uploaded", HttpStatus.OK);
        return new ResponseEntity<>(filename, HttpStatus.OK);
//        return ResponseEntity.ok()
//                .header("Content-Disposition", "attachment; filename=" + filename)
//                .build();
    }

    @PostMapping("/add")
    public String savePost(final @Validated(ValidationGroupSequence.class)
                           @ModelAttribute("carform") CarDto carDto,
                           final BindingResult bindingResult,
                           final Model model) {
        log.info("{}", carDto);

        userSession.getCarState().getStepList()
                .forEach(n -> log.info("{}", n.getValue()));
        System.out.println();
        List<Long> generationsListID = userSession.getCarState()
                .getGenerations().stream()
                .map(Generations::getId)
                .toList();
        log.info("{}", generationsListID);

        if (bindingResult.hasErrors()) {
            log.error("{}", bindingResult);
            return "addCar";
        }

        Car newCar = state.getResultCar();
//        Car newCar = userSession.getNewCar();
        carMapper.updateCar(carDto, newCar);
        newCar.setStatus(Status.onSale);
        carService.merge(newCar);
//        log.info("{}", newCar);
//        final @ModelAttribute(name = "carform") CarDto carDto,
//        final Model model){


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
    public String getModels(final @RequestParam Long id) {
        Mark mark = new Mark();
        mark.setId(id);
        Map<Long, String> collect = modelService.getModelsByMark(mark)
                .values().stream()
                .collect(Collectors.toMap(
                        com.example.car.model.Model::getId,
                        com.example.car.model.Model::getName)
                );
        return jsonUtil.mapToJson(collect);
    }
}
