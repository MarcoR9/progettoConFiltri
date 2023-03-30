package it.softx.northwind.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softx.northwind.app.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	List<Customer> findByEmailAddress(String emailAddress);
}
