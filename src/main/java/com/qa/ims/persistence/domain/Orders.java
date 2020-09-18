package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long customerId;
	private Long orderId;
	private Long itemId;
	private Long cost;
	private String name;
	
	/*
	 * public Orders(Long customerId, Long itemId, Long quantity) {
	 * 
	 * this.setItemId(itemId); this.setQuantity(quantity);
	 * 
	 * }
	 */
	public Orders( Long customerId) {
		this.setCustomerId(customerId);
		
	}
	public Orders( Long customerId, Long itemId) {
		this.setItemId(itemId);
		this.setCustomerId(customerId);
		
	}
	

	public String getName() {
		return name;
	}
	public Orders(Long customerId, Long itemId, Long orderID) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setOrderId(orderID);
	}
	
	public Orders(Long customerId, Long itemId, Long orderId, Long cost) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setCost(cost);
		this.setOrderId(orderId);
		
	}
	
	public Orders(String name, Long item_id, Long cost) {
		this.setName(name);
		this.setCost(cost);
		this.setItemId(item_id);
	}
	

	public void setName(String name) {

		this.name = name;
		
	}
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost= cost;
	}

	@Override
	public String toString() {
		//return "Order: "+ orderId + " CustomerId: " + customerId + " ItemId: " + itemId  + " cost = "+ cost;
		return "Customer Name: "+ name + " ItemId: "+ itemId + " Order total: " + cost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}





}
