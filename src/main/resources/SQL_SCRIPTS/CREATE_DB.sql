-- create user test pass test
CREATE USER 'test'@'localhost' IDENTIFIED BY 'test';
GRANT ALL PRIVILEGES ON * . * TO 'test'@'localhost';

-- create db
DROP SCHEMA IF EXISTS `tech_task`;

CREATE SCHEMA `tech_task`;

use `tech_task`;

SET FOREIGN_KEY_CHECKS = 0;

-- store
DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `store_name`  VARCHAR(50)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- category
DROP TABLE IF EXISTS `store_category`;

CREATE TABLE `store_category`
(
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(50),
  `store_id` INT,
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`store_id`)
  REFERENCES `store` (`id`),

  UNIQUE KEY `TITLE_UNIQUE` (`category_name`)

)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- goods
DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title`  VARCHAR(50),
  `price`  FLOAT(6, 2),
  `status` VARCHAR(50),
  `category_id` INT ,

  CONSTRAINT `FK_GOODS`
  FOREIGN KEY (`category_id`)
  REFERENCES `store_category` (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;
