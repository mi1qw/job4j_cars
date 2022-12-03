package com.example.car.controller;

import com.example.car.Cleaner;
import com.example.car.Migrator;
import com.example.car.SessionTracking;
import com.example.car.UserTestSession;
import com.example.car.dto.CarDto;
import com.example.car.dto.CarMapper;
import com.example.car.dto.FilterDto;
import com.example.car.model.Car;
import com.example.car.model.City;
import com.example.car.model.Status;
import com.example.car.service.AccountService;
import com.example.car.service.CarService;
import com.example.car.service.CityService;
import com.example.car.store.SessionStore;
import com.example.car.util.CarModfctn;
import com.example.car.util.CarState;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import({Migrator.class, Cleaner.class, SessionTracking.class, UserTestSession.class})
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarFormControllerTest implements SessionStore {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SessionTracking sessions;
    @Autowired
    private UserTestSession userSession;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CarService carService;
    @Autowired
    private CityService cityService;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private Cleaner cleaner;

    @AfterAll
    void cleanDB() {
        cleaner.clean();
    }

    @Test
    @Order(1)
    void getPostById() throws Exception {
        mockMvc.perform(get("/posts/3")
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("carPost"))
                .andExpect(model().attribute("post",
                        allOf(
                                hasProperty("id", is(3L)),
                                hasProperty("mark",
                                        is(hasProperty("id", is(1L)))),
                                hasProperty("model",
                                        is(hasProperty("id", is(2L)))),
                                hasProperty("id", is(3L)),
                                hasProperty("name",
                                        is("Toyota Camry VIII (XV70) Рестайлинг 2021")),
                                hasProperty("account",
                                        is(hasProperty("id", is(1L)))),
                                hasProperty("modification",
                                        is(hasProperty("power", is((short) 249)))),
                                hasProperty("optionsMap", aMapWithSize(5)),
                                hasProperty("images", iterableWithSize(7)))))
                .andReturn();
        assertThat(userSession.getAccount()).isNull();
        assertThat(userSession.getCarState()).isNull();
        assertThat(userSession.getNewCar()).satisfies(
                n -> assertThat(n.getId()).isEqualTo(3L),
                n -> assertThat(n.getName()).isEqualTo("Toyota Camry VIII (XV70) Рестайлинг 2021"),
                n -> assertThat(n.getAccount().getId()).isEqualTo(1L),
                n -> assertThat(n.getModification().getPower()).isEqualTo((short) 249));
        assertThat(userSession.getFilterForm()).satisfies(
                n -> assertThat(n.getParams().size()).isEqualTo(0),
                n -> assertThat(n.getFilterDto().getMark()).isNull(),
                n -> assertThat(n.getFilterDto().getSort()).isEqualTo(3),
                n -> assertThat(n.getBaseQuery()).isEqualTo("select c from Car c")
        );
        assertThat(userSession.getBreadcrumb()).satisfies(
                n -> assertThat(n.getParams().size()).isEqualTo(6),
                n -> assertThat(n.getFilterDto().getMark()).isEqualTo(1L),
                n -> assertThat(n.getFilterDto().getModel()).isEqualTo(2L),
                n -> assertThat(n.getFilterDto().getSort()).isEqualTo(3),
                n -> assertThat(n.getBaseQuery()).isEqualTo("select c from Car c")
        );

        mockMvc.perform(get("/posts/21")
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andReturn();
    }

    @Test
    @Order(2)
    void failureLogInWhenWrongInputParametr() throws Exception {
        mockMvc.perform(post("/logIn")
                        .session(sessions.getLastSession())
                        .param("login", "ann@gmail.com")
                        .param("password", "0")
                )
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts?fail=true"))
                .andReturn();
        assertThat(userSession.getAccount()).isNull();
    }

    @Test
    @Order(3)
    void failureLogInWhenWrongPassword() throws Exception {
        mockMvc.perform(post("/logIn")
                        .session(sessions.getLastSession())
                        .param("login", "ann@gmail.com")
                        .param("password", "000")
                )
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts?fail=true"));
        assertThat(userSession.getAccount()).isNull();
    }

    @Test
    @Order(4)
    void sucessfulyLogIn() throws Exception {
        log.info("{}", userSession.getAccount());
        mockMvc.perform(post("/logIn")
                        .session(sessions.getLastSession())
                        .param("login", "ann@gmail.com")
                        .param("password", "111")
                )
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts"));
        assertThat(userSession.getAccount()).satisfies(
                n -> assertThat(n.getLogin()).isNull(),
                n -> assertThat(n.getFirstName()).isEqualTo("Ann"));
    }

    @Test
    @Order(5)
    void myPostsShouldReturnMyCarPosts() throws Exception {
        log.info("{}", userSession.getAccount());
        mockMvc.perform(get("/myposts").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("myPosts"))
                .andExpect(model().attribute("onSale", hasSize(5)))
                .andExpect(model().attribute("onSale",
                        allOf(
                                containsInRelativeOrder(isA(Car.class)),
                                hasSize(5))));
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");
    }

    @Test
    @Order(6)
    void changeStatusOfMyCarPost() throws Exception {
        Car car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.onSale);

        mockMvc.perform(get("/myposts").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("myPosts"))
                .andExpect(model().attribute("onSale", hasSize(5)))
                .andExpect(model().attribute("notActive", nullValue()));

        mockMvc.perform(post("/myposts/status").session(sessions.getLastSession())
                        .param("id", "10")
                        .param("value", "false"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.notActive);

        mockMvc.perform(get("/myposts").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("myPosts"))
                .andExpect(model().attribute("onSale", hasSize(4)))
                .andExpect(model().attribute("notActive", hasSize(1)));

        mockMvc.perform(post("/myposts/status").session(sessions.getLastSession())
                        .param("id", "10")
                        .param("value", "true"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.onSale);

        mockMvc.perform(get("/myposts").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("myPosts"))
                .andExpect(model().attribute("onSale", hasSize(5)))
                .andExpect(model().attribute("notActive", nullValue()));
    }

    @Test
    @Order(7)
    void addNewCarPost() throws Exception {
        mockMvc.perform(get("/cars/add").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", nullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getCarState().getStepList().get(0).isStatus()).isFalse();
        assertThat(userSession.getCarState().getStepList().get(0).getOptions()).isNotEmpty();
        log.info("{}", userSession.getCarState().getStepList().get(0).getOptions());
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");
        log.info("getNewCar().getId() {}", userSession.getNewCar().getId());
    }

    @Test
    @Order(10)
    void selectMark() throws Exception {
        mockMvc.perform(get("/cars/addState").session(sessions.getLastSession())
                        .param("id", "3")
                        .param("stateID", "0"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", nullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getCarState().getStepList().get(0).isStatus()).isTrue();
        assertThat(userSession.getCarState().getStepList().get(1).getOptions()).isNotEmpty();
        log.info("{}", userSession.getCarState().getStepList().get(1).getOptions());
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");
    }

    @Test
    @Order(11)
    void selectModel() throws Exception {
        mockMvc.perform(get("/cars/addState").session(sessions.getLastSession())
                        .param("id", "1")
                        .param("stateID", "1"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", nullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getCarState().getStepList().get(1).isStatus()).isTrue();
        assertThat(userSession.getCarState().getStepList().get(2).getOptions()).isNotEmpty();
        log.info("{}", userSession.getCarState().getStepList().get(2).getOptions());
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");

        userSession.getCarState().getStepList()
                .stream().takeWhile(CarState.State::isStatus)
                .forEach(n -> log.info("{}.{} - {}", n.getStep(), n.getName(), n.getValue()));


    }

    private static Long newCarId;

    @Test
    @Order(12)
    void selectColor() throws Exception {
        mockMvc.perform(get("/cars/addState").session(sessions.getLastSession())
                        .param("id", "2")
                        .param("stateID", "9"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", notNullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getCarState().getStepList().get(9).isStatus()).isTrue();
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");
        userSession.getCarState().getStepList()
                .stream().takeWhile(CarState.State::isStatus)
                .forEach(n -> log.info("{}.{} - {}", n.getStep(), n.getName(), n.getValue()));
        log.info("isDone {}", userSession.getCarState().isDone());
        assertThat(userSession.getCarState().isDone()).isTrue();
        newCarId = userSession.getNewCar().getId();
        log.info("newCarId {}", newCarId);
    }


    @Test
    @Order(121)
    void uploadImageOfCar() throws Exception {
        MockMultipartFile file1 = new MockMultipartFile(
                "files",
                "imgCar1.jpg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "image1 of my old Car".getBytes());
        MockMultipartFile file2 = new MockMultipartFile(
                "files",
                "imgCar2.jpg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "image2 of my old Car".getBytes());
        mockMvc.perform(multipart("/cars/upload")
                        .file(file1)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        mockMvc.perform(multipart("/cars/upload")
                        .file(file2)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());

        log.info("{}", userSession.getNewCar().getImages());
        assertThat(userSession.getNewCar().getImages().size()).isEqualTo(2);
    }

    @Test
    @Order(122)
    void getImg() throws Exception {
        assertThat(isExistImage(userSession.getNewCar().getImages().get(0))).isTrue();
        assertThat(isExistImage(userSession.getNewCar().getImages().get(1))).isTrue();
    }


    @Test
    @Order(123)
    void deleteImageOfCarShouldDeleteFile() throws Exception {
        List<String> prevImages = new ArrayList<>(userSession.getNewCar().getImages());
        MockMultipartFile file3 = new MockMultipartFile(
                "files",
                "imgCar3.jpg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "image3 of my old Car".getBytes());

        mockMvc.perform(multipart("/cars/upload")
                        .file(file3)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        assertThat(userSession.getNewCar().getImages().size()).isEqualTo(3);
        log.info("{}", userSession.getNewCar().getImages());

        List<String> images = userSession.getNewCar().getImages();
        images.removeAll(prevImages);
        assertThat(images.size()).isEqualTo(1);
        String img3 = images.get(0);
        assertThat(isExistImage(img3)).isTrue();

        mockMvc.perform(post("/cars/removeImg")
                        .session(sessions.getLastSession())
                        .param("value", img3))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        assertThat(userSession.getNewCar().getImages().size()).isEqualTo(2);
        log.info("{} have been removed", img3);

        Exception exception = assertThrows(ServletException.class, () ->
                isExistImage(img3));
        String expectedMessage = "Could not read file: 1-2-imgCar3.jpg";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @Order(124)
    void reorderImageOfCarShouldChangeCarImmage() throws Exception {
        List<String> images = userSession.getNewCar().getImages();
        assertThat(images).asList().containsExactly(images.get(0), images.get(1));
        String newOrder = images.get(1) + "|" + images.get(0);
        mockMvc.perform(post("/cars/reorder")
                        .session(sessions.getLastSession())
                        .param("value", newOrder))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        assertThat(userSession.getNewCar().getImages())
                .asList().containsExactly(images.get(1), images.get(0));
    }

    @Test
    @Order(130)
    void saveCarPost() throws Exception {
        City city = cityService.findById(1L);
        mockMvc.perform(post("/cars/add").session(sessions.getLastSession())
                        .flashAttr("carform", CarDto.builder()
                                .images(imgMapToString(userSession.getNewCar().getImages()))
                                .description("description")
                                .odometer((short) 11)
                                .price(BigDecimal.valueOf(50000L))
                                .yearPurchase((short) 2020)
                                .city(city)
                                .build()))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/myposts"))
                .andExpect(redirectedUrl("/myposts"));
        assertThat(userSession.getCarState()).isNull();
        assertThat(userSession.getNewCar()).isNull();
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");

        CarModfctn carModfctn = carService.findCarPost(newCarId);
        log.info("{}", carModfctn.car().getName());
        log.info("{}", carModfctn.car().getStatus());
        log.info("{}", carModfctn.account().getFirstName());
        assertThat(carService.findCarPost(newCarId)).satisfies(
                n -> assertThat(n.car().getName())
                        .isEqualTo("Mercedes-Benz A-Класс IV (W177) 2021"),
                n -> assertThat(n.car().getStatus()).isEqualTo(Status.onSale),
                n -> assertThat(n.account().getFirstName()).isEqualTo("Ann")
        );
    }

    @Test
    @Order(140)
    void editCarPost() throws Exception {
        mockMvc.perform(get("/cars/edit/{id}", newCarId)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", notNullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");

        CarDto carDto = carMapper.carToDto(userSession.getNewCar());
        carDto.setImages(imgMapToString(userSession.getNewCar().getImages()));
        carDto.setDescription(carDto.getDescription() + " Test");

        mockMvc.perform(post("/cars/add").session(sessions.getLastSession())
                        .flashAttr("carform", carDto))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/myposts"))
                .andExpect(redirectedUrl("/myposts"));
        log.info("{}", carService.findCarPost(newCarId).car().getDescription());
        assertThat(carService.findCarPost(newCarId)).satisfies(
                n -> assertThat(n.car().getName())
                        .isEqualTo("Mercedes-Benz A-Класс IV (W177) 2021"),
                n -> assertThat(n.car().getStatus()).isEqualTo(Status.onSale),
                n -> assertThat(n.account().getFirstName()).isEqualTo("Ann"),
                n -> assertThat(n.car().getDescription()).isEqualTo("description Test")
        );
    }

    @Test
    @Order(145)
    void editCarPostAndResetState() throws Exception {
        mockMvc.perform(get("/cars/edit/{id}", newCarId)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("addCar"))
                .andExpect(model().attribute("carform", notNullValue()))
                .andExpect(model().attributeExists("reverse"));
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");

        mockMvc.perform(get("/cars/resetState").session(sessions.getLastSession())
                        .param("stateID", "1"))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/cars/addState"))
                .andExpect(redirectedUrl("/cars/addState"));
        CarState carState = userSession.getCarState();
        assertThat(carState.isDone()).isFalse();
    }

    @Test
    @Order(150)
    void deleteCarPost() throws Exception {
        mockMvc.perform(get("/myposts/deleteCar/{id}", newCarId)
                        .session(sessions.getLastSession())
                        .param("id", newCarId.toString()))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/myposts"))
                .andExpect(redirectedUrl("/myposts"));
        assertThat(carService.getCar(newCarId)).isNull();
    }

    @Test
    @Order(160)
    void mainPageWithListOfCarPosts() throws Exception {
        mockMvc.perform(get("/posts").session(sessions.getLastSession())
                        .flashAttr("filter",
                                FilterDto.builder()
                                        .sort(3)
                                        .build())
                        .param("page", "1"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("posts"))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attributeExists("totalPages"))
                .andExpect(model().attributeExists("filter"))
                .andExpect(model().attribute("posts",
                        containsInRelativeOrder(isA(Car.class))));
    }

    @Test
    @Order(170)
    void filterGetModelsMersShouldReturnJsonModels() throws Exception {
        mockMvc.perform(get("/cars/models").session(sessions.getLastSession())
                        .param("id", "3"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType("application/json;charset=utf-8"))
                .andExpect(content().contentTypeCompatibleWith("application/json"))
                .andExpect(content().json("{\"1\":\"A-Класс\"}"));
    }

    @Test
    @Order(180)
    void filterPostsByMarkMersShouldReturnOnlyMers1() throws Exception {
        mockMvc.perform(get("/posts").session(sessions.getLastSession())
                        .flashAttr("filter",
                                FilterDto.builder()
                                        .mark(3L)
                                        .sort(3)
                                        .build()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("posts"))
                .andExpect(model().attributeExists("page"))
                .andExpect(model().attributeExists("totalPages"))
                .andExpect(model().attributeExists("filter"))
                .andExpect(model().attribute("posts",
                        containsInRelativeOrder(isA(Car.class))))
                .andExpect(model().attribute("posts",
                        hasItems(hasProperty("mark", is(
                                hasProperty("id", is(3L)))))));
    }

    @Test
    @Order(190)
    void breadCrumbsPostsByMarkShouldReturnOnlyOneMark() throws Exception {
        assertThat(sessions.getUserSession().getFilterForm().getParams()).satisfies(
                (n) -> assertThat(n.size()).isEqualTo(2),
                (n) -> assertThat(n).extracting("name")
                        .containsExactlyInAnyOrder("status", "mark"));
        assertThat(sessions.getUserSession().getBreadcrumb().getParams()).satisfies(
                (n) -> assertThat(n.size()).isEqualTo(6),
                (n) -> assertThat(n).extracting("name")
                        .containsExactlyInAnyOrder("status", "city", "mark",
                                "model", "body", "engine"));

        MvcResult result = mockMvc.perform(get("/posts/slice/{nameFilter}", "model")
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts"))
                .andReturn();

        assertThat(sessions.getUserSession().getFilterForm().getParams()).satisfies(
                (n) -> assertThat(n.size()).isEqualTo(4),
                (n) -> assertThat(n).extracting("name")
                        .containsExactlyInAnyOrder("status", "city", "mark", "model"));
        assertThat(sessions.getUserSession().getBreadcrumb().getParams()).satisfies(
                (n) -> assertThat(n.size()).isEqualTo(4),
                (n) -> assertThat(n).extracting("name")
                        .containsExactlyInAnyOrder("status", "city", "mark", "model"));
    }

    @Test
    @Order(200)
    void logOut() throws Exception {
        mockMvc.perform(get("/logout").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts"));
        assertThat(userSession.getAccount()).isNull();
    }

    @Test
    @Order(210)
    void exception404() throws Exception {
        mockMvc.perform(get("/posts1").session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is4xxClientError());
        assertThat(userSession.getAccount()).isNull();
    }

    @Test
    @Order(220)
    void signinWithWrongFormatLoginShouldReturnErrorField() throws Exception {
        mockMvc.perform(post("/signIn")
                        .param("firstName", "firstName")
                        .param("lastName", "lastName")
                        .param("login", "login")
                        .param("password", "password")
                        .param("phoneNumber", "095 5555555")
                        .param("city", "1"))
                .andExpect(view().name("signin"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrorCode("account",
                        "login", "EmailReg"));
    }

    @Test
    @Order(230)
    void signinWithExistingLoginShouldReturnErrorField() throws Exception {
        mockMvc.perform(post("/signIn")
                        .param("firstName", "firstName")
                        .param("lastName", "lastName")
                        .param("login", "ann@gmail.com")
                        .param("password", "password")
                        .param("phoneNumber", "095 5555555")
                        .param("city", "1"))
                .andExpect(view().name("signin"))
                .andExpect(model().errorCount(2))
                .andExpect(model().attributeHasFieldErrorCode("account",
                        "login", "NotExistingAccount"));
    }

    @Test
    @Order(240)
    void signinWithCorrectDataAccountShouldSaveInDatabse() throws Exception {
        mockMvc.perform(post("/signIn")
                        .param("firstName", "firstName")
                        .param("lastName", "lastName")
                        .param("login", "bob@gmail.com")
                        .param("password", "password")
                        .param("phoneNumber", "095 5555555")
                        .param("city", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/posts"))
                .andExpect(model().errorCount(0));
        assertThat(accountService.findUserByLogin("bob@gmail.com").orElse(null)).isNotNull();
        log.info("{}", accountService.findUserByLogin("bob@gmail.com").get().getId());
    }

    private boolean isExistImage(final String name) throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/cars/img/{img}", name)
                        .session(sessions.getLastSession()))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        log.info("getImg= {}", content);
        return content.matches("image\\d of my old Car");
    }

    private String imgMapToString(final List<String> images) {
        return String.join("|", images);
    }
}
