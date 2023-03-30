package it.softx.northwind.model.service;

import org.springframework.transaction.annotation.Transactional;


import it.softx.northwind.app.entity.Customer;

public interface UserService {

	Customer readByUsernamePassword(String u, String p);

}