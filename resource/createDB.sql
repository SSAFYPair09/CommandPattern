CREATE DATABASE  IF NOT EXISTS `enjoyssafy`;
USE `enjoyssafy`;

DROP TABLE IF EXISTS `members`;

CREATE TABLE `members`(
  `id` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email` varchar(50),
  `age` int,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `members` VALUES ('aa','111','admin','admin@ssafy.com',24);

DROP TABLE IF EXISTS `enjoyssafy`.`checkip` ;
DROP TABLE IF EXISTS `enjoyssafy`.`records` ;

CREATE TABLE IF NOT EXISTS `enjoyssafy`.`records` (
  `ip` VARCHAR(50) NOT NULL,
  `count` INT NOT NULL,
  `last_request` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ip`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `enjoyssafy`.`post`;

CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    content VARCHAR(5000),
    author VARCHAR(100),
    visited INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
