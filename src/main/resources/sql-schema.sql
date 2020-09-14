drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;
USE `ims` ;
CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`products`(
	`id` INT(10)  NOT NULL AUTO_INCREMENT,
	`ITEM_NAME` VARCHAR(40),
	`Quantity` INT(10) DEFAULT 100,
	PRIMARY KEY (`id`) 
);


CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`CustomerID` INT,
	`orderID` INT(10)  NOT NULL AUTO_INCREMENT,
	`item_id` INT(10),
	FOREIGN KEY (`CustomerID`) REFERENCES customers(`id`)
	FOREIGN KEY (`item_id`) REFERENCES products(`id`)
	
);