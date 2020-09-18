package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ProductController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ProductDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Product;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private ProductDAO dao;

	@InjectMocks
	private ProductController controller;

	@Test
	public void testCreate() {
		final String productName = "Fanta";
		final Long price = 4L;
		final Product created = new Product(productName, price);

		Mockito.when(utils.getString()).thenReturn(productName);
		Mockito.when(utils.getLong()).thenReturn(price);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Product> products = new ArrayList<>();
		products.add(new Product(1L, "COKE", 0L));

		Mockito.when(dao.readAll()).thenReturn(products);

		assertEquals(products, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Product updated = new Product(1L, "COKE", 4L);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		
		Mockito.when(this.utils.getLong()).thenReturn(updated.getPrice());
		System.out.println(Mockito.when(this.utils.getLong()).thenReturn(updated.getPrice()));
		

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}
