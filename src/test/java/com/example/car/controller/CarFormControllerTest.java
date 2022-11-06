package com.example.car.controller;

import com.example.car.Migrator;
import com.example.car.SessionTracking;
import com.example.car.UserTestSession;
import com.example.car.model.Car;
import com.example.car.model.Status;
import com.example.car.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@WebMvcTest
@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebMvc
@AutoConfigureMockMvc
//@EnableWebMvc
@Import({Migrator.class, SessionTracking.class, UserTestSession.class})
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarFormControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    SessionTracking sessions;
    @Autowired
    UserTestSession userSession;
    //    @Autowired
//    private TestRestTemplate restTemplate;
//    @LocalServerPort
//    private int port;

    @Autowired
    private CarService carService;
    //@Autowired
//private WebMvcTest webMvcTest;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private CarMapper carMapper;
//    @Autowired
//    private PostMapper postMapper;

//    @Autowired
//    private CityService cityService;
//    @Autowired
//    private BodyService bodyService;
//    @Autowired
//    private ColorService colorService;
//    @Autowired
//    private EngineService engineService;
//    @Autowired
//    private GearboxService gearboxService;
//    @Autowired
//    private MarkService markService;
//    @Autowired
//    private ModelService modelService;
//    @Autowired
//    private OptionsService optionsService;
//    @Autowired
//    private TransmissionService transmissionService;
//
//    @Autowired
//    private CityStore cityStore;
//    @Autowired
//    private ModificationStore modificationStore;

    @Test
    @Order(1)
    void getPostById() throws Exception {


//        Car newCar = userSession.getNewCar();
//        log.info("newCar {}", newCar == null);

//        int length = restTemplate.getForObject("http://localhost:" + port + "/posts/3",
//                        String.class)
//                .length();
//        Thread.sleep(500);
//        restTemplate.getForObject("http://localhost:" + port + "/posts/3",
//                String.class);
//        Thread.sleep(500);


//        ResponseEntity<String> response
//                = restTemplate.getForEntity("http://localhost:" + port + "/posts/3", String
//                .class);
//
////        log.info("{}", response.getHeaders().entrySet());
//        log.info("получили {}", response.getHeaders().get("Set-Cookie"));
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.addAll("Set-Cookie", response.getHeaders().get("Set-Cookie"));
//        HttpEntity<Integer> request = new HttpEntity<>(headers);
//        response = restTemplate.exchange(
//                "http://localhost:" + port + "/posts/3",
//                HttpMethod.GET,
//                request,
//                String.class,
//                "get"
//        );
//        log.info("получили {}", response.getHeaders().get("Set-Cookie"));
//        log.info("Session {}", userSession != null);
//        log.info("{}", userSession.getFilterForm());

//
//        ResponseEntity<?> response = restTemplate.exchange(
//                "http://localhost:" + port + "/add",
//                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
//                });
//
//        response = restTemplate.exchange(
//                "http://localhost:" + port + "/posts/3",
//                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
//                });
//        response.

//        log.info("{}", response);
        mockMvc.perform(get("/posts/3")
                        .session(sessions.getLastSession()))
                .andDo(sessions)
//                .andDo(print())
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
                .andDo(print())
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
                .andDo(print())
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
                .andDo(print())
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
                .andDo(print())
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
                .andDo(print())
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
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.notActive);

        mockMvc.perform(post("/myposts/status").session(sessions.getLastSession())
                        .param("id", "10")
                        .param("value", "true"))
                .andDo(sessions)
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
        car = carService.getCar(10L);
        assertThat(car.getStatus()).isEqualTo(Status.onSale);
    }

    @Test
    void removeImg() {
    }

    @Test
    void getImg() {
    }


    @Test
    void edit() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void resetState() {
    }

    @Test
    void upload() {
    }

    @Test
    void savePost() {
    }

    @Test
    void getModels() {
    }
}


//        MockHttpServletRequest request = mvcResult.getRequest();
//        HttpSession session = Objects.requireNonNull(request.getSession());
//        log.info("session.getId {}", session.getId());
//        UserSession userSession = (UserSession) session.getAttribute("scopedTarget.userSession");