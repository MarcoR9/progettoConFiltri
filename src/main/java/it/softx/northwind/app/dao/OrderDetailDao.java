package it.softx.northwind.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softx.northwind.app.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Long>{

}
