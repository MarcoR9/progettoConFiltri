package it.softx.northwind.model.service;

import it.softx.northwind.app.entity.PurchaseOrder;

public interface PurchaseOrderService {

	PurchaseOrder readPurchaseOrderById(Long id);

}