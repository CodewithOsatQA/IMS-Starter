package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class ProductController implements CrudController<Product> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ProductDAO productDAO;
	private Utils utils;

	public ProductController(ProductDAO productDao, Utils utils) {
		super();
		this.productDAO = productDao;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Product> readAll() {
		List<Product> products = productDAO.readAll();
		for (Product product : products) {
			LOGGER.info(product.toString());
		}
		return products;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Product create() {
		LOGGER.info("Please enter a product name");
		String productName = utils.getString();
		/*
		 * LOGGER.info("Please enter a surname"); String surname = utils.getString();
		 */
		Product product = productDAO.create(new Product(productName));
		LOGGER.info("Product created");
		return product;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Product update() {
		LOGGER.info("Please enter the id of the product you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter quantity in new shipment");
		Long newQuantity = utils.getLong();
		
		Product product = productDAO.update(new Product(id, newQuantity));
		LOGGER.info("Product Updated");
		return product;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the product you would like to delete");
		Long id = utils.getLong();
		return productDAO.delete(id);
	}

}
