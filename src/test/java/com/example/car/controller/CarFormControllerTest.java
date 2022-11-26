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
import com.example.car.service.CarService;
import com.example.car.service.CityService;
import com.example.car.store.SessionStore;
import com.example.car.util.CarModfctn;
import com.example.car.util.CarState;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        mockMvc.perform(post("/myposts/status").session(sessions.getLastSession())
                        .param("id", "10")
                        .param("value", "false"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.notActive);

        mockMvc.perform(post("/myposts/status").session(sessions.getLastSession())
                        .param("id", "10")
                        .param("value", "true"))
                .andDo(sessions)
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.onSale);
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
    @Order(13)
    void saveCarPost() throws Exception {
        City city = cityService.findById(1L);
        mockMvc.perform(post("/cars/add").session(sessions.getLastSession())
                        .flashAttr("carform", CarDto.builder()
                                .images("image.jpg")
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
    @Order(14)
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
        carDto.setImages("image.jpg");
        carDto.setDescription(carDto.getDescription() + " Test");

        mockMvc.perform(post("/cars/add").session(sessions.getLastSession())
                        .flashAttr("carform", carDto))
                .andDo(sessions)
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/myposts"))
                .andExpect(redirectedUrl("/myposts"));
        assertThat(userSession.getAccount().getFirstName()).isEqualTo("Ann");
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
    @Order(15)
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
    @Order(16)
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
    @Order(17)
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
    @Order(18)
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
    @Order(19)
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
    void getImg() {
    }

    @Test
    void resetState() {
    }

    @Test
    void upload() {
    }
}
