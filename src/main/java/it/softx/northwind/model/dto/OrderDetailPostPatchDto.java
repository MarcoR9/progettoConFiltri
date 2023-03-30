package it.softx.northwind.model.dto;

public class OrderDetailPostPatchDto {

	private int quantity;
	private ProductPostPatchDto product;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductPostPatchDto getProduct() {
		return product;
	}
	public void setProduct(ProductPostPatchDto product) {
		this.product = product;
	}
	
	
	
}
