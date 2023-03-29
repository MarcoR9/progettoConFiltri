package it.softx.northwind.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softx.northwind.app.entity.OrderStatus;

public interface OrderStatusDao extends JpaRepository<OrderStatus, Long> {

}
