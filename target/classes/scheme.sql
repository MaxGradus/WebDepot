SET FOREIGN_KEY_CHECKS=0;


CREATE DATABASE `web_depot_db`
CHARACTER SET 'utf8'
COLLATE 'utf8_general_ci';



CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;


CREATE TABLE web_depot_db.placements(
  `placeId` int(11) NOT NULL AUTO_INCREMENT,
  `placeName` varchar(64) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `date` DATETIME(64) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`placeId`),
  KEY `fk_place_index` (`userId`),
  CONSTRAINT `fk_place_constraint` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(10) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`userId`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO users (userId, login, password, email, ENABLED)  VALUES (1, 'admin', 'admin', 'admin@gmail.com', TRUE);
INSERT INTO users (userId, login, password, email, ENABLED)  VALUES (2, 'user_1', 'user1', 'user1@gmail.com', TRUE);
INSERT INTO users (userId, login, password, email, ENABLED)  VALUES (3, 'user_2', 'user2', 'user2@gmail.com', TRUE);
INSERT INTO users (userId, login, password, email, ENABLED)  VALUES (4, 'user_3', 'user3', 'user3@gmail.com', TRUE);

INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (1, 'Place_1', 100, NULL , NULL);
INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (2, 'Place_2', 100, NULL , NULL );
INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (3, 'Place_3', 150, NULL , NULL);
INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (4, 'Place_4', 150, NULL , NULL);
INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (5, 'Place_5', 200, NULL , NULL);
INSERT INTO placements (placeId, placeName, price, date, userId) VALUES (6, 'Place_6', 200, NULL , NULL);

INSERT INTO user_roles (USER_ROLE_ID, userId, AUTHORITY) VALUES (1, 1, 'ROLE_USER');
INSERT INTO user_roles (USER_ROLE_ID, userId, AUTHORITY) VALUES (2, 1, 'ROLE_ADMIN');
INSERT INTO user_roles (USER_ROLE_ID, userId, AUTHORITY) VALUES (3, 2, 'ROLE_USER');
INSERT INTO user_roles (USER_ROLE_ID, userId, AUTHORITY) VALUES (4, 3, 'ROLE_USER');




# CREATE TABLE web_depot_db.users_places
# (
#   userId INT NOT NULL,
#   placeId INT NOT NULL,
#   KEY `FKADD16E575326420C` (`userId`),
#   KEY `FKADD16E574A2FCC` (`placeId`),
#   CONSTRAINT `FKADD16E574A2FCC` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
#   CONSTRAINT `FKADD16E575326420C` FOREIGN KEY (`placeId`) REFERENCES `placements` (`placeId`)
# );

# CREATE TABLE web_depot_db.placements
# (
#   placeId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   placeName VARCHAR(64) NOT NULL,
#   price INT NOT NULL,
#   date BIGINT
# );


# CREATE TABLE `users_places` (
#   `userId` int(11) NOT NULL,
#   `placeId` int(11) NOT NULL,
#   PRIMARY KEY (`userId`,`placeId`),
#   KEY `fk_users_places_1_idx` (`userId`),
#   KEY `fk_users_places_2_idx` (`placeId`),
#   CONSTRAINT `fk_users_places_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
#   CONSTRAINT `fk_users_places_2` FOREIGN KEY (`placeId`) REFERENCES `placements` (`placeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
# ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# CREATE TABLE web_depot_db.users
# (
#   userId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
#   login VARCHAR(64) NOT NULL,
#   password VARCHAR(64) NOT NULL,
#   email VARCHAR(64) NOT NULL
# );