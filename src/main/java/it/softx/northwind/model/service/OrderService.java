package it.softx.northwind.model.service;

import it.softx.northwind.app.entity.Order;
import it.softx.northwind.model.dto.OrderPostPatchDto;

public interface OrderService {

	void createOrder(OrderPostPatchDto o);

	Order readOrderById(Long id);

}