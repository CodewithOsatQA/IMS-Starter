package com.qa.ims.persistence.domain;

public class Product {

	private Long productId;
	private String productName;

	public Product(String productName) {
		this.setProductName(productName);
		
	}

	public Product(Long id, String productName) {
		this.setId(id);
		this.setProductName(productName);
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
		return "id:" + productId + " Item:" + productName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		if (getProductName() == null) {
			if (other.getProductName() != null)
				return false;
		} else if (!getProductName().equals(other.getProductName()))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		/*
		 * if (surname == null) { if (other.surname != null) return false; } else if
		 * (!surname.equals(other.surname)) return false;
		 */
		return true;
	}

}
