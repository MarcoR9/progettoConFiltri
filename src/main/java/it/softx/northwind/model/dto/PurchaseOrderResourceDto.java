package it.softx.northwind.model.dto;

import java.math.BigDecimal;

public class PurchaseOrderResourceDto {

	private Long id;
	private BigDecimal amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
