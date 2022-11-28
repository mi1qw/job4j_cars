package com.example.car;

import com.example.car.model.*;
import com.example.car.service.*;
import com.example.car.store.*;
import com.example.car.web.AppScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

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
    @Autowired
    private CityStore cityStore;
    @Autowired
    private FileSystemStore fileSystemStore;
    @Autowired
    private OptionsStore optionsStore;
    @Autowired
    private AppScope appScope;
    @Autowired
    private CityService cityService;
    @Autowired
    private BodyService bodyService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private EngineService engineService;
    @Autowired
    private GearboxService gearboxService;
    @Autowired
    private MarkService markService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OptionsService optionsService;
    @Autowired
    private TransmissionService transmissionService;


    public static void main(final String[] args) {
        SpringApplication.run(Job4jCarApplication.class, args);
    }


    /**
     * ставим в разработке @Bean.
     * оставил для примера
     *
     * @return CommandLineRunner
     */
    public CommandLineRunner dataLoader() {
        return args -> {
            fileSystemStore.init();
            try {
                colorStore.add(new Color("Чёрный", "black"));
                colorStore.add(new Color("Серебристый", "silver"));
                colorStore.add(new Color("Белый", "white"));
                colorStore.add(new Color("Серый", "gray"));
                colorStore.add(new Color("Синий", "blue"));
                colorStore.add(new Color("Красный", "red"));
                colorStore.add(new Color("Зелёный", "green"));
                colorStore.add(new Color("Коричневый", "brown"));
                colorStore.add(new Color("Бежевый", "beige"));
                colorStore.add(new Color("Голубой", "sky"));
                colorStore.add(new Color("Золотистый", "gold"));
                colorStore.add(new Color("Пурпурный", "magenta"));
                colorStore.add(new Color("Фиолетовый", "purple"));
                colorStore.add(new Color("Жёлтый", "yellow"));
                colorStore.add(new Color("Оранжевый", "orange"));
                colorStore.add(new Color("Розовый", "pink"));
            } catch (Exception ignored) {
            }


            Mark toyota;
            try {
                markStore.add(new Mark("Toyota", "logoToyota.png"));
                markStore.add(new Mark("BMW", "logoBMW.png"));
                markStore.add(new Mark("Mercedes-Benz", "logoMers.png"));
                markStore.add(new Mark("LADA (ВАЗ)", "logoVaz.png"));
                markStore.add(new Mark("Audi", "logoAudi.png"));
                markStore.add(new Mark("Hyundai", "logoHyundai.png"));
                markStore.add(new Mark("Kia", "logoKia.png"));
                markStore.add(new Mark("Nissan", "logoNissan.png"));
                markStore.add(new Mark("Renault", "logoRenault.png"));
                markStore.add(new Mark("Skoda", "logoSkoda.png"));
                markStore.add(new Mark("VW", "logoVW.png"));
            } catch (Exception ignored) {
            }

            toyota = markStore.findByName("Toyota").get(0);
            try {
                modelStore.add(new Model("A-Класс", markStore.findByName("Mercedes-Benz").get(0)));
                modelStore.add(new Model("Camry", toyota));
                modelStore.add(new Model("Crown", toyota));
                modelStore.add(new Model("2 серии", markStore.findByName("BMW").get(0)));
            } catch (Exception ignored) {
            }


            try {
                bodyStore.add(new Body("Седан", "sedan-side.png"));
                bodyStore.add(new Body("Хэтчбек", "hatch5d-side.png"));
                bodyStore.add(new Body("Лифтбек", "liftback-side.png"));
                bodyStore.add(new Body("Внедорожник", "suv5d-side.png"));
                bodyStore.add(new Body("Универсал", "universal-side.png"));
                bodyStore.add(new Body("Купе", "coupe-side.png"));
                bodyStore.add(new Body("Мнинвэн", "vclasse-side.png"));
                bodyStore.add(new Body("Пикап", "Пикап"));
                bodyStore.add(new Body("Лимузин", "Лимузин.png"));
                bodyStore.add(new Body("Фургон", "van-side.png"));
                bodyStore.add(new Body("Кабриолет", "cabrio-side.png"));
            } catch (Exception ignored) {
            }


            try {
                engineStore.add(new Engine("Бензин", "#gasoline"));
                engineStore.add(new Engine("Дизель", "#diesel"));
                engineStore.add(new Engine("Гибрид", "#hybrid"));
                engineStore.add(new Engine("Электро", "#electro"));
            } catch (Exception ignored) {
            }


            try {
                transmissionStore.add(new Transmission("Передний", "#forward-control"));
                transmissionStore.add(new Transmission("Задний", "#rear-drive"));
                transmissionStore.add(new Transmission("Полный", "#all-wheel-drive"));
            } catch (Exception ignored) {
            }


            try {
                gearboxStore.add(new Gearbox("Автомат", "#automatic"));
                gearboxStore.add(new Gearbox("Робот", "#robot"));
                gearboxStore.add(new Gearbox("Вариатор", "#variator"));
                gearboxStore.add(new Gearbox("Механическая", "#mechanical"));
            } catch (Exception ignored) {
            }

            try {
                cityStore.add(new City("Татуин"));
                cityStore.add(new City("Набу"));
                cityStore.add(new City("Камино"));
                cityStore.add(new City("Эндор"));
                cityStore.add(new City("Джеонозис"));
                cityStore.add(new City("Скариф"));
                cityStore.add(new City("Джакку"));
                cityStore.add(new City("Кашиик"));
                cityStore.add(new City("Корусант"));
                cityStore.add(new City("Дагоба"));
            } catch (Exception ignored) {
            }


            try {
                optionsStore.add(new Options("Обзор", "Светодиодные фары"));
                optionsStore.add(new Options("Обзор", "Противотуманные фары"));
                optionsStore.add(new Options("Обзор", "Дневные ходовые огни"));
                optionsStore.add(new Options("Комфорт", "Бортовой компьютер"));
                optionsStore.add(new Options("Комфорт", "Система доступа без ключа"));
                optionsStore.add(new Options("Защита от угона", "Центральный замок"));
                optionsStore.add(new Options("Защита от угона", "Иммобилайзер"));
                optionsStore.add(new Options("Мультимедиа", "Навигационная система"));
                optionsStore.add(new Options("Мультимедиа", "Мультимедиа система с ЖК-экраном"));
                optionsStore.add(new Options("Салон", "Люк"));
                optionsStore.add(new Options("Салон", "Обогрев рулевого колеса"));
            } catch (Exception ignored) {
            }

            cityService.init();
            bodyService.init();
            colorService.init();
            engineService.init();
            gearboxService.init();
            markService.init();
            modelService.init();
            optionsService.init();
            transmissionService.init();

            try {
                ModificationId id = new ModificationId("136 л.с. (200 / 1.3 MT)", (short) 2018,
                        markStore.findByName("Mercedes-Benz").get(0));
                modificationStore.add(
                        new Modification(id, (short) 136, (short) 1332, (byte) 4, "рядное"));

                id = new ModificationId("3.5 CVT 299 л.с", (short) 2018,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 299, (short) 3456, (byte) 6, "V-образное"));

                id = new ModificationId("2.5 CVT 184 л.с", (short) 2018,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 184, (short) 2487, (byte) 4, "V-образное"));
                id = new ModificationId("2.0 AT 245 л.c.", (short) 2018,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 245, (short) 1998, (byte) 4, "рядное"));
                id = new ModificationId("3.5 AT 249 л.с.", (short) 2021,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 249, (short) 3456, (byte) 6, "V-образное"));
                id = new ModificationId("2.5 AT 203 л.с.", (short) 2021,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 203, (short) 2487, (byte) 4, "рядное"));
                id = new ModificationId("2.5 CVT 208 л.с.", (short) 2021,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 208, (short) 2487, (byte) 4, "рядное"));
                id = new ModificationId("2.5 AT 202 л.с. 4x4", (short) 2021,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 202, (short) 2487, (byte) 4, "рядное"));
                id = new ModificationId("2.5 CVT 178 л.с. 4x4", (short) 2021,
                        markStore.findByName("Toyota").get(0));
                modificationStore.add(
                        new Modification(id, (short) 178, (short) 2487, (byte) 4, "рядное"));
                id = new ModificationId("218i 1.5 MT 140 л.с.", (short) 2019,
                        markStore.findByName("BMW").get(0));
                modificationStore.add(
                        new Modification(id, (short) 140, (short) 1499, (byte) 3, "рядное"));
                id = new ModificationId("2.0 AT 231 л.с.", (short) 2019,
                        markStore.findByName("BMW").get(0));
                modificationStore.add(
                        new Modification(id, (short) 231, (short) 1998, (byte) 4, "рядное"));
                id = new ModificationId("2.0 AT 150 л.с.", (short) 2019,
                        markStore.findByName("BMW").get(0));
                modificationStore.add(
                        new Modification(id, (short) 150, (short) 1995, (byte) 4, "рядное"));
                id = new ModificationId("1.5 MT 136 л.с.", (short) 2019,
                        markStore.findByName("BMW").get(0));
                modificationStore.add(
                        new Modification(id, (short) 136, (short) 1499, (byte) 3, "рядное"));
            } catch (Exception ignored) {
            }


            try {
                generationsStore.add(Generations.builder().name("VIII (XV70) Рестайлинг").image(
                        "VIII(XV70)reystaling.jpg").year((short) 2021).model(
                        modelStore.findByName("Camry").get(0)).body(
                        bodyStore.findByName("Седан").get(0)).engine(
                        engineStore.findByName("Бензин").get(0)).transmission(
                        transmissionStore.findByName("Передний").get(0)).gearbox(
                        gearboxStore.findByName("Автомат").get(0)).modification(
                        modificationStore.findByName("3.5 AT 249 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Система доступа без ключа").get(0),
                                optionsStore.findByName("Центральный замок").get(0),
                                optionsStore.findByName("Навигационная система").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(
                                        0))).build());


                generationsStore.add(Generations.builder().name("VIII (XV70) Рестайлинг").image(
                        "VIII(XV70)reystaling.jpg").year((short) 2021).model(
                        modelStore.findByName("Camry").get(0)).body(
                        bodyStore.findByName("Седан").get(0)).engine(
                        engineStore.findByName("Бензин").get(0)).transmission(
                        transmissionStore.findByName("Передний").get(0)).gearbox(
                        gearboxStore.findByName("Автомат").get(0)).modification(
                        modificationStore.findByName("2.5 AT 203 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Система доступа без ключа").get(0),
                                optionsStore.findByName("Центральный замок").get(0),
                                optionsStore.findByName("Навигационная система").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(
                                        0))).build());

                generationsStore.add(Generations.builder().name("VIII (XV70) Рестайлинг").image(
                        "VIII(XV70)reystaling.jpg").year((short) 2021).model(
                        modelStore.findByName("Camry").get(0)).body(
                        bodyStore.findByName("Седан").get(0)).engine(
                        engineStore.findByName("Бензин").get(0)).transmission(
                        transmissionStore.findByName("Передний").get(0)).gearbox(
                        gearboxStore.findByName("Вариатор").get(0)).modification(
                        modificationStore.findByName("2.5 CVT 208 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Система доступа без ключа").get(0),
                                optionsStore.findByName("Центральный замок").get(0),
                                optionsStore.findByName("Навигационная система").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(
                                        0))).build());


                generationsStore.add(Generations.builder().name("VIII (XV70) Рестайлинг").image(
                        "VIII(XV70)reystaling.jpg").year((short) 2021).model(
                        modelStore.findByName("Camry").get(0)).body(
                        bodyStore.findByName("Седан").get(0)).engine(
                        engineStore.findByName("Бензин").get(0)).transmission(
                        transmissionStore.findByName("Полный").get(0)).gearbox(
                        gearboxStore.findByName("Автомат").get(0)).modification(
                        modificationStore.findByName("2.5 AT 202 л.с. 4x4").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Система доступа без ключа").get(0),
                                optionsStore.findByName("Центральный замок").get(0),
                                optionsStore.findByName("Навигационная система").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(
                                        0))).build());


                generationsStore.add(
                        Generations.builder().name("VIII (XV70)").image("VIII(XV70).jpg").year(
                                (short) 2021).model(modelStore.findByName("Camry").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Автомат").get(0)).modification(
                                modificationStore.findByName("3.5 AT 249 л.с.").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(0),
                                        optionsStore.findByName("Навигационная система").get(0),
                                        optionsStore.findByName("Иммобилайзер").get(0),
                                        optionsStore.findByName("Обогрев рулевого колеса").get(
                                                0))).build());


                generationsStore.add(
                        Generations.builder().name("VIII (XV70)").image("VIII(XV70).jpg").year(
                                (short) 2021).model(modelStore.findByName("Camry").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Гибрид").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Вариатор").get(0)).modification(
                                modificationStore.findByName("2.5 CVT 208 л.с.").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(0),
                                        optionsStore.findByName("Навигационная система").get(0),
                                        optionsStore.findByName("Иммобилайзер").get(0),
                                        optionsStore.findByName("Обогрев рулевого колеса").get(
                                                0))).build());


                generationsStore.add(
                        Generations.builder().name("VIII (XV70)").image("VIII(XV70).jpg").year(
                                (short) 2021).model(modelStore.findByName("Camry").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Гибрид").get(0)).transmission(
                                transmissionStore.findByName("Полный").get(0)).gearbox(
                                gearboxStore.findByName("Вариатор").get(0)).modification(
                                modificationStore.findByName("2.5 CVT 178 л.с. 4x4").get(
                                        0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(0),
                                        optionsStore.findByName("Навигационная система").get(0),
                                        optionsStore.findByName("Иммобилайзер").get(0),
                                        optionsStore.findByName("Обогрев рулевого колеса").get(
                                                0))).build());


                generationsStore.add(
                        Generations.builder().name("F44").image("F44.jpg").year((short) 2019).model(
                                modelStore.findByName("2 серии").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Механическая").get(0)).modification(
                                modificationStore.findByName("218i 1.5 MT 140 л.с.").get(
                                        0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Противотуманные фары").get(0),

                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(
                                                0))).build());
                generationsStore.add(
                        Generations.builder().name("F44").image("F44.jpg").year((short) 2019).model(
                                modelStore.findByName("2 серии").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Автомат").get(0)).modification(
                                modificationStore.findByName("2.0 AT 231 л.с.").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Противотуманные фары").get(0),

                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(
                                                0))).build());


                generationsStore.add(
                        Generations.builder().name("F44").image("F44.jpg").year((short) 2019).model(
                                modelStore.findByName("2 серии").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Робот").get(0)).modification(
                                modificationStore.findByName("218i 1.5 MT 140 л.с.").get(
                                        0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Противотуманные фары").get(0),

                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(
                                                0))).build());
                generationsStore.add(
                        Generations.builder().name("F44").image("F44.jpg").year((short) 2019).model(
                                modelStore.findByName("2 серии").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Полный").get(0)).gearbox(
                                gearboxStore.findByName("Автомат").get(0)).modification(
                                modificationStore.findByName("2.0 AT 231 л.с.").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Противотуманные фары").get(0),

                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName("Центральный замок").get(
                                                0))).build());


                generationsStore.add(Generations.builder().name("F22 Рестайлинг").image(
                        "F22restayling.jpg").year((short) 2019).model(
                        modelStore.findByName("2 серии").get(0)).body(
                        bodyStore.findByName("Купе").get(0)).engine(
                        engineStore.findByName("Дизель").get(0)).transmission(
                        transmissionStore.findByName("Задний").get(0)).gearbox(
                        gearboxStore.findByName("Автомат").get(0)).modification(
                        modificationStore.findByName("2.0 AT 150 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Противотуманные фары").get(0),
                                optionsStore.findByName("Дневные ходовые огни").get(0),

                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(0),
                                optionsStore.findByName("Центральный замок").get(0))).build());
                generationsStore.add(Generations.builder().name("Кабриолет F22 Рестайлинг").image(
                        "F22restaylingCabriolet.jpg").year((short) 2019).model(
                        modelStore.findByName("2 серии").get(0)).body(
                        bodyStore.findByName("Кабриолет").get(0)).engine(
                        engineStore.findByName("Дизель").get(0)).transmission(
                        transmissionStore.findByName("Задний").get(0)).gearbox(
                        gearboxStore.findByName("Автомат").get(0)).modification(
                        modificationStore.findByName("2.0 AT 150 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Противотуманные фары").get(0),
                                optionsStore.findByName("Дневные ходовые огни").get(0),

                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(0),
                                optionsStore.findByName("Центральный замок").get(0))).build());
                generationsStore.add(Generations.builder().name("Кабриолет F22 Рестайлинг").image(
                        "F22restaylingCabriolet.jpg").year((short) 2019).model(
                        modelStore.findByName("2 серии").get(0)).body(
                        bodyStore.findByName("Кабриолет").get(0)).engine(
                        engineStore.findByName("Бензин").get(0)).transmission(
                        transmissionStore.findByName("Задний").get(0)).gearbox(
                        gearboxStore.findByName("Механическая").get(0)).modification(
                        modificationStore.findByName("1.5 MT 136 л.с.").get(0)).options(
                        Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                optionsStore.findByName("Противотуманные фары").get(0),
                                optionsStore.findByName("Дневные ходовые огни").get(0),

                                optionsStore.findByName("Бортовой компьютер").get(0),
                                optionsStore.findByName("Иммобилайзер").get(0),
                                optionsStore.findByName("Обогрев рулевого колеса").get(0),
                                optionsStore.findByName("Центральный замок").get(0))).build());


                generationsStore.add(
                        Generations.builder().name("IV (W177)").image("IV (W177).jpg").year(
                                ((short) 2021)).model(modelStore.findByName("A-Класс").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Передний").get(0)).gearbox(
                                gearboxStore.findByName("Механическая").get(0)).modification(
                                modificationStore.findByName("136 л.с. (200 / 1.3 MT)").get(
                                        0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Бортовой компьютер").get(0),
                                        optionsStore.findByName("Центральный замок").get(0),
                                        optionsStore.findByName("Иммобилайзер").get(0),
                                        optionsStore.findByName("Обогрев рулевого колеса").get(
                                                0))).build());


                generationsStore.add(
                        Generations.builder().name("XV (S220)").image("CrownXV(S220).jpg").year(
                                ((short) 2018)).model(modelStore.findByName("Crown").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Гибрид").get(0)).transmission(
                                transmissionStore.findByName("Задний").get(0)).gearbox(
                                gearboxStore.findByName("Вариатор").get(0)).modification(
                                modificationStore.findByName("2.5 CVT 184 л.с").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName(
                                                "Мультимедиа система с ЖК-экраном").get(
                                                0))).build());

                generationsStore.add(
                        Generations.builder().name("XV (S220)").image("CrownXV(S220).jpg").year(
                                ((short) 2018)).model(modelStore.findByName("Crown").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Задний").get(0)).gearbox(
                                gearboxStore.findByName("Автомат").get(0)).modification(
                                modificationStore.findByName("2.0 AT 245 л.c.").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName(
                                                "Мультимедиа система с ЖК-экраном").get(
                                                0))).build());

                generationsStore.add(
                        Generations.builder().name("XIV (S210)").image("CrownXIV(S210).jpg").year(
                                ((short) 2018)).model(modelStore.findByName("Crown").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Бензин").get(0)).transmission(
                                transmissionStore.findByName("Задний").get(0)).gearbox(
                                gearboxStore.findByName("Автомат").get(0)).modification(
                                modificationStore.findByName("3.5 CVT 299 л.с").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName(
                                                "Мультимедиа система с ЖК-экраном").get(
                                                0))).build());
                generationsStore.add(
                        Generations.builder().name("XIV (S210)").image("CrownXIV(S210).jpg").year(
                                ((short) 2018)).model(modelStore.findByName("Crown").get(0)).body(
                                bodyStore.findByName("Седан").get(0)).engine(
                                engineStore.findByName("Гибрид").get(0)).transmission(
                                transmissionStore.findByName("Задний").get(0)).gearbox(
                                gearboxStore.findByName("Вариатор").get(0)).modification(
                                modificationStore.findByName("2.5 CVT 184 л.с").get(0)).options(
                                Set.of(optionsStore.findByName("Светодиодные фары").get(0),
                                        optionsStore.findByName("Система доступа без ключа").get(0),
                                        optionsStore.findByName(
                                                "Мультимедиа система с ЖК-экраном").get(
                                                0))).build());
            } catch (Exception ignored) {
            }
        };
    }
}
