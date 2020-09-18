package com.qa.ims.persistence.domain;

public class Product {

	private Long productId;
	private String productName;
	private Long price;

	public Product(String productName) {
		this.setProductName(productName);
		
	}
	public Product(String productName, Long price) {
		this.setPrice(price);
		this.setProductName(productName);
		
	}
	public Product (Long id, Long price) {
		this.setId(id);
		this.setPrice(price);
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	public Product(Long id, String productName, Long price) {
		this.setId(id);
		this.setProductName(productName);
		this.setPrice(price);
	}

	public Long getPrice() {
		return price;
	}

	public Long getId() {
		return productId;
	}

	public void setId(Long id) {
		this.productId = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	

	/*
	 * public String getSurname() { return surname; }
	 * 
	 * public void setSurname(String surname) { this.surname = surname; }
	 */

	@Override
	public String toString() {
		return "id: " + productId + " Item: " + productName + " Price: £" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		Product other = (Product) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	

}
