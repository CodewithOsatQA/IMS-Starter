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
	`Price` INT(10),
	PRIMARY KEY (`id`) 
);


CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`orderID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`CustomerID` INT(10),
	FOREIGN KEY (CustomerID) REFERENCES customers(id) on delete cascade
	
);

CREATE TABLE IF NOT EXISTS `ims`.`orderline`(
	`orderlineID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`order_id` int,
	`item_id` int,
	CONSTRAINT foreign key (order_id) references orders (CustomerID) ON DELETE CASCADE,
	CONSTRAINT foreign key (item_id) references products (id) ON DELETE CASCADE

);





