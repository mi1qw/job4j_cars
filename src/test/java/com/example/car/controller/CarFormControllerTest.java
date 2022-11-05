package com.example.car.controller;

import com.example.car.Migrator;
import com.example.car.model.Car;
import com.example.car.web.UserSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(CarFormController.class)
//@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
//@AutoConfigureMockMvc
@EnableWebMvc
@Import({Migrator.class})
@Slf4j
class CarFormControllerTest {
    @Autowired
    private CarFormController carFormController;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    //    @Autowired
//    private MockMvc mockMvc;
    @Autowired
    private UserSession userSession;

//@Autowired
//private WebMvcTest webMvcTest;
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private CarMapper carMapper;
//    @Autowired
//    private PostMapper postMapper;
//    @Autowired
//    private CarService carService;
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
    void add() throws Exception {

//        carFormController.
//        Car newCar = userSession.getNewCar();
//        log.info("newCar {}", newCar == null);

        int length = restTemplate.getForObject("http://localhost:" + port + "/add",
                        String.class)
                .length();


        ResponseEntity<?> response = restTemplate.exchange(
                "http://localhost:" + port + "/add",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        response = restTemplate.exchange(
                "http://localhost:" + port + "/posts/3",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
//        response.

        log.info("{}", response);
//        MvcResult mvcResult = mockMvc.perform(get("/add"))
//                .andDo(print())
//                .andExpect(status().isFound())
//                .andReturn();//                .andExpect(content().string
// (containsString(" ")))

//        MockHttpServletRequest request = mvcResult.getRequest();
//        UserSession userSession = (UserSession) Objects.requireNonNull(request.getSession())
//                .getAttribute("scopedTarget.userSession");

        Car newCar = userSession.getNewCar();
        log.info("newCar {}", newCar == null);
    }

    @Test
    void reorder() {
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