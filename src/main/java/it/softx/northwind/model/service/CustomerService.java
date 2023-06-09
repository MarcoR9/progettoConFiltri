package it.softx.northwind.model.service;

import java.util.List;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerRegisterDto;

public interface CustomerService {

	Customer readById(Long id);

	List<Customer> readCustomerByEmail(String email);

	Customer createCustomer(CustomerRegisterDto dto);

}
