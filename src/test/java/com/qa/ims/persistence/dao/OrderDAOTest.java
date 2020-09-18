package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	private final OrderDAO DAO = new OrderDAO();

	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Orders created = new Orders(1L);
		Orders test = DAO.create(created);
		assertEquals(created.getOrderId(), test.getItemId());
	}

	
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		expected.add(new Orders("jordan harrison",1L,0L));
		assertEquals(expected, DAO.readAll());
	}
	 
	  
	
	@Test public void testReadLatest() { 
		assertEquals(new Orders (1L).getCustomerId(), DAO.readLatestOrder().getCustomerId()); 
		}
	 
	 @Test public void testRead() { 
		 final long ID = 1L; 
		 assertEquals(new Orders(ID).getCustomerId(), DAO.readOrder(ID).getCustomerId()); }
	 
		/*
		 * @Test public void testUpdate() { final Product updated = new Product(1L,
		 * "COKE", 4L); assertEquals(updated, DAO.update(updated));
		 * 
		 * }
		 */
	 
	 @Test public void testDelete() { assertEquals(1, DAO.delete(1)); }
	 
}
