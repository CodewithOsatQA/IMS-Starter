package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long customerId;
	private Long orderId;
	private Long itemId;
	private Long quantity;
	
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
	

	public Orders(Long customerId, Long itemId, Long orderID) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setOrderId(orderID);
	}
	
	public Orders(Long customerId, Long itemId, Long orderId, Long quantity) {
		this.setCustomerId(customerId);
		this.setItemId(itemId);
		this.setQuantity(quantity);
		this.setOrderId(orderId);
		
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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Orders [CustomerId=" + customerId + ", OrderId=" + orderId + ", ItemId=" + itemId  + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
