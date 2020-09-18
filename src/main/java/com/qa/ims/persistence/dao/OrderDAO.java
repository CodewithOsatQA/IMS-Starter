package com.qa.ims.persistence.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		String customerName = resultSet.getString("customer");
		Long item_id = resultSet.getLong("item_id");
		Long total = resultSet.getLong("total");
		
		return new Orders(customerName,item_id, total);
	}
	
	public Orders modelFromResultSetOrders(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("orderID");
		Long customerId = resultSet.getLong("CustomerID");
		/*
		 * Long item_id = resultSet.getLong("item_id"); Long orderline_id =
		 * resultSet.getLong("orderlineID");
		 */
		Orders newOrder = new Orders(customerId);
		
		newOrder.setOrderId(orderId);
		return newOrder;
	}
	public Orders modelFromResultSetOrderline(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("item_id");
		/*
		 * Long item_id = resultSet.getLong("item_id"); Long orderline_id =
		 * resultSet.getLong("orderlineID");
		 */
		Orders newOrder = new Orders(customerId);
		
		newOrder.setOrderId(orderId);
		return newOrder;
	}
	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Orders> readAll() {	
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				
				//resultSet = statement.executeQuery("select * from orderline");
				
				ResultSet resultSet = statement.executeQuery(
						"select orders.CustomerID, orderline.item_id, concat(customers.first_name,\" \", "
						 + "customers.surname) as customer, products.ITEM_NAME, products.Price, " +
						 "price as total from orders, orderline, products, customers where orders.CustomerID = "
						 +
						 "orderline.order_id and products.id = orderline.item_id and orders.customerId= customers.id order by orders.orderID, orderline.item_id;"
						 );
				
				
				) {
				
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatestOrder() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY CustomerID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSetOrders(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY CustomerID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	/**
	 * Creates a customer in the database
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Orders create(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orders(CustomerID) values('" + order.getCustomerId() + "')");
			
			/*
			 * statement.executeUpdate("INSERT INTO orderline(order_id, item_id) values('"+
			 * order.getCustomerId() + "','" + order.getItemId() + "')");
			 */
			
			return readLatestOrder();
		} catch (Exception e) {
			
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + id);) {
			resultSet.next();
			return modelFromResultSetOrderline(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 * 
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Orders update(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			/*
			 * statement.executeUpdate("update orderline set item_id ='" + +
			 * order.getItemId() + "' where CustomerID =" + order.getCustomerId());
			 */
			
			statement.executeUpdate("INSERT INTO orderline(order_id, item_id) values('" + order.getCustomerId() + "','" + order.getItemId()  + "')");
			return readOrder(order.getCustomerId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	public Orders updateCustomer(Orders order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			
			 statement.executeUpdate("update orderline set order_id ='" + order.getItemId() + "' where CustomerID =" + order.getCustomerId());
			 
			
			/*
			 * statement.
			 * executeUpdate("update orderline set order_id =(order_id, item_id) values('" +
			 * order.getCustomerId() + "','" + order.getItemId() + "')");
			 */
			return readOrder(order.getCustomerId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orderline where order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
