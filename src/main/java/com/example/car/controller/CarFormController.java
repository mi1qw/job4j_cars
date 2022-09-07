package com.example.car.controller;

import com.example.car.dto.CarDto;
import com.example.car.dto.FileImageDto;
import com.example.car.exception.StorageException;
import com.example.car.model.Car;
import com.example.car.model.Generations;
import com.example.car.service.CarService;
import com.example.car.service.FileService;
import com.example.car.service.MarkService;
import com.example.car.util.CarState;
import com.example.car.util.ImageUtil;
import com.example.car.util.State;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

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
        model.addAttribute("carform",
                CarDto.builder()
                        .description("aaa")
                        .price(BigDecimal.valueOf(1100L))
                        .yearPurchase("2001")
                        .odometer(100)
                        .build());

        CarState state = userSession.getCarState();
        if (state == null) {
            CarState carState = this.state.createCarState();
            userSession.setCarState(carState);
            CarState.State<?, ?> step0 = carState.getStateList().get(0);
            step0.makeOptions(null);
        } else {
            CarState.State<?, ?> state0 = state.getStateList().get(0);
            if (state0.getOptions().isEmpty()) {
                state0.makeOptions(null);
            }
        }
        // TODO упростить в один метод
        //  как проверить что в сесии ошибка наличия файлов

        if (userSession.getNewCar() == null) {
            Car car = carService.addCar();
            userSession.setNewCar(car);
//            session.setMaxID(new AtomicInteger(0));
        }


        Car newCar = userSession.getNewCar();
//        log.info("{}", newCar);

        // сбросить счётчик первого order,
        // надо начинать не 0, со следующего List/size
//        session.getTabOrder().setPrevTotal(0);
//        userSession.getTabOrder().setPrevTotal(newCar.getImages().size());

        userSession.getOrder().set(newCar.getImages().size());


//        carState.getStateList()
//        model.addAttribute("addState", state.getCarState());
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
        CarState.State<?, ?> step = state.getStateList().get(stateID);
        Object optionByID = step.getOptionByID(id);
        step.setValue(optionByID);

        step.setPrevGenerations(state.getGenerations());

        int step1 = stateID;
        CarState.State<?, ?> stepNext;

        while (step1 + 1 < state.getStateList().size()) {
            ++step1;
            stepNext = state.getStateList().get(step1);
            stepNext.setPrevGenerations(state.getGenerations());
            Map<Long, ?> options = stepNext.makeOptions(optionByID);
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
        return "addCar";


/*        CarState.State<?, ?> stepPrev;
//        CarState.State<?, ?> stepNext;
//        if (stateID == 0) {
//            return "addCar";
//        }
//        stepPrev = state.getStateList().get(stateID - 1);
        if (stateID + 1 < state.getStateList().size()) {
            stepNext = state.getStateList().get(stateID + 1);
            stepNext.makeOptions(optionByID);
        }

        log.info("stateID-{}  id-{}  value-{}  status-{}", stateID, id, step.getValue(),
                step.isStatus());
        return "addCar";*/
    }

    @GetMapping("/resetState")
    public String resetState(final @RequestParam(name = "stateID") int stateID,
                             final Model model) {
        CarState state = userSession.getCarState();
        if (state == null) {
            // TODO куда перенаправить
            return "cars/add";
        }
        CarState.State<?, ?> step = state.getStateList().get(stateID);
        if (stateID < 9) {
            List<Generations> generations = state.getGenerations();
            state.getStateList().get(stateID).resetStatusGen(state.getGenerations());
            int step1 = stateID + 1;
            for (int i = stateID + 1; i < 9; i++) {
                state.getStateList().get(i).resetOption();
            }
        } else {
            state.getStateList().get(stateID).resetStatus();
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

    @PostMapping("/save")
    public String savePost(final @ModelAttribute(name = "carform") CarDto carDto,
                           final Model model) {
        log.info("{}", carDto);

        return "addCar";
    }
}
