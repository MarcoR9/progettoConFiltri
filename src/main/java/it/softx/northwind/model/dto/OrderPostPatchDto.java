package it.softx.northwind.model.dto;

import java.util.List;


public class OrderPostPatchDto {
	
	private String address;
	private CustomerPostPatchDto customer;
	
	private List<OrderDetailPostPatchDto> ord;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CustomerPostPatchDto getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerPostPatchDto customer) {
		this.customer = customer;
	}

	public List<OrderDetailPostPatchDto> getOrd() {
		return ord;
	}

	public void setOrd(List<OrderDetailPostPatchDto> ord) {
		this.ord = ord;
	}
	
	
	
	
	

}
