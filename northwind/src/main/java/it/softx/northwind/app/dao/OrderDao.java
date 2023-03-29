package it.softx.northwind.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softx.northwind.app.entity.Order;

public interface OrderDao extends JpaRepository<Order, Long>{

}
