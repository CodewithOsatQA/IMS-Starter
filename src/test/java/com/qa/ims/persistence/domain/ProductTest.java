package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ProductTest {
	
	Long itemId = new Long(1);
	Long itemPrice = new Long(20);
	
	Product testProduct = new Product(itemId, itemPrice);
	
	@Test
	public void testGetPrice() {
		Long testPrice = new Long(20);
		assertEquals(testProduct.getPrice(),testPrice);
		//EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	@Test
	public void testGetId() {
		Long testId = new Long(2);
		assertNotEquals(testProduct.getId(),testId);
	}
	
	

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}




}
