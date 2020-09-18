INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `ims`.`products` (`item_name`) VALUES('COKE');
INSERT INTO `ims`.`products` (`item_name`) VALUES('FANTA');
INSERT INTO `ims`.`products` (`item_name`) VALUES('Rubicon MANGO');
INSERT INTO `ims`.`products` (`item_name`) VALUES('Rubicon SOMETHING ELSE');
INSERT INTO `ims`.`orders` (`CustomerID`) VALUES (1);
INSERT INTO `ims`.`orderline` (`order_id`,`item_id`) VALUES (1,1);
--INSERT INTO `ims`.`orderline` (`order_id`,`item_id`) VALUES (1,2);
--INSERT INTO `ims`.`orderline` (`order_id`,`item_id`) VALUES (1,3);
