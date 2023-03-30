package it.softx.northwind.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerPostPatchDto;
import it.softx.northwind.model.service.CustomerMapperService;
import it.softx.northwind.model.service.CustomerService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="*")
public class LoginController {

	@Autowired
	private CustomerMapperService cusMap;
	@Autowired
	private CustomerService cusService;
	
	@PostMapping
	public ResponseEntity<Object> postCustomer(@RequestBody CustomerPostPatchDto customer){
				
		List<Customer> customerList= cusService.readCustomerByEmail(customer.getEmail());
		if (customerList.isEmpty()) 
			return ResponseEntity.notFound().build();
		for (Customer c : customerList) {
			return  ResponseEntity.ok(cusMap.mapToResource(c));
		}
		return ResponseEntity.badRequest().build();
	}
}
