package it.softx.northwind.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerPostPatchDto;
import it.softx.northwind.model.dto.CustomerResourceDto;
import it.softx.northwind.model.service.CustomerMapperService;
import it.softx.northwind.model.service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins="*")
public class CustomersController {

	@Autowired
	private CustomerMapperService cusMap;
	@Autowired
	private CustomerService cusService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResourceDto> getById(@PathVariable("id") Long id){
		Customer cus=cusService.readById(id);
		return ResponseEntity.ok(cusMap.mapToResource(cus));
	}
	
	@PostMapping
	public ResponseEntity<?> postCustomer(@RequestBody CustomerPostPatchDto customer){
				
		List<Customer> customerList= cusService.readCustomerByEmail(customer.getEmail());
		if (customerList.isEmpty()) 
			return ResponseEntity.notFound().build();
		for (Customer c : customerList) {
			return  ResponseEntity.ok(cusMap.mapToResource(c));
		}
		return ResponseEntity.badRequest().build();
	}
	
	
}
