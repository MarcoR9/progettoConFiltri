package it.softx.northwind.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.dto.OrderPostPatchDto;
import it.softx.northwind.model.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@PostMapping
	public ResponseEntity<Object> postOrder(@RequestBody OrderPostPatchDto order) {
		orderService.createOrder(order);
		return ResponseEntity.ok().build();
	}
}
