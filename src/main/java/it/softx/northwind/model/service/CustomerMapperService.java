package it.softx.northwind.model.service;

import java.util.List;

import org.springframework.lang.NonNull;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerResourceDto;


public interface CustomerMapperService {

	List<CustomerResourceDto> mapToResourceList(@NonNull List<Customer> custList);

	CustomerResourceDto mapToResource(Customer cust);

	
}