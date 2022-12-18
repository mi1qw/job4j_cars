## Job4j_car
#### _Сайт объявлений по продаже автомобилей_
* поиск втомобиля по заданной конфигурации
* добавление авто из справочника доступных конфигураций

| <img src="/logo.png" width="64px" height="64px"/> | Linux                                                                                                                                                                | Windows                                                                                                                                                                | Cover                                                                                                                                     |
|---------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
|                                                   | [![Java CI](https://github.com/mi1qw/job4j_cars/actions/workflows/maven.yml/badge.svg?branch=sell)](https://github.com/mi1qw/job4j_cars/actions/workflows/maven.yml) | [![Build status](https://ci.appveyor.com/api/projects/status/ny03m023xk0y48gq/branch/master?svg=true)](https://ci.appveyor.com/project/mi1qw/job4j-cars/branch/master) | [![codecov](https://codecov.io/gh/mi1qw/job4j_cars/branch/sell/graph/badge.svg?token=0knIid3FuN)](https://codecov.io/gh/mi1qw/job4j_cars) |

[![We recommend IntelliJ IDEA](https://www.elegantobjects.org/intellij-idea.svg)](https://www.jetbrains.com/idea/)
[![Hits-of-Code](https://hitsofcode.com/github/mi1qw/job4j_cars/?branch=master)](https://hitsofcode.com/github/mi1qw/job4j_cars//view?branch=master)

### Стек технологий
Spring-boot<span style="font-size: large; "> 3.0</span>,
Thymeleaf<span style="font-size: large; "> 3.1</span>,
Hibernate<span style="font-size: large; "> 6.1.5</span>,
PostgreSQL<span style="font-size: large; "> 42.5.1</span>,
Liquibase<span style="font-size: large; "> 4.17.2</span>,
<br>
Lombok<span style="font-size: large; "> 1.18.24</span>,
Mapstruct<span style="font-size: large; "> 1.5.2</span>,
Java<span style="font-size: large; "> 17</span>

### Тестирование:<br>
SpringBootTest<span style="font-size: large; "> (MockMvc)</span>,
H2<span style="font-size: large; "> 2.1.214</span>,
AssertJ<span style="font-size: large; "> 3.23.1</span>,


### Окружение
Java<span style="font-size: large; "> 17</span>,
Maven<span style="font-size: large; "> 3.8</span>,
PostgreSQL<span style="font-size: large; "> 14</span>

***
### Запуск проекта
создайте базу _car_ через терминал PostgreSQL<br>
```sh
$ sudo -u postgres psql
$ create database car
$ \q
```
запуск
```sh
$ mvn spring-boot:run;
```
в вашем браузере<br>
<http://127.0.0.1:8080/posts>
***
Поиск нужного авто по каким-то параметрам

<img src="/img/ezgif-1-10330229d9.gif" width="800px"/>

***

Регистрация. Размещение или скрытие объявления

<img src="/img/ezgif-5-39d080c8ef.gif" width="800px"/>

***
Редактирование объявления

<img src="/img/ezgif-5-129a301d85.gif" width="800px"/>

***
Контакты<br>
Email address: my@gmail.com
