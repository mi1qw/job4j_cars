INSERT INTO public.color (id, color, name) VALUES (1, 'black', 'Чёрный');
INSERT INTO public.color (id, color, name) VALUES (2, 'silver', 'Серебристый');
INSERT INTO public.color (id, color, name) VALUES (3, 'white', 'Белый');
INSERT INTO public.color (id, color, name) VALUES (4, 'gray', 'Серый');
INSERT INTO public.color (id, color, name) VALUES (5, 'blue', 'Синий');
INSERT INTO public.color (id, color, name) VALUES (6, 'red', 'Красный');
INSERT INTO public.color (id, color, name) VALUES (7, 'green', 'Зелёный');
INSERT INTO public.color (id, color, name) VALUES (8, 'brown', 'Коричневый');
INSERT INTO public.color (id, color, name) VALUES (9, 'beige', 'Бежевый');
INSERT INTO public.color (id, color, name) VALUES (10, 'sky', 'Голубой');
INSERT INTO public.color (id, color, name) VALUES (11, 'gold', 'Золотистый');
INSERT INTO public.color (id, color, name) VALUES (12, 'magenta', 'Пурпурный');
INSERT INTO public.color (id, color, name) VALUES (13, 'purple', 'Фиолетовый');
INSERT INTO public.color (id, color, name) VALUES (14, 'yellow', 'Жёлтый');
INSERT INTO public.color (id, color, name) VALUES (15, 'orange', 'Оранжевый');
INSERT INTO public.color (id, color, name) VALUES (16, 'pink', 'Розовый');

INSERT INTO public.mark (id, image, name) VALUES (1, 'logoToyota.png', 'Toyota');
INSERT INTO public.mark (id, image, name) VALUES (2, 'logoBMW.png', 'BMW');
INSERT INTO public.mark (id, image, name) VALUES (3, 'logoMers.png', 'Mercedes-Benz');
INSERT INTO public.mark (id, image, name) VALUES (4, 'logoVaz.png', 'LADA (ВАЗ)');
INSERT INTO public.mark (id, image, name) VALUES (5, 'logoAudi.png', 'Audi');
INSERT INTO public.mark (id, image, name) VALUES (6, 'logoHyundai.png', 'Hyundai');
INSERT INTO public.mark (id, image, name) VALUES (7, 'logoKia.png', 'Kia');
INSERT INTO public.mark (id, image, name) VALUES (8, 'logoNissan.png', 'Nissan');
INSERT INTO public.mark (id, image, name) VALUES (9, 'logoRenault.png', 'Renault');
INSERT INTO public.mark (id, image, name) VALUES (10, 'logoSkoda.png', 'Skoda');
INSERT INTO public.mark (id, image, name) VALUES (11, 'logoVW.png', 'VW');

INSERT INTO public.model (id, name, mark_id) VALUES (1, 'A-Класс', 3);
INSERT INTO public.model (id, name, mark_id) VALUES (2, 'Camry', 1);
INSERT INTO public.model (id, name, mark_id) VALUES (3, 'Crown', 1);
INSERT INTO public.model (id, name, mark_id) VALUES (4, '2 серии', 2);

INSERT INTO public.body (id, image, name) VALUES (1, 'sedan-side.png', 'Седан');
INSERT INTO public.body (id, image, name) VALUES (2, 'hatch5d-side.png', 'Хэтчбек');
INSERT INTO public.body (id, image, name) VALUES (3, 'liftback-side.png', 'Лифтбек');
INSERT INTO public.body (id, image, name) VALUES (4, 'suv5d-side.png', 'Внедорожник');
INSERT INTO public.body (id, image, name) VALUES (5, 'universal-side.png', 'Универсал');
INSERT INTO public.body (id, image, name) VALUES (6, 'coupe-side.png', 'Купе');
INSERT INTO public.body (id, image, name) VALUES (7, 'vclasse-side.png', 'Мнинвэн');
INSERT INTO public.body (id, image, name) VALUES (8, 'Пикап', 'Пикап');
INSERT INTO public.body (id, image, name) VALUES (9, 'Лимузин.png', 'Лимузин');
INSERT INTO public.body (id, image, name) VALUES (10, 'van-side.png', 'Фургон');
INSERT INTO public.body (id, image, name) VALUES (11, 'cabrio-side.png', 'Кабриолет');

INSERT INTO public.engine (id, image, name) VALUES (1, '#gasoline', 'Бензин');
INSERT INTO public.engine (id, image, name) VALUES (2, '#diesel', 'Дизель');
INSERT INTO public.engine (id, image, name) VALUES (3, '#hybrid', 'Гибрид');
INSERT INTO public.engine (id, image, name) VALUES (4, '#electro', 'Электро');

INSERT INTO public.transmission (id, image, name) VALUES (1, '#forward-control', 'Передний');
INSERT INTO public.transmission (id, image, name) VALUES (2, '#rear-drive', 'Задний');
INSERT INTO public.transmission (id, image, name) VALUES (3, '#all-wheel-drive', 'Полный');

INSERT INTO public.gearbox (id, image, name) VALUES (1, '#automatic', 'Автомат');
INSERT INTO public.gearbox (id, image, name) VALUES (2, '#robot', 'Робот');
INSERT INTO public.gearbox (id, image, name) VALUES (3, '#variator', 'Вариатор');
INSERT INTO public.gearbox (id, image, name) VALUES (4, '#mechanical', 'Механическая');

INSERT INTO public.city (id, name) VALUES (1, 'Татуин');
INSERT INTO public.city (id, name) VALUES (2, 'Набу');
INSERT INTO public.city (id, name) VALUES (3, 'Камино');
INSERT INTO public.city (id, name) VALUES (4, 'Эндор');
INSERT INTO public.city (id, name) VALUES (5, 'Джеонозис');
INSERT INTO public.city (id, name) VALUES (6, 'Скариф');
INSERT INTO public.city (id, name) VALUES (7, 'Джакку');
INSERT INTO public.city (id, name) VALUES (8, 'Кашиик');
INSERT INTO public.city (id, name) VALUES (9, 'Корусант');
INSERT INTO public.city (id, name) VALUES (10, 'Дагоба');

INSERT INTO public.options (id, name, namecategory) VALUES (1, 'Светодиодные фары', 'Обзор');
INSERT INTO public.options (id, name, namecategory) VALUES (2, 'Противотуманные фары', 'Обзор');
INSERT INTO public.options (id, name, namecategory) VALUES (3, 'Дневные ходовые огни', 'Обзор');
INSERT INTO public.options (id, name, namecategory) VALUES (4, 'Бортовой компьютер', 'Комфорт');
INSERT INTO public.options (id, name, namecategory) VALUES (5, 'Система доступа без ключа', 'Комфорт');
INSERT INTO public.options (id, name, namecategory) VALUES (6, 'Центральный замок', 'Защита от угона');
INSERT INTO public.options (id, name, namecategory) VALUES (7, 'Иммобилайзер', 'Защита от угона');
INSERT INTO public.options (id, name, namecategory) VALUES (8, 'Навигационная система', 'Мультимедиа');
INSERT INTO public.options (id, name, namecategory) VALUES (9, 'Мультимедиа система с ЖК-экраном', 'Мультимедиа');
INSERT INTO public.options (id, name, namecategory) VALUES (10, 'Люк', 'Салон');
INSERT INTO public.options (id, name, namecategory) VALUES (11, 'Обогрев рулевого колеса', 'Салон');

INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('136 л.с. (200 / 1.3 MT)', 2018, 1332, 4, 'рядное', 136, 3);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('3.5 CVT 299 л.с', 2018, 3456, 6, 'V-образное', 299, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.5 CVT 184 л.с', 2018, 2487, 4, 'V-образное', 184, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.0 AT 245 л.c.', 2018, 1998, 4, 'рядное', 245, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('3.5 AT 249 л.с.', 2021, 3456, 6, 'V-образное', 249, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.5 AT 203 л.с.', 2021, 2487, 4, 'рядное', 203, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.5 CVT 208 л.с.', 2021, 2487, 4, 'рядное', 208, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.5 AT 202 л.с. 4x4', 2021, 2487, 4, 'рядное', 202, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.5 CVT 178 л.с. 4x4', 2021, 2487, 4, 'рядное', 178, 1);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('218i 1.5 MT 140 л.с.', 2019, 1499, 3, 'рядное', 140, 2);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.0 AT 231 л.с.', 2019, 1998, 4, 'рядное', 231, 2);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('2.0 AT 150 л.с.', 2019, 1995, 4, 'рядное', 150, 2);
INSERT INTO public.modification (name, year_id, enginedisplacement, numberofcylinders, positionofcylinders, power, mark_id) VALUES ('1.5 MT 136 л.с.', 2019, 1499, 3, 'рядное', 136, 2);

INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (1, 'VIII(XV70)reystaling.jpg', 'VIII (XV70) Рестайлинг', 2021, 1, 1, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (2, 'VIII(XV70)reystaling.jpg', 'VIII (XV70) Рестайлинг', 2021, 1, 1, 1, 2, 1, '2.5 AT 203 л.с.', 2021, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (3, 'VIII(XV70)reystaling.jpg', 'VIII (XV70) Рестайлинг', 2021, 1, 1, 3, 2, 1, '2.5 CVT 208 л.с.', 2021, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (4, 'VIII(XV70)reystaling.jpg', 'VIII (XV70) Рестайлинг', 2021, 1, 1, 1, 2, 1, '2.5 AT 202 л.с. 4x4', 2021, 3);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (5, 'VIII(XV70).jpg', 'VIII (XV70)', 2021, 1, 1, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (6, 'VIII(XV70).jpg', 'VIII (XV70)', 2021, 1, 3, 3, 2, 1, '2.5 CVT 208 л.с.', 2021, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (7, 'VIII(XV70).jpg', 'VIII (XV70)', 2021, 1, 3, 3, 2, 1, '2.5 CVT 178 л.с. 4x4', 2021, 3);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (8, 'F44.jpg', 'F44', 2019, 1, 1, 4, 4, 2, '218i 1.5 MT 140 л.с.', 2019, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (9, 'F44.jpg', 'F44', 2019, 1, 1, 1, 4, 2, '2.0 AT 231 л.с.', 2019, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (10, 'F44.jpg', 'F44', 2019, 1, 1, 2, 4, 2, '218i 1.5 MT 140 л.с.', 2019, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (11, 'F44.jpg', 'F44', 2019, 1, 1, 1, 4, 2, '2.0 AT 231 л.с.', 2019, 3);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (12, 'F22restayling.jpg', 'F22 Рестайлинг', 2019, 6, 2, 1, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (13, 'F22restaylingCabriolet.jpg', 'Кабриолет F22 Рестайлинг', 2019, 11, 2, 1, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (14, 'F22restaylingCabriolet.jpg', 'Кабриолет F22 Рестайлинг', 2019, 11, 1, 4, 4, 2, '1.5 MT 136 л.с.', 2019, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (15, 'IV (W177).jpg', 'IV (W177)', 2021, 1, 1, 4, 1, 3, '136 л.с. (200 / 1.3 MT)', 2018, 1);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (16, 'CrownXV(S220).jpg', 'XV (S220)', 2018, 1, 3, 3, 3, 1, '2.5 CVT 184 л.с', 2018, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (17, 'CrownXV(S220).jpg', 'XV (S220)', 2018, 1, 1, 1, 3, 1, '2.0 AT 245 л.c.', 2018, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (18, 'CrownXIV(S210).jpg', 'XIV (S210)', 2018, 1, 1, 1, 3, 1, '3.5 CVT 299 л.с', 2018, 2);
INSERT INTO public.generations (id, image, name, yearg, body_id, engine_id, gearbox_id, model_id, mark_id, name_id, year_id, transmission_id) VALUES (19, 'CrownXIV(S210).jpg', 'XIV (S210)', 2018, 1, 3, 3, 3, 1, '2.5 CVT 184 л.с', 2018, 2);


INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (1, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (2, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (3, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (4, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (5, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (6, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 8);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (7, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (8, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (8, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (8, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (8, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (8, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (9, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (9, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (9, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (9, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (9, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (10, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (10, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (10, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (10, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (10, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (11, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (11, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (11, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (11, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (11, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 3);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (12, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 3);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (13, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 2);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 3);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (14, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (15, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (15, 11);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (15, 4);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (15, 6);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (15, 7);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (16, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (16, 9);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (16, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (17, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (17, 9);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (17, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (18, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (18, 9);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (18, 5);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (19, 1);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (19, 9);
INSERT INTO public.generations_options (generations_id, options_id) VALUES (19, 5);





INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (2, '2022-10-24 17:08:48.690773', 'Ann', 'Annovich', 'ann@gmail.com', '111', '0951234241', 1);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (3, '2022-10-24 17:34:24.486636', 'Борис', 'Васильевич', 'boris@gmail.com', '111', '0951234242', 7);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (4, '2022-10-24 18:10:36.904998', 'Emma', 'Watson', 'emma@gmail.com', '111', '0951234243', 9);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (5, '2022-10-24 18:39:49.497355', 'Пётр', 'Васильев', 'petr@gmail.com', '111', '0951234244', 10);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (7, '2022-10-24 20:38:23.804159', 'Olga', 'Olegova', 'olga@gmail.com', '111', '0951234247', 8);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (1, '2022-10-24 16:09:53.952608', 'Вася', 'Васильев', 'vasya@gmail.com', '111', '0951234246', 2);
INSERT INTO public.account (id, created, firstname, name, login, password, phonenumber, city_id) VALUES (6, '2022-10-24 20:29:16.154469', 'Татьяна', 'Васильева', 'tanya@gmail.com', '111', '0951234245', 6);





INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (10, '2022-10-08 22:18:19.335775', 'Уважаемые клиенты!
Представляем Вашему вниманию автомобиль : Toyota Camry VIII
Автомобиль прошел комплексную диагностику, тщательную предпродажную подготовку, а также юридическую проверку.
Данный автомобиль вы можете приобрести в кредит просто и выгодно.', 3456, '2022-10-25 17:01:44.435044', 'Toyota Camry VIII (XV70) 2021', 5, 249, 27800.00, 'onSale', 2021, 2021, 2, 1, 1, 1, 1, 1, 5, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (23, '2022-10-07 22:18:19.335775', 'Продаю автомобиль BMW 2 серия. Отличное состаяние автомобиля! Комплектация M Sport. Комплект зимней резины. Очень красивый цвет. Полный комплект ключей и документов.', 1998, '2022-10-25 23:25:25.479015', 'BMW 2 серии F44 2019', 21, 231, 28000.00, 'onSale', 2019, 2022, 4, 1, 9, 10, 1, 1, 11, 2, 4, 2, '2.0 AT 231 л.с.', 2019, 3);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (28, '2022-10-17 22:18:19.335775', 'Отличная машина на каждый день!
Один владелец за все время.
Все ТО у официального дилера каждые 7 тыс.км. Гаражное хранение.
Колодки новые по кругу, свечи, заменил менее 1000 км.
Полностью стоковая. Помощи в продаже не нуждаюсь.
Только сделал oilservice с заменой всех фильтров.
Настоящему покупателю бонус.', 1998, '2022-10-25 23:45:24.749691', 'BMW 2 серии F44 2019', 19, 231, 27300.00, 'onSale', 2019, 2020, 4, 1, 9, 6, 1, 1, 9, 2, 4, 2, '2.0 AT 231 л.с.', 2019, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (18, '2022-10-14 22:18:19.335775', 'Уникальное предложение !!!

Кабриолет на механике и задним приводом .', 1499, '2022-10-25 17:37:09.059250', 'BMW 2 серии Кабриолет F22 Рестайлинг 2019', 87, 136, 19700.00, 'onSale', 2019, 2022, 3, 11, 7, 2, 1, 4, 14, 2, 4, 2, '1.5 MT 136 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (33, '2022-10-14 22:18:19.335775', 'Японский Бизнес класс.
Весь в заводском окрасе!
Стекла родные.
Комплектация G Royal Salon.
Электрошторка заднего стекла.
Доводчики всех дверей и багажника.
Электропривод задних сидений.
Юридически чистый автомобиль.
Дополнительно установлена сигнализация Pandora с gsm и gps.
Ковры EVA в салоне и багажнике.', 3456, '2022-10-26 00:04:44.732279', 'Toyota Crown XIV (S210) 2018', 98, 299, 31000.00, 'onSale', 2018, 2020, 6, 1, 6, 3, 1, 1, 18, 1, 3, 1, '3.5 CVT 299 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (30, '2022-10-10 22:18:19.335775', 'Автомобиль полностью обслужен, состояние ближе к новому. Комплектация пред максимальная «Progressive”+дооснащение. Не путать с пустыми комплектациями с имитацией сенсорных экранов и без сенсорной панели управления.
По автомобилю говорить можно долго и интересно, это однозначно лучшее что есть в классе.', 1332, '2022-10-25 23:54:56.105038', 'Mercedes-Benz A-Класс IV (W177) 2021', 40, 136, 33000.00, 'onSale', 2021, 2021, 5, 1, 10, 1, 1, 4, 15, 3, 1, 3, '136 л.с. (200 / 1.3 MT)', 2018, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (40, '2022-10-11 22:18:19.335775', 'Toyota Crown: гибридный автомобиль, зимняя комплектация, страна сборки Япония.', 1998, '2022-10-26 00:32:47.051214', 'Toyota Crown XV (S220) 2018', 20, 245, 45000.00, 'onSale', 2018, 2021, 7, 1, 8, 3, 1, 1, 17, 1, 3, 1, '2.0 AT 245 л.c.', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (45, '2022-10-19 22:18:19.335775', 'Краун. Он сам говорит за себя. ) Возможен вычет НДС.
Аукционник 4.5 ВВ. Машина в идеальном состоянии.
Можем организовать доставку в любой регион.', 2487, '2022-10-26 00:47:42.051532', 'Toyota Crown XV (S220) 2018', 110, 184, 29700.00, 'onSale', 2018, 2022, 7, 1, 8, 1, 3, 3, 16, 1, 3, 1, '2.5 CVT 184 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (32, '2022-10-13 22:18:19.335775', 'Продам отличный Crown в комплектации Royal Saloon с соответствующим внешним видом и техническим состоянием. Привозил для себя в мае 2019 года из Японии (оригинал аукционного листа и таможенные документы в наличии). Единственный хозяин за все время с бережной эксплуатацией и качественным уходом. Своевременные ТО каждые 5000 км, проверка ВВБ, сканирование системы и тд.', 3456, '2022-10-26 00:01:42.639221', 'Toyota Crown XIV (S210) 2018', 100, 299, 29000.00, 'onSale', 2018, 2019, 6, 1, 6, 1, 1, 1, 18, 1, 3, 1, '3.5 CVT 299 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (39, '2022-10-08 22:18:19.335775', 'В ДТП не был. Окрас родной. Двигатель, гибридная система, адаптивная подвеска без замечаний. Установлена сигнализация StarLine Е66 у официалов. В комплекте шел японский видеорегистратор, прилагается. Расход топлива не большой, зависит от стиля вождения. от 5,5 до 7 л. /100 км.', 1998, '2022-10-26 00:28:53.323951', 'Toyota Crown XV (S220) 2018', 60, 245, 30000.00, 'onSale', 2018, 2021, 7, 1, 8, 4, 1, 1, 17, 1, 3, 1, '2.0 AT 245 л.c.', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (6, '2022-10-11 22:18:19.335775', 'Состояние нового авто. На гарантии. Я единственный владелец! Приобретал у официального дилера Тойота за наличный расчёт в сентябре 2021 года. Без ДТП, без ремонтов и окрасов!', 2487, '2022-10-29 20:10:54.585351', 'Toyota Camry VIII (XV70) Рестайлинг 2021', 2, 202, 38750.00, 'onSale', 2021, 2022, 1, 1, 3, 2, 1, 1, 4, 1, 2, 1, '2.5 AT 202 л.с. 4x4', 2021, 3);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (8, '2022-10-23 22:18:19.335775', 'Причина продажи - покупка недвижимости.
Цена актуальна пока на рынке есть интересующий меня вариант.', 2487, '2022-10-25 16:44:39.590256', 'Toyota Camry VIII (XV70) Рестайлинг 2021', 11, 208, 32100.00, 'onSale', 2021, 2022, 1, 1, 3, 3, 1, 3, 3, 1, 2, 1, '2.5 CVT 208 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (7, '2022-10-25 22:18:19.335775', 'Куплен март 2022 года. Пробег оригинал. Дополнительно - сигнализация, бронепленка, сетка в бампер, тонировка. Подробности по телефону.
Торг уместен !', 2487, '2022-10-25 16:41:44.107252', 'Toyota Camry VIII (XV70) Рестайлинг 2021', 21, 202, 35555.00, 'onSale', 2021, 2022, 1, 1, 3, 3, 1, 1, 4, 1, 2, 1, '2.5 AT 202 л.с. 4x4', 2021, 3);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (29, '2022-10-07 22:18:19.335775', 'ПТС ОРИГИНАЛ. 2 СОБСТВЕННИКА. ПОДТВЕРЖДЕННЫЙ ПРОБЕГ.

АВТО БЕЗ ДТП. БЕЗ ВЫПЛАТ. В РОДНОМ ОКРАСЕ.

ПО ЗАПРОСУ МОГУ ВЫСЛАТЬ ФОТО/ВИДЕО АВТОМОБИЛЯ С ПРОМЕРОМ КУЗОВА ТОЛЩИНОМЕРОМ.

Богатая комплектация: AMG пакет, Carplay, камера заднего вида, автопарковка, система предотвращения столкновений, светодиодная оптика, парковочный пакет, Night пакет...

РАССМАТРИВАЕТСЯ ВАРИАНТ ОБМЕНА НА ВАШ АВТОМОБИЛЬ.', 1332, '2022-10-25 23:52:06.724933', 'Mercedes-Benz A-Класс IV (W177) 2021', 21, 136, 35000.00, 'onSale', 2021, 2021, 5, 1, 10, 2, 1, 4, 15, 3, 1, 3, '136 л.с. (200 / 1.3 MT)', 2018, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (43, '2022-10-16 22:18:19.335775', 'Звоните для осмотра авто заранее, не всегда на месте.

Аукцион 4 балла, статистика в свободном доступе.', 2487, '2022-10-26 00:38:50.498678', 'Toyota Crown XV (S220) 2018', 50, 184, 31000.00, 'onSale', 2018, 2020, 7, 1, 8, 3, 3, 3, 16, 1, 3, 1, '2.5 CVT 184 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (44, '2022-10-14 22:18:19.335775', 'В идеальном состоянии во всех планах, АУКЦИОННАЯ МАШИНА С ОЦЕНКОЙ 4, 5(А) Балла. ЕСТЬ В СТАТИСТИКЕ И СООТВЕТСТВУЕТ ЕЙ!(АУКЦИОННЫЙ ЛИСТ ПРИЛАГАЕТСЯ) полностью честный и прозрачный авто.', 2487, '2022-10-26 00:41:08.020968', 'Toyota Crown XV (S220) 2018', 16, 184, 35000.00, 'onSale', 2018, 2020, 7, 1, 8, 3, 3, 3, 16, 1, 3, 1, '2.5 CVT 184 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (35, '2022-10-10 22:18:19.335775', 'Японский Бизнес класс.
Весь в заводском окрасе!
Стекла родные.
Комплектация G Royal Salon.
Электрошторка заднего стекла.
Доводчики всех дверей и багажника.
Электропривод задних сидений.
Юридически чистый автомобиль.
Дополнительно установлена сигнализация Pandora с gsm и gps.
Ковры EVA в салоне и багажнике.', 2487, '2022-10-26 00:12:58.159693', 'Toyota Crown XIV (S210) 2018', 70, 184, 40000.00, 'onSale', 2018, 2019, 6, 1, 6, 2, 3, 3, 19, 1, 3, 1, '2.5 CVT 184 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (21, '2022-10-25 22:18:19.335775', 'Автомобиль куплен новым у официального дилера в конце февраля 2022 г. Сборка Германия. Замена масла каждые 6-7 тыс.км., есть подтверждение.
Также есть 4 бесплатных ТО у дилера, поэтому в ближайшие годы можете не задумываться об обслуживании.
Автомобиль в идеальном состоянии, в салоне не курили, поэтому сможете наслаждаться запахом новой машины.
Никаких крашенных или замененных деталей нет, автомобиль в ДТП не участвовал, страховых выплат не было.
Езжу каждый день, поэтому пробег увеличивается.
Разумный торг у капота.', 1995, '2022-10-25 23:05:33.517383', 'BMW 2 серии F22 Рестайлинг 2019', 10, 150, 30000.00, 'onSale', 2019, 2022, 3, 6, 7, 7, 2, 1, 12, 2, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (13, '2022-10-10 22:18:19.335775', 'На все автомобили компания предоставляет гарантию юридической чистоты. Возможно приобретение автомобиля в кредит.
ВЫ МОЖЕТЕ ПОЛУЧИТЬ СКИДКУ НА ДАННЫЙ АВТОМОБИЛЬ !!!', 3456, '2022-10-25 17:14:45.021673', 'Toyota Camry VIII (XV70) 2021', 20, 249, 25700.00, 'onSale', 2021, 2021, 2, 1, 1, 3, 1, 1, 5, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (34, '2022-10-19 22:18:19.335775', 'Автомобиль в МОСКВЕ! Продам отличный Crown в комплектации Royal Saloon с соответствующим внешним видом и техническим состоянием. Привозил для себя в мае 2019 года из Японии (оригинал аукционного листа и таможенные документы в наличии). Единственный хозяин за все время с бережной эксплуатацией и качественным уходом. Своевременные ТО каждые 5000 км, проверка ВВБ, сканирование системы и тд. Редкий оттенок серебристой краски. Авто покрыт керамикой в круг + броне пленкой весь перед, в том числе лобовое стекло. Установлен дорогой охранный комплекс. Два комплекта ключей. Вместе с авто идет комплект дорогой зимней резины на 16 + набор для следующей замены масла (масло и фильтр) и салонный фильтр для замены. Отвечу на все вопросы при осмотре. Любые проверки и тесты за ваш счет приветствуются.', 3456, '2022-10-26 00:09:35.464508', 'Toyota Crown XIV (S210) 2018', 50, 299, 43000.00, 'onSale', 2018, 2019, 6, 1, 6, 4, 1, 1, 18, 1, 3, 1, '3.5 CVT 299 л.с', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (25, '2022-10-12 22:18:19.335775', 'Автомобили с пробегом :
- Мы гарантируем индивидуальные условия при покупке и/или при обмене на Ваш автомобиль.
-Мы принимаем любые легковые и коммерческие автомобили независимо от марки, года выпуска,', 1499, '2022-10-25 23:32:19.898374', 'BMW 2 серии F44 2019', 12, 140, 26500.00, 'onSale', 2019, 2021, 4, 1, 9, 10, 1, 4, 8, 2, 4, 2, '218i 1.5 MT 140 л.с.', 2019, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (31, '2022-10-22 22:18:19.335775', 'Ваш выбор и Ваше время — наши главные приоритеты. Поэтому мы предлагаем Вам индивидуальные условия на приобретение Mercedes-Benz A-Класс с пробегом.', 1332, '2022-10-25 23:57:25.677239', 'Mercedes-Benz A-Класс IV (W177) 2021', 1, 136, 45600.00, 'onSale', 2021, 2022, 5, 1, 10, 3, 1, 4, 15, 3, 1, 3, '136 л.с. (200 / 1.3 MT)', 2018, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (11, '2022-10-09 22:18:19.335775', 'Полный комплект ключей и оригинальных документов! Оригинальный пробег! Сервисная документация в наличии. Без технических недостатков. Ухоженный внешний вид..', 2487, '2022-10-25 17:07:40.420769', 'Toyota Camry VIII (XV70) 2021', 50, 178, 25700.00, 'onSale', 2021, 2021, 2, 1, 1, 1, 3, 3, 7, 1, 2, 1, '2.5 CVT 178 л.с. 4x4', 2021, 3);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (3, '2022-10-22 22:18:19.335775', 'Состояние нового автомобиля.
Покупалась у официального дилера.
Комплект зимней резины в подарок.', 3456, '2022-10-28 17:03:32.189665', 'Toyota Camry VIII (XV70) Рестайлинг 2021', 1, 249, 45000.00, 'onSale', 2021, 2022, 1, 1, 3, 1, 1, 1, 1, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (27, '2022-10-08 22:18:19.335775', 'Ищете BMW 2 серии с пробегом на особых условиях? Официальному дилеру Автомобили с пробегом есть, что Вам предложить!

Официальный дилер предлагает Вам BMW 2 серии с проведенной технической и юридической проверкой. Мы гарантируем индивидуальные условия при покупке и/или при обмене на Ваш автомобиль.

⭐Мы гарантируем индивидуальные условия при покупке и/или при обмене на Ваш автомобиль.
⭐Также целых 2 года гарантии*', 1499, '2022-10-25 23:43:28.773662', 'BMW 2 серии F44 2019', 30, 140, 23400.00, 'onSale', 2019, 2022, 4, 1, 9, 3, 1, 2, 10, 2, 4, 2, '218i 1.5 MT 140 л.с.', 2019, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (24, '2022-10-25 22:18:19.335775', 'Куплен в феврале 2020, состояние нового автомобиля, стоял в подземном теплом паркинге, сделана керамика кузова.', 1499, '2022-10-25 23:28:51.252537', 'BMW 2 серии F44 2019', 5, 140, 25500.00, 'onSale', 2019, 2020, 4, 1, 9, 5, 1, 2, 10, 2, 4, 2, '218i 1.5 MT 140 л.с.', 2019, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (37, '2022-10-13 22:18:19.335775', '🚗НЕ ЖДИТЕ ПОКА КУПЯТ ВАШ АВТО, ПОЯВИЛАСЬ УСЛУГА TRADE IN НА АВТОМОБИЛИ С ПРОБЕГОМ!', 1998, '2022-10-26 00:22:00.432856', 'Toyota Crown XV (S220) 2018', 80, 245, 49000.00, 'onSale', 2018, 2022, 6, 1, 6, 3, 1, 1, 17, 1, 3, 1, '2.0 AT 245 л.c.', 2018, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (9, '2022-10-13 22:18:19.335775', 'Автомобиль в оригинальном окрасе. Один собственник с момента покупки у Официального дилера. Прохождение Т.О. строго на станции официального дилера. Оригинальный пробег, по сути трассовый, подтвержденный сервисной книжкой.', 2487, '2022-10-25 16:49:27.034727', 'Toyota Camry VIII (XV70) Рестайлинг 2021', 20, 202, 29500.00, 'onSale', 2021, 2021, 1, 1, 3, 12, 1, 1, 4, 1, 2, 1, '2.5 AT 202 л.с. 4x4', 2021, 3);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (12, '2022-10-11 22:18:19.335775', 'Получите дополнительную скидку при покупке данного автомобиля в кредит!

❗ Все заявленные автомобили находятся в наличии.
❗ Честные цены.
❗ Без скрытых комиссий.
❗ Выгода по программе Trade-In*', 3456, '2022-10-25 17:11:38.359824', 'Toyota Camry VIII (XV70) 2021', 33, 249, 30000.00, 'onSale', 2021, 2021, 2, 1, 1, 1, 1, 1, 5, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (22, '2022-10-11 22:18:19.335775', 'Ищете BMW 2 серии с пробегом на особых условиях?

Официальный дилер предлагает Вам BMW 2 серии с проведенной технической и юридической проверкой. Мы гарантируем индивидуальные условия при покупке и/или при обмене на Ваш автомобиль.', 1998, '2022-10-25 23:20:20.786850', 'BMW 2 серии F44 2019', 11, 231, 33000.00, 'onSale', 2019, 2021, 4, 1, 9, 1, 1, 1, 9, 2, 4, 2, '2.0 AT 231 л.с.', 2019, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (16, '2022-10-20 22:18:19.335775', 'Отличная машина на каждый день!
Один владелец за все время.
Полностью стоковая. Помощи в продаже не нуждаюсь.
Только сделал oilservice с заменой всех фильтров.
Настоящему покупателю бонус.', 1995, '2022-10-25 17:26:33.947876', 'BMW 2 серии F22 Рестайлинг 2019', 41, 150, 21000.00, 'onSale', 2019, 2022, 3, 6, 7, 3, 2, 1, 12, 2, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (17, '2022-10-08 22:18:19.335775', 'Машина в идеале, без ДТП. Пройдено огромное то с заменой масла в коробке, редукторе и приводах, почищен впускной коллектор, поменяны уставшие сайленты, помыты все радиаторы. М пакет, спортивная коробка с лепестками.', 1995, '2022-10-25 17:31:29.024943', 'BMW 2 серии F22 Рестайлинг 2019', 20, 150, 25000.00, 'onSale', 2019, 2019, 3, 6, 7, 4, 2, 1, 12, 2, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (14, '2022-10-07 22:18:19.335775', 'Отличная машина на каждый день!
Один владелец за все время.
Все ТО у официального дилера каждые 7 тыс.км. Гаражное хранение.
Колодки новые по кругу, свечи, заменил менее 1000 км.', 3456, '2022-10-25 17:19:19.329263', 'Toyota Camry VIII (XV70) 2021', 10, 249, 24900.00, 'onSale', 2021, 2022, 2, 1, 1, 1, 1, 1, 5, 1, 2, 1, '3.5 AT 249 л.с.', 2021, 1);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (19, '2022-10-22 22:18:19.335775', 'Я единственный собственник, куплена в декабре 2019 года.
Сделан лайтовый «ст.3»:
ТНВД ген.2
Турбина VTT GC
JB4
Метанол Burgertuning (проставка на дроссель, две литровые форсунки)
Нулевик в штатный короб
Даунпайп и удаление резонатора
MHD (полная лицензия)
хНР (полная лицензия)', 1995, '2022-10-25 17:42:35.998699', 'BMW 2 серии F22 Рестайлинг 2019', 61, 150, 18500.00, 'onSale', 2019, 2022, 3, 6, 7, 5, 2, 1, 12, 2, 4, 2, '2.0 AT 150 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (20, '2022-10-18 22:18:19.335775', ' 1 владелец.
- При обмене на ВАШ автомобиль действуют СКИДКИ
- Скидка при покупке в КРЕДИТ
- Скидки суммируются!
- Мы гарантируем, что автомобиль не находится в розыске и не является предметом залога.
- Оригинальный пробег.
- Полная комплексная техническая проверка состояния автомобиля
- Предпродажная подготовка', 1499, '2022-10-25 22:59:36.230003', 'BMW 2 серии Кабриолет F22 Рестайлинг 2019', 3, 136, 27000.00, 'onSale', 2019, 2022, 3, 11, 7, 1, 1, 4, 14, 2, 4, 2, '1.5 MT 136 л.с.', 2019, 2);
INSERT INTO public.car (id, created, description, enginedisplacement, lastupdated, name, odometer, power, price, status, yearc, yearpurchase, account_id, body_id, city_id, color_id, engine_id, gearbox_id, generations_id, mark_id, model_id, modification_mark_id, modification_name, modification_year_id, transmission_id) VALUES (26, '2022-10-23 22:18:19.335775', 'Машина в идеале, без ДТП. Пройдено огромное то с заменой масла в коробке, редукторе и приводах, почищен впускной коллектор, поменяны уставшие сайленты, помыты все радиаторы, морда в плёнке. М пакет, спортивная коробка с лепестками.', 1998, '2022-10-25 23:35:51.801463', 'BMW 2 серии F44 2019', 33, 231, 22000.00, 'onSale', 2019, 2022, 4, 1, 9, 10, 1, 1, 11, 2, 4, 2, '2.0 AT 231 л.с.', 2019, 3);




INSERT INTO public.car_options (car_id, options_id) VALUES (3, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (3, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (7, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (8, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (9, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (10, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (11, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (12, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (13, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 8);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (14, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (16, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (17, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (18, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (19, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (20, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 3);
INSERT INTO public.car_options (car_id, options_id) VALUES (21, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (22, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (22, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (22, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (22, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (22, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (23, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (23, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (23, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (23, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (23, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (24, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (24, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (24, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (24, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (24, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (25, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (25, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (25, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (25, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (25, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (27, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (27, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (27, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (27, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (27, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (28, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (28, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (28, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (28, 2);
INSERT INTO public.car_options (car_id, options_id) VALUES (28, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (29, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (29, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (29, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (29, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (29, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (30, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (30, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (30, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (30, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (30, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (31, 6);
INSERT INTO public.car_options (car_id, options_id) VALUES (31, 7);
INSERT INTO public.car_options (car_id, options_id) VALUES (31, 11);
INSERT INTO public.car_options (car_id, options_id) VALUES (31, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (31, 4);
INSERT INTO public.car_options (car_id, options_id) VALUES (32, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (32, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (32, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (33, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (33, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (33, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (34, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (34, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (34, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (35, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (35, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (35, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (37, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (37, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (37, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (39, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (39, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (39, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (40, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (40, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (40, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (43, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (43, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (43, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (44, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (44, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (44, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (45, 5);
INSERT INTO public.car_options (car_id, options_id) VALUES (45, 9);
INSERT INTO public.car_options (car_id, options_id) VALUES (45, 1);
INSERT INTO public.car_options (car_id, options_id) VALUES (6, 10);
INSERT INTO public.car_options (car_id, options_id) VALUES (26, 10);




INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-30-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAO1TBTvWYMkdgxCkQDT2QMSnZscR1XdmNn48DeP9f9dOJt0nxE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-29-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9GFgS5QxTvX9V2cwcSllPR3FIUyp4ZSwCAz4us8mKI8a9aNsJ1ykE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-37-1200x900n (1).jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-38-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-72-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpHFQO5Rh3vD94jJwITlVSD3AhEmZ8aEVPamtyup2WMqq4LbsAlm0c41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-71-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGQa8TRXvWoIlcABBxFbV3VYRnJkZQFOLnoymo2GBpvhaacJ2mkY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-75-1200x900n (1).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-32-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwC7QBvvDdB0fwwUklWAjFEXm8MaQ1GNy9H4-TOBofxZPpR1nBU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-173-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1CFAO9RhvvWIJzc1EXxgWDhgkQzcgZEATandj9-Gfcq_laNpolmhY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-170-1200x900n (2).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-119-1200x900n (4).webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-111-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGAW9QhXvWIIldVYfxlGEiwASksIeFlfYy92t-GaAoqtdPcAnlBY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-212-1200x900n (1).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-86-1200x900n (7).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-6-1200x900n (3).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-206-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLEQG7RR3vBdVwdwQQwgXSjgRHn5waElTayNv7-GHb9qpcbpAizkQ41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-18-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLEgG9RBnvWIZ3IA0WkV_SiQQanpgdQFLdndmtp2WJ9_hZa5NylUQ41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-16-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCGQe9QhnvWoF2fwUXwgXSh1QWycpJEVWOy42v8jeJ96xbaZp3zxA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-218-1200x900n (9).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-17-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCGQe9QhnvD9JyIg0WkwLW2gFAn8hIQQeJmNis9TXe8K9ba8V3mRE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-112-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpKGQW_QxTvCYUiJwIUll_U2gASmZhPFwSKy9ynozOJ8qsPa5FzmkE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-183-1200x900n (1).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-285-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrRTHaZpgpMyz22ZbHVEnafnwalXXsetweLY81ZveSsTjAQKjt-e-EcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-280-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xjVRneaqgtMyDu2NrSHR3aZmQKrXSoesVHaNZ0E67D6HmQafTF5f-McSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-108-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFgC9QBjvWt5ydgUeyAOBiwgWnM0aQFeLzdynpWDZpKxeOMJ2lBE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-180-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFQO-QB7vWoR2IgNBkVLV3gAQmJ4eEQSAl9-m9mWA9qNbNsFyyEE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-204-1200x900n.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-290-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x_eRn2bpA5MmzLlMbaEECGXnlGpWXdEtVTdZZlZvbD-EjAfLGZ4euEcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-297-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWSXWcoQpMmjiyYbKIEXPNlFGlWn0TtgDWM8sFurOtH2YRejQqfrEcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 10);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-292-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x_eT3KepA5MmzLhZrGCFXTNnAGtX31CvQeKMcxZ6rDwGWFNKjB7f-AcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-302-1200x900n (2).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-79-1200x900n (2).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-114-1200x900n (3).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-51-1200x900n (2).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-53-1200x900n (3).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-237-1200x900n (7).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-264-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFgG_Rx7vDYYncAETwFHajlMQyM5OFQfdmIimozGI8KtZO8EjzkI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-306-1200x900n (8).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-118-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-46-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrUT3afqg9MzTq0MLDUHCGdmAr4WC1BsFDZZpwMtuOtSWFPJjt4d7YcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-311-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrUTXKapw1Mlm67Zb_SRnXNnAOlDywX51XXZ51YuuX8TWIYejQvf-ccSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-284-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrVRnWbpw5Mzz-zZuSEHXLKnFKlCixCt1SOYJsKuLepHmEffWcveuQcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-234-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpFGQK_RRjvC4YjIAMXyAPWiFJAyM4YRQaOzd2v9mKOqvtUPpNxz0c41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-265-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9DEwa9TRzvCtJ_cAMUxQXSjAAak8JJQFGLzdj68jPd8qpePZN4yBc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-289-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-293-1200x900n (6).jpg', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-296-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWSXaWpQ9MmzizYuTRHXedzwKuCSkQ4VXcZZkIv76qTTYfLWR6eeUcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 9);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-300-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWSHefowpMmj22YLeDFyKYmAGtDnwTtlLdZclct-DxHjNLfDAqK-YcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 13);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-310-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrfRneWpg5Ml2q1YOSGFXKclQqoW3ZC4AeJMZ1bvbf4GzYZKmZ_eLEcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-76-1200x900n.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-258-1200x900n.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-256-1200x900n (11).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-85-1200x900n (2).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-120-1200x900n (2).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (18, '18-107-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9FEAe9TBnvCtckJAJFxQKH3lYTyZ9LQQGMnor89TCL9qhfa5JznkM41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-262-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpEFQe7Qx_vWoUgcwYTyVHa3VYXksscS1CByo368jWIp6hdbpJ4lBA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-269-1200x900n (2).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-231-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGAW9QhXvWoInclNBll_UiAhGksJJEFTYzdD89jCJoPgJPZJ3zhE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-5-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-7-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzXSXyZpwdMnG62Y7LURXGfz1X_WX1F41HZYJgM7LaqSWseeDcue7AcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (43, '43-140-1200x900n (7).webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-0-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x_RSnyfpwlMnj2wYeSJR3efmFCrXiwVslfYNZsPv76sEmUYf2d7d-McSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-6-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWTXKYoAdMmT-zM7-IFHiczlL_WXcU51XXMcpetuTwE2EaL2F1erAcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-249-1200x900n (3).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-27-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xvVS3yWoQtMnjyxZeWDQXeZnFakWysWs1GNM5oFueerHGNNfGEpeeQcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-47-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xvWSXaWogZMnG62M77RFnDLyQCkWXsT4FSOMc0Fv-SqTWNLe2Mqe7ccSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-230-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwK6RB_vXdBydAUVyAeBiQRDkp4UEgSNl9usomGBpagJO5InyBI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-39-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x_eR3ecoAxMmz3hYLaFQSOflAD_Xy0e4FTXM8sEurepE2QdeGZ0eeQcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-33-1200x900n (4).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-244-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlAEQS6QxnvWIV-IFMUw1PRiFFDzZwVRVKPnNH69DeK8K8OPJEilBA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (33, '33-14-1200x900n (3).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-4-1200x900n (9).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-91-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1BEAS8RBnvWtJ0dAASx1OGjwdDn8pPF1GJnt79-DONp61UbZR4nBY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-0-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAG5RBjvXd52IgQewF_VjAlHk8xOS1aMl9r6pWaL8a5fbMJylUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-11-1200x900n.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-4-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwS1QxzvWN92fwEUxVLX21EUn8oVR1XcnY2m8TCP8fkMPsUlzks41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-107-1200x900n (9).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-77-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGQe8RBzvXdJ3IgYewFPb3lIVyMgdRlqKy9iq8TXd9qlePcEgnRc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-156-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDEgO5TR_vC98jIFFDx1LTigIXnJkfQ1WImYqq-DOK9q0JOJd5mBA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-101-1200x900n (3).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-102-1200x900n (6).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-103-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGA-_RhjvCdcjcVEVllfRiAhBmsIdEAPay9ipo2KKq65cbpV1yks41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-106-1200x900n (4).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-99-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwe_RxnvCtJyfgUWxFXW2wcSk59IQQbcn4_99mLb961absVzzUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-10-1200x900n (7).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-232-1200x900n (3).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-121-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXxBEw-1TBjvC9J3JFRGyADTilUVksJJSlOLmduu8jaK9a9dN5N3n0o41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-3-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCGQ-9RRvvWYYlJVcewwCAjVIRzc4bF1rdy4j89GeLpPlfOpsknUs41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-83-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAS5RBzvWNR_I1YewQKEilMRkpwURAfazdutoDTa9_gMOMAnz0I41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-138-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFA61QBXvDNEiJAcSyVeDjAJHkpsUFQSJn9Gr9DPbp6kLPsF3ykI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-150-1200x900n (2).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (9, '9-100-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDEQS_TRrvDNFzIgRBwlCB3lFHk58fS1vdz4-u9DWJqqsIN5ZyzUc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-5-1200x900n (1).webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-123-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1LEgW8Qx_vX9BxJAETkwTWjwVDnstLQFPYltin9zWAov9cP5cknEI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (10, '10-7-1200x900n (4).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (26, '26-239-1200x900n (1).jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-24-1200x900n (8).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-128-1200x900n (5).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-124-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1BEAS8RBnvDt8kcAJClF_S3QVBnskeQwaJnoyp9TWNoKkMPpIgmhE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-259-1200x900n (5).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-14-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFA-8QhTvBYRxcwEewAPUiQZAm5xIEFSLm4yuoDzdpvhbNsInlBY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-26-1200x900n (2).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-19-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFgO5RBvvCt9yIgcVwgLRjgRGk58VFgPbltmt9mXb96gLOpBzn0M41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-23-1200x900n (3).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (11, '11-22-1200x900n (5).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-148-1200x900n.webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-136-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFQa6RBXvWtJxcQMUx1PTiVVDys9OR1eAnYup9zeI9f4IPMJ1mEo41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-44-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9FEQa7QBXvCYV0d1EWwVLRjQIQk5kdEACKzd749jKK968IOpNzmhE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-154-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCGAe7TRvvCt4iJQ1GyAeG3lIbm8IZEQDYn42t-TaBoqIIbZEimUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (6, '6-70-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGQe-TRnvWtYlIFNBwVODiVQVzcpMSgaLmNz79mbdq6JVN5V2zxE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-38-1200x900n (6).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-32-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-27-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1CEw61TBjvBdZwflEXwl6EiAYTyZgaSlGMnIqp92DZpfwOacEkyUA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-42-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAC9RBzvWIJ3JQwewAXb3ghHmM0YRQeMy9z88zyO8vxaO5t0zhE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-49-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLEQC4Rx_vWYRwJVMWw1aAjwRGk8JMS1ONyoz98TyBpa5ZPJpzmUM41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-34-1200x900n (3).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-36-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX5AEgK7TRvvBNMjcAUXwVfU2wAWzcsZQAaOyor68WLcq6wJapR1zUY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-30-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9FEQG1QRjvWtInd1NGwV7R2QgXyZkVEFGOy4r78jTa8P5dbMAimEA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (12, '12-31-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9HFQO6RxrvXtQkIAQfx1OB3gkXm5gYFgCOmd-soGDcpK5bPpd2mRU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-56-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFwW6RxTvXdJ2dVcRlFXVjgEUz59JQAfcmt-s9mWA8aJZOpMlmUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbL (1).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-144-1200x900n (5).jpg', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-142-1200x900n (7).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-59-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAS0RhnvX9R1dgJFwgfa3QAWmMofFgCJnIv_8WeOp6sOO5Z1n0s41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-57-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAC4TBnvXdF_cFcQxVGAiQhAn5tMS1aMy96u9TDZpagObpJzz0Y41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-127-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1GEgW6Rh7vCdR_I1MWyVLW2lQWyMgaQQbdn4_79WaA8vtYPZoinkY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-129-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCEwS7RBjvX9cnIgZFwgLU3FNBks4bQlqAzNmo-TTbpPwONpYnlUU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-71-1200x900n (9).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-73-1200x900n.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-159-1200x900n (2).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-163-1200x900n (1).jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-46-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFA-9RBzvCN4idVAUyAOG3AURkssaFlWMzdH78zKJpaoPNpclyRc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-48-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGQa-RhTvCN8icQNExVKB2wARyJscFQCKnNmtpWbZpqtZacVxyhY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-52-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwK6RhvvD9VzflcXxQLahwcTn8sUSwGJmYr48GWPofxVbpsnmRY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (13, '13-41-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCGQC7QxjvXoIldgYUyAKHh1YVyM1MFlSIz9-t8jDep_sIasAnzxE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-63-1200x900n (1).webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-67-1200x900n (3).jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-58-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFA-_TBjvCd4lcFAXwVSEigQXnsgYRQSBmtmmpzSBp_4PN5MlzRA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (14, '14-62-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwS9QBnvBYJ-flEUwV7TjVEXycweF1DayNmr-DWMo6kLbMcjyhI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-146-1200x900n (9).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-122-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1BEAS8RBnvXYF2clQWxwXXjVRBm8gVR1bcytmp9DaAo6tbN5AkzhI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-72-1200x900n (2).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (33, '33-13-1200x900n (5).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-67-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwC7Rx3vXtV-IwwTw1SBilMazp4ZQAeLn96n9zPd8a9bapUilBc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-24-1200x900n (4).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-261-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFQS7RRzvDIEif1AWxwPbilQRm5xLRVfflt-m9jeIp_kLP5YklRc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-272-1200x900n (5).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-26-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzXSn2fpAdMlm62Z7HSQXWZnwD6WntB4VaOZ50I6-P_T2VNLmd4d-YcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (32, '32-0-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x3eTXebogdMmDLiYbDTFnXNlVavXH5GvVuKMZoKu7fwEjZIeDd5duQcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-66-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFAG4Qx3vDIZxIg1Ewl-A2gBEyMNIElWMmo2p9zTdpq9fasB3lRU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-103-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpEFAK9TBzvDIJ1IwREyVWG2wkUmsIVFlCImdj6pDWLqvlbbcF0yEU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-96-1200x900n (5).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-102-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpEGA-0TBXvXYVxJFQQxQCEhwBHm80eR1bdmdmt9D2P8KIONpAkzxA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-82-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFgO5RxzvCNRwdFZExlLRiwAWnc8bFwGOl9Cp8D2MoqwINsF2ykc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-87-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-85-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpHFwC7QRvvX4JwJFNBxVKA2VRAycwdQQaAm9GqoDeN8P9cO5V4lBA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (19, '19-125-1200x900n (1).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (20, '20-132-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX5AFge9QB_vWIIjdFdFlQWB3lFGyckYR1KJnY2v-TOM9a5VPZJ5yEI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-86-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwe4RBnvDtZ1JVdEkgLRjgYVmpwZSlTczNn8-D2LpapUbMd4mEs41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (16, '16-89-1200x900n (2).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-151-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlAEQS-RhXvXt4ldAUfxwSDi1MSnZlMRgPdzNyv8TSOqvxebJcgnUc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (21, '21-152-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFA68QhrvWNVxJFcfwQDah1NGnc0cRAGJzY-rp2eN8aNbbcInzhU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-207-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1CEA-6RxvvWt8nflMUxV_X2gEVncpOElGImtCn-D2BqvwOP8IimxU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-164-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1CFAe6QR3vD4Fzf1EXllPXjlEVmcMYRVranIus9jGLp6wLNpB3lUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQ.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (16, '16-91-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1AEwe8Qh_vCt5_cAAXwFSAiQhDzsgURwGKy4j882CIoagON5cgyBc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-186-1200x900n (4).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-227-1200x900n (14).jpg', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-177-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCEwS6TR7vCdQncAYVxgXaiglEnp8UQgCPzN_8-WeL8fxVbcFxnhE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-168-1200x900n (1).jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (33, '33-12-1200x900n (1).webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-21-1200x900n (1).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-195-1200x900n (5).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-200-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFQC8RRTvWoUjcAdGkwTW3lQSzs5LEFLfyt76pTPe9_sIOMJzzhA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-196-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFge1TBjvCtVzJ1ZFwlPRi1YRm88cRFTdzY2v8zbZq_4POMUlzRE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-271-1200x900n.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (28, '28-266-1200x900n (3).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-243-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFgO_QRjvCIRxdgIVw1LRjwcVz59JQQaNltys-GGLpf8IPcEnm0E41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-240-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9AEA65Rh3vXtAgfgRDyVXShgUUmcxMEFSIl9r992LZoa0PbJRzzUc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (27, '27-255-1200x900n (10).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-19-1200x900n (5).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (33, '33-10-1200x900n (4).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (16, '16-86-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9HFAa0Qh3vWdF2cFcUyF7bhghDzZgbFleNmYr89DSBp_xfOpUklEo41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-63-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9EEQK7Rh7vX9d_cVMVllHaj1JHn85OQFKJl4qv-GLeqqtaN5AknRI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-171-1200x900n.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (16, '16-90-1200x900n (1).jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-214-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX5BEga4QhrvBIUgcwxCxAXbiVURzs4VR1rfzdH_92fdqvxZasBwmRI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-181-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwG4Rh7vXYYiI1dGlVPRjFYXys0VFlXczIupojfbq65VOZt3zUE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-197-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFg65Qx3vWYUjJQYXwlOHilNEks4eS1uInt6rpTaLo_5ba5p5zUU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-211-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX5AEgK7TRvvX4IndgIRyFWB3gISnMMfRwbfyNmv9zGM9_gOPJJ3lRY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-169-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9BEwC5QR7vXdJ3IgwTk1CE3lVGmpxISgSBndz99TSPovxcbsYimEM41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-282-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrURn2WpAlMyzi2YOfUQnidlAqlVXsUswSMZZkFurb-H2FPfTt0f-IcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-273-1200x900n (1).webp', 7);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-100-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCEwS0RhTvWtQkIANDyFTXjwgQnJ4eEQGMzNr_9jeOoK8JNpZzyUA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (33, '33-9-1200x900n (2).webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-110-1200x900n (10).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-184-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLGAC9TR7vCYN-dFAfxFSDiwZBzspIEVKOndit8jGNq6NaP8Z5mUY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-198-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFQG_QBzvBddyJwMfkQeGiwURksJJQwGKmdCt8TLep6xUa5pynxU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-97-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCEg-5QRvvDdJ_IwcTll_aigJEk5gdR1fbmd6t9GaNoa8IPsV0m0I41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (39, '39-95-1200x900n (9).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (40, '40-104-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLGQe6TRjvC9cnI1cWyQTX3VNHn59MF1SIyNz7o2feqqxVbpB4mUA41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (34, '34-23-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xrVTnSbpwZMmGixZuTVE3meyAH6DXYQtlvbZJYE6eT_HGsQLDF4e-EcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-277-1200x900n (7).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-288-1200x900n (3).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-298-1200x900n (4).webp', 11);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-294-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWS3aeoA9Myj-wZbGBQXjOlAP9WXcX4VGMY80Ftrb5TmEfKGEve-scSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.jpg', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-301-1200x900n (1).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-82-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlCFA-8QxrvXYR_J1MelFeE3AdBkpgbRAePm9H8pzbcov5YOcEimUI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-89-1200x900n (4).jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-83-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpKFwS6RBvvXtZ_cgYfxl-E3AISys0fEVbYm4v8pGKMoPhYbMcimhI41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-166-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9LFQ-7Qx_vWNJ-cAYWxFbW2gNHnc8bRwOByIqu9Gfc8PkJOpR1nkM41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (16, '16-92-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (22, '22-167-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1AEwe8Qh_vBIN-cAwfwVLThwUamssdQACPzdGnoGbe8PxaOZV5nxY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-229-1200x900n.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-228-1200x900n (15).webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-286-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xvVTHCeoAtMymq3ZrTSFnKXlACsDnhC5geMNM4I7LKsHmYZKDJ1fbYcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (29, '29-274-1200x900n (2).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (31, '31-305-1200x900n (9).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-203-1200x900n (1).webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-192-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDGAW9QhXvD9F2JAYTw1Lb3gUanc1OFlGJmdn99jyJpv5fNsVxlBc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (23, '23-194-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpLEwW8RxTvDIJzfwQUyAKD2VYamM0dF1aPzNmr82aP8qJbPJMlyRE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (24, '24-201-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFwK_RhnvWYF1cAcRx1XSjFJHycIVEVvcyt7_pDKPpP5fbJRzlEE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHE.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-30-1200x900n (3).webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-71-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (37, '37-64-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9HEge1RhTvXtFzcQJBwlKA3QEXys0aFQbclo2upDHd8PkJNsVwnxY41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (25, '25-219-1200x900n (2).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-287-1200x900n (1).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-291-1200x900n (2).jpg', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (17, '17-106-1200x900n.jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (17, '17-100-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXlDFgK_Qx_vXYJ-clAXxQTWj1ITmcoUQVXdy4j8pDOMpv4MPMBwzkc41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (17, '17-103-1200x900n (2).webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-295-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xzWRnGXog1Mnj61N7HTRiOWmgT5CiwW5lCNZpoM7L_6GDdIfTd0drEcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 8);
INSERT INTO public.image (car_id, filename, images_order) VALUES (30, '30-299-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6x_fRnaYoAdMmjy2N-SBF3TOywOqDylF51CJM50EveT4SjcbLzB5LeAcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm4.webp', 12);
INSERT INTO public.image (car_id, filename, images_order) VALUES (35, '35-32-1200x900n (7).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (7, '7-81-1200x900n (1).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (17, '17-102-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (43, '43-135-1200x900n (1).webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (44, '44-141-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-157-1200x900n.webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-166-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xveR3Obpw5Mmju2ZefVEnXNmAGvDn1EslCMYZcJ7rWtSjQYKmB1fbAcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-95-1200x900n (1).webp', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-98-1200x900n.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-92-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1GGAa0TB3vDdEgdA1CkwfW3gQRmp9JRQfdnY399jbbp_gLP5d4n0A41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.jpg', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-96-1200x900n (2).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (8, '8-90-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX1LEgW8Qx_vXYJzflFDlQWAiQlBmZ8VQwaNyI2v-WKI9aoObJEjlUQ41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (44, '44-145-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xnWR3Waog1MnW-yNLSCQnGblVGqWncf5AGMb5pZueDwGWBPJzF4feAcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL9.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (44, '44-142-1200x900n (3).jpg', 0);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-162-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xjVT3abow1MmT6wML7URibKyAuqW3gU51XbZJwJt-T5SjRMJjEoLOIcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (43, '43-137-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxXpEFAK-QRrvD4J2IwESk1SBjggUmpsYEVPdnNuu9TCLpa9ebJsglUU41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQ.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-27-_-1ZcrgtABr0G_VEnmDEw74IxxFL5drYscqdvTrzoukBOgoxX9DEwa9TRzvDtMlfgdFkwfS21ISm8oUEATfnNiu-TPdpa4Pa8BzzkE41kRG5jVAATCeUUmrCkHfy-63zjvJOp8_HQ9F-Cpy4FSGAgV9fqIwoM5mV9quXgsW-8me9JhT6MHfHEnbLM8xQpQS.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (3, '3-33-1200x900n (3).webp', 5);
INSERT INTO public.image (car_id, filename, images_order) VALUES (44, '44-143-1200x900n.jpg', 2);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-148-1200x900n (1).webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (43, '43-139-1200x900n.webp', 1);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-160-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xjTT32fpwZMnmi0MLWIFyOflVasWS1E4APXYpsLubSsTmoRfWd0f-YcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 4);
INSERT INTO public.image (car_id, filename, images_order) VALUES (44, '44-144-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xnWR3Waog1MljqzMLSBEnjKywD6DnlEtgHXYJZf6eD5SjQdKWd-LLEcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL9.webp', 3);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-163-z757pYfER6cWI3sl0dz7CERJKDiOx69KlRxerT3S8qleSv6xjVTnabpwdMyG3mZOTSHSWfzACuDilEswCJMp4IvrHxSWUaeGQpd-YcSJj4mlLOx5flQN_FcfLB8_0TQKrFvbFaiFE328xhQ9hq8zbr910szMpk5BkLbtcJjT_MUOrJsm49R0R7CiiFXDL.webp', 6);
INSERT INTO public.image (car_id, filename, images_order) VALUES (45, '45-152-1200x900n (6).webp', 2);
