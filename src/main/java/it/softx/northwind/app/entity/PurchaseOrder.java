package it.softx.northwind.app.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="purchase_orders", catalog="northwind")
@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	@Column(name="payment_amount",nullable = true)
	private BigDecimal paymentAmount;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}
	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
}
