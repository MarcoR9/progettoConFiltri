package it.softx.northwind.model.dto;


public class ProductPostPatchDto {
	
	private String category;
	private float listPrice;
	private String productName;
	private String productCode;
	private String description;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getListPrice() {
		return listPrice;
	}
	public void setListPrice(float listPrice) {
		this.listPrice = listPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
