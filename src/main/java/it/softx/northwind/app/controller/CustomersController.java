package it.softx.northwind.app.controller;

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
import it.softx.northwind.model.dto.CustomerRegisterDto;
import it.softx.northwind.model.dto.CustomerResourceDto;
import it.softx.northwind.model.service.CustomerMapperService;
import it.softx.northwind.model.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins="*")
public class CustomersController {

	@Autowired
	private CustomerMapperService cusMap;
	@Autowired
	private CustomerService cusService;
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResourceDto> getById(@PathVariable("id") Long id){
		Customer cus=cusService.readById(id);
		if(null==cus) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cusMap.mapToResource(cus));
	}
	
	
	@PostMapping
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerRegisterDto customer){
		if(null==customer) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(cusService.createCustomer(customer));
	}
}
