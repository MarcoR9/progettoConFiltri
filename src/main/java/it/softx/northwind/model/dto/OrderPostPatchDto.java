package it.softx.northwind.model.dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderPostPatchDto {

	private String address;
	private String username;
	private String shipAdress;
	private BigDecimal payment;
//	private PurchaseOrderResourceDto purchaseOrder;
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

//	public PurchaseOrderResourceDto getPurchaseOrder() {
//		return purchaseOrder;
//	}
//
//	public void setPurchaseOrder(PurchaseOrderResourceDto purchaseOrder) {
//		this.purchaseOrder = purchaseOrder;
//	}

	public List<OrderDetailPostPatchDto> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailPostPatchDto> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getShipAdress() {
		return shipAdress;
	}

	public void setShipAdress(String shipAdress) {
		this.shipAdress = shipAdress;
	}

}
