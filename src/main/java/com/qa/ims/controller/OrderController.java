package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Orders;

import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = orderDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter the ID for the customer who is placing the order");
		Long CustomerID = utils.getLong();		
		 
		Orders order = orderDAO.create(new Orders(CustomerID));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		/*
		 * Long id = null, item_id = null; String input = "";
		 * LOGGER.info("Please enter the option you would like to take");
		 * 
		 * Orders order = new Orders(id,item_id); do {
		 * 
		 * switch(input) { case "customer": LOGGER.
		 * info("Please enter the customer id for the order you would like to update");
		 * id = utils.getLong(); LOGGER.info("Please enter the new id for the order");
		 * item_id = utils.getLong(); order = orderDAO.updateCustomer(new Orders(id,
		 * item_id)); break; case "item": //update order -- change item
		 * 
		 * break; case "add": LOGGER.
		 * info("Please enter the customer id for the order you would like to update");
		 * id = utils.getLong();
		 * LOGGER.info("Please enter the id for the item you would like to add"); break;
		 * default: System.out.println("hello"); }
		 * 
		 * } while(!input.equalsIgnoreCase("break"));
		 */
		
		//update order -- change customer
		LOGGER.info("Please enter the customer id for the order you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter the item id you want to add");
		Long item_id = utils.getLong();
		//update order -- 
		
		
		
		
		LOGGER.info("Product Updated");
		Orders order = orderDAO.update(new Orders(id,item_id));
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the product you would like to delete from the order");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
