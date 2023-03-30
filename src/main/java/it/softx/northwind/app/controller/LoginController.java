package it.softx.northwind.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerPostPatchDto;
import it.softx.northwind.model.service.CustomerMapperService;
import it.softx.northwind.model.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="*")
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private CustomerMapperService cusMap;
	
	@PostMapping
	public ResponseEntity<Object> loginCustomer(@RequestBody CustomerPostPatchDto customer){
		if(null==customer) {
			return ResponseEntity.badRequest().build();
		}
		Customer cust= userService.readByUsernamePassword(customer.getEmail(), customer.getPassword());
		if(null!=cust) {
			return ResponseEntity.ok(cusMap.mapToResource(cust));
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("EMAIL OR PASSWORD INCORRECT");
				
	}
}
