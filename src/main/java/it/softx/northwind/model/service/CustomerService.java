package it.softx.northwind.model.service;

import java.util.List;

import it.softx.northwind.app.entity.Customer;

public interface CustomerService {

	Customer readById(Long id);

//	List<Customer> readCustomerAll();

	List<Customer> readCustomerByEmail(String email);

}
