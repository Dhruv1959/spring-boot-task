package com.crud.task.dto;

public class InventoryDTO {

	private Long id;
	private String productName;
	private String description;
	private String category;
	private int quantity;
	private double unitPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public InventoryDTO(Long id, String productName, String description, String category, int quantity,
			double unitPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.category = category;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

}
