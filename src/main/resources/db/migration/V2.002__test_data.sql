insert into users (name, surname,phone_number,email,password)
values
('Tom', 'Holland', '89467839947', 'holland@mail.ru','tom1029'),
('Tom', 'Felton', '89375806654', 'felton@gmail.com','t1278');

insert into user_tokens (user_id,access_token,refresh_token)
values
(1,'4389674967','54675968656'),
(2,'4760546750','57665978500');

insert into travels (user_id,departure_point,destination_point,departure_date,destination_date)
values
(2,'Moskow','Saint Petersburg','2022-02-12','2022-02-20'),
(1,'Moskow','Kazan','2022-05-15','2022-05-25');


insert into poputchiki (poputchik_id,travel_id)
values
(1,2),
(2,1);

insert into places (city,description,photo)
values
('Moskow','Moscow, on the Moskva River in western Russia, is the nation’s cosmopolitan capital. In its historic core is the Kremlin, a complex that’s home to the president and tsarist treasures in the Armoury. Outside its walls is Red Square, Russia’s symbolic center. It is home to Lenin’s Mausoleum, the State Historical Museum’s comprehensive collection and St. Basil’s Cathedral, known for its colorful, onion-shaped domes.','http://localhost:8081/img/Moskow.jpg'),
('Saint Petersburg','St. Petersburg is a Russian port city on the Baltic Sea. It was the imperial capital for 2 centuries, having been founded in 1703 by Peter the Great, subject of the city`s iconic “Bronze Horseman” statue. It remains Russia`s cultural center, with venues such as the Mariinsky Theatre hosting opera and ballet, and the State Russian Museum showcasing Russian art, from Orthodox icon paintings to Kandinsky works.','http://localhost:8081/img/Nizhny%20Novgorod.jpg'),
('Kazan','Kazan is a city in southwest Russia, on the banks of the Volga and Kazanka rivers. The capital of the Republic of Tatarstan, a semi-autonomous region, it is known for the centuries-old Kazan Kremlin, a fortified citadel containing museums and sacred sites. Kremlin landmarks include the tiered Tower of Soyembika, the blue-and-gold domed Annunciation Cathedral and the vast, colorful Kul Sharif Mosque.','http://localhost:8081/img/Kaliningrad.jpg'),
('Nizhny Novgorod','Nizhny Novgorod is a large city on the Volga River in western Russia. It’s known for its 16th-century Kremlin, ringed by 13 fortified towers, including the Dmitrovskaya Tower. Within the Kremlin’s walls is the green-spired Cathedral of the Archangel Michael, rebuilt in the 17th century. Nizhny Novgorod State Art Museum, housed in a grand building, exhibits Russian and European paintings and a collection of icons.','http://localhost:8081/img/Voronezh.jpg'),
('Tula','Tula is a city in western Russia. It is home to the Tula Kremlin, a 16th-century stone fortress encompassing towers, cathedrals and a 19th-century shopping arcade. The Tula State Museum of Weapons has a vast collection of guns and army memorabilia. The Samovar Museum explores the history of the ornate tea urn, a Tula specialty. To the southwest is Yasnaya Polyana, a museum in the former home of writer Leo Tolstoy. ','http://localhost:8081/img/Omsk.jpg'),
('Sochi','Sochi, a Russian city on the Black Sea, is known as a summer beach resort, and was host of the 2014 Winter Olympics. Its parks include the palm-filled Arboretum. It is also notable for 20th-century neoclassical buildings such as the columned Winter Theatre. Forested Sochi National Park is a 1,937-sq.-km protected area in the nearby Caucasus Mountains. Some 70 km inland, Krasnaya Polyana is a prominent ski resort. ','http://localhost:8081/img/Tula.jpg'),
('Kaliningrad','Kaliningrad is the capital of the Russian province of the same name, sandwiched between Poland and Lithuania along the Baltic Coast. Dubbed Königsberg during centuries of Prussian rule, the city was largely reconstructed after WWII. Traces of its German heritage can be seen in the surviving Brandenburg Gate and the riverside Fishing Village, a dining and shopping destination with re-created medieval-style buildings.','http://localhost:8081/img/Sochi.jpg'),
('Omsk','Omsk is a city on the Irtysh River in the vast Russian region of Siberia. The central Vrubel Museum of Fine Arts, in 2 pastel-colored buildings, displays Fabergé creations, Russian paintings and porcelain. Nearby, the ornate facade of Omsk Drama Theater is topped with a winged sculpture. St. Nicholas Cossack Cathedral, dating from the 1840s, and the gold-domed Assumption Cathedral are holy landmarks.','http://localhost:8081/img/Saint%20Petersburg.jpg'),
('Voronezh','Voronezh is a city on the Voronezh River in southwestern Russia. Landscaped Petrovsky Park is home to a bronze statue of Peter I. Housed in a baroque building, the Voronezh Regional Art Museum has collections of Ancient Egyptian art and several centuries of Russian paintings. The ship museum Goto Predestination recreates 18th-century naval life. Scarlet Sails park has pine trees, playgrounds and an outdoor theater.','http://localhost:8081/img/Kazan.png');

