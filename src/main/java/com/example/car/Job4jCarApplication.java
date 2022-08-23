package com.example.car;

import com.example.car.model.*;
import com.example.car.store.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Job4jCarApplication {
    @Autowired
    private AccountStore accountStore;
    @Autowired
    private MarkStore markStore;
    @Autowired
    private ModelStore modelStore;
    @Autowired
    private BodyStore bodyStore;
    @Autowired
    private EngineStore engineStore;
    @Autowired
    private TransmissionStore transmissionStore;
    @Autowired
    private GearboxStore gearboxStore;
    @Autowired
    private GenerationsStore generationsStore;
    @Autowired
    private ModificationStore modificationStore;
    @Autowired
    private ColorStore colorStore;

    public static void main(final String[] args) {
        SpringApplication.run(Job4jCarApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader() {
        return args -> {
            List<Account> all = accountStore.findAll();
//            if (all.isEmpty()) {
            if (true) {
//                City cityA = new City("cityA");
//                City cityB = new City("cityB");
//                Account ann = new Account("Ann", "Lebovsky", "ann@gmail.com",
//                        "111", "111-111-111", cityA);
//                accountStore.add(ann);
//                Account vasya = new Account("Vasya", "Lebovsky", "vasya@gmail.com",
//                        "111", "111-111-111", cityB);
//                accountStore.add(vasya);


                try {
                    colorStore.add(new Color("red", "red"));
                    colorStore.add(new Color("black", "black"));
                } catch (Exception ignored) {
                }


                Mark toyota;
                Mark bmw;
                Mark mercedes;
                Mark vaz;
                try {
                    toyota = markStore.add(new Mark("Toyota", "aaa"));
                    bmw = markStore.add(new Mark("BMW", "aaa"));
                    mercedes = markStore.add(new Mark("Mercedes-Benz", "aaa"));
                    vaz = markStore.add(new Mark("LADA (ВАЗ)", "aaa"));
                } catch (Exception ignored) {
                }

                toyota = markStore.findByName("Toyota").get(0);
                try {
                    Model camry = modelStore.add(new Model("Camry", toyota));
                    Model crown = modelStore.add(new Model("Crown", toyota));  // 2018
                } catch (Exception ignored) {
                }


                try {
                    bodyStore.add(new Body("Седан", "Седан"));
                    bodyStore.add(new Body("Хэтчбек", "Хэтчбек"));
                    bodyStore.add(new Body("Лифтбек", "Лифтбек"));
                    bodyStore.add(new Body("Внедорожник", "Внедорожник"));
                    bodyStore.add(new Body("Универсал", "Универсал"));
                    bodyStore.add(new Body("Купе", "Купе"));
                    bodyStore.add(new Body("Мнинвэн", "Мнинвэн"));
                    bodyStore.add(new Body("Пикап", "Пикап"));
                    bodyStore.add(new Body("Лимузин", "Лимузин"));
                    bodyStore.add(new Body("Фургон", "Фургон"));
                    bodyStore.add(new Body("Кабриолет", "Кабриолет"));
                } catch (Exception ignored) {
                }


                try {
                    engineStore.add(new Engine("Бензин", "Бензин"));
                    engineStore.add(new Engine("Дизель", "Дизель"));
                    engineStore.add(new Engine("Гибрид", "Гибрид"));
                    engineStore.add(new Engine("Электро", "Электро"));
                } catch (Exception ignored) {
                }


                try {
                    transmissionStore.add(new Transmission("Любой", "Любой"));
                    transmissionStore.add(new Transmission("Передний", "Передний"));
                    transmissionStore.add(new Transmission("Задний", "Задний"));
                    transmissionStore.add(new Transmission("Полный", "Полный"));
                } catch (Exception ignored) {
                }


                try {
                    gearboxStore.add(new Gearbox("Автомат", "Автомат"));
                    gearboxStore.add(new Gearbox("Робот", "Робот"));
                    gearboxStore.add(new Gearbox("Вариатор", "Вариатор"));
                    gearboxStore.add(new Gearbox("Механическая", "Механическая"));
                } catch (Exception ignored) {
                }


                try {
                    ModificationId id = new ModificationId("3.5CVT 299л.с", (short) 2018,
                            markStore.findByName("Toyota").get(0));
                    modificationStore.add(new Modification(id, (short) 299, (short) 3456,
                            (byte) 6, "V-engine"));

                    id = new ModificationId("2.5CVT 184л.с", (short) 2018,
                            markStore.findByName("Toyota").get(0));
                    modificationStore.add(new Modification(id, (short) 184, (short) 2487,
                            (byte) 4, "V-engine"));
                } catch (Exception ignored) {
                }

//                Mark toyota1 = markStore.findByName("Toyota").get(0);
//                Modification cvt = modificationStore.findByName("CVT").get(0);

                generationsStore.add(
                        new Generations("name", "image",
                                (short) 2000,
                                markStore.findByName("Toyota").get(0),
                                modelStore.findByName("Camry").get(0),
                                bodyStore.findByName("Седан").get(0),
                                engineStore.findByName("Бензин").get(0),
                                transmissionStore.findByName("Передний").get(0),
                                gearboxStore.findByName("Автомат").get(0),
                                modificationStore.findByName("2.5CVT 184л.с").get(0))
                );

                generationsStore.add(
                        new Generations("XV (S220)", "image1",
                                (short) 2018,
                                markStore.findByName("Toyota").get(0),
                                modelStore.findByName("Crown").get(0),
                                bodyStore.findByName("Седан").get(0),
                                engineStore.findByName("Гибрид").get(0),
                                transmissionStore.findByName("Задний").get(0),
                                gearboxStore.findByName("Вариатор").get(0),
                                modificationStore.findByName("2.5CVT 184л.с").get(0))
                );
                generationsStore.add(
                        new Generations("XIV (S210)", "image1",
                                (short) 2018,
                                markStore.findByName("Toyota").get(0),
                                modelStore.findByName("Crown").get(0),
                                bodyStore.findByName("Седан").get(0),
                                engineStore.findByName("Гибрид").get(0),
                                transmissionStore.findByName("Задний").get(0),
                                gearboxStore.findByName("Вариатор").get(0),
                                modificationStore.findByName("2.5CVT 184л.с").get(0))
                );
                generationsStore.add(
                        new Generations("XIV (S210)", "image1",
                                (short) 2018,
                                markStore.findByName("Toyota").get(0),
                                modelStore.findByName("Crown").get(0),
                                bodyStore.findByName("Седан").get(0),
                                engineStore.findByName("Бензин").get(0),
                                transmissionStore.findByName("Задний").get(0),
                                gearboxStore.findByName("Вариатор").get(0),
                                modificationStore.findByName("3.5CVT 299л.с").get(0))
                );
            }
        };


    }
}
