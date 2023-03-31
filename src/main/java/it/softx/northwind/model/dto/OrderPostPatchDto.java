package it.softx.northwind.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderPostPatchDto {

	private String address;
	private String username;
	private BigDecimal payment;
	private List<OrderDetailPostPatchDto> orderDetails;

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsernama(String username) {
		this.username = username;
	}

	public List<OrderDetailPostPatchDto> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailPostPatchDto> orderDetails) {
		this.orderDetails = orderDetails;
	}

}
