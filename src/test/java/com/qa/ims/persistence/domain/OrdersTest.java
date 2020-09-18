package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class OrdersTest {
	
	//private static final Object Object = new Object();
	Orders testOrder = new Orders(1L,2L);
	
	
	@Test
	public void getItemId() {
		Long testId = new Long (2);
		assertEquals(testOrder.getItemId(), testId);
	}
	@Test
	public void setItemId() {
		Long testId = new Long (4);
		testOrder.setItemId(testId);
		assertEquals(testOrder.getItemId(), testId);
	}
	@Test
	public void setOrderId() {
		Long testId = new Long (4);
		testOrder.setOrderId(testId);
		assertEquals(testOrder.getOrderId(), testId);
	}
	@Test
	  public void getCustomerId() { 
		  Long testId = new Long (4);
	  testOrder.setCustomerId(testId); 
	  assertEquals(testOrder.getCustomerId(), testId); 
	  }
	@Test
	
	public void testCost() {
		Long testCost = new Long(78);
		
		testOrder.setCost(testCost);
		assertEquals(testOrder.getCost(), testCost);
	}
	@Test
	public void testName() {
		
		String name = "banana";
		testOrder.setName(name);
		assertEquals(testOrder.getName(),name);
		
	}
	@Test
	public void testConstructor(){
		Orders newOrder = new Orders(3L);
		assertEquals(newOrder.getCustomerId(),(Long)3L);
		
		newOrder = new Orders("Coke",2L,7L);
		
		assertEquals(newOrder.getName(), "Coke");
		
		newOrder = new Orders(2L,3L,6L);
		
		assertEquals(newOrder.getOrderId(), (Long)6L);
		
		newOrder = new Orders (1L,2L,3L,4L);
		
		assertEquals(newOrder.getCost(), (Long)4L);
	}
	
	
	@Test
	public void testEquals() {
		Object obj = new Object();
		Object nullObj = null;
		Orders testOrder2 = new Orders(2L);
		testOrder2.setCost(null);
		testOrder2.setCustomerId(null);
		testOrder2.setItemId(null);
		testOrder2.setName(null);
		testOrder = new Orders(1L,2L,34L,67L);
		assertEquals(testOrder, new Orders(1L,2L,34L,67L));
		assertTrue(testOrder.equals(testOrder));
		assertFalse(testOrder.equals(obj));
		assertFalse(testOrder.equals(nullObj));
		
		assertFalse(testOrder2.equals(testOrder));
		testOrder.setCost(null);
		testOrder.setCustomerId(null);
		testOrder2.setCost(23L);
		assertFalse(testOrder.equals(testOrder2));
		testOrder.setCost(45L);
		assertFalse(testOrder.equals(testOrder2));
	}
	@Test
	public void testToString() {
		assertTrue(testOrder.toString().getClass().equals(String.class));
	}
	 
}
