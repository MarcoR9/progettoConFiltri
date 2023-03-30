package it.softx.northwind.model.service;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.app.entity.User;

public interface UserService {

	Customer readByUsernamePassword(String u, String p);

	User readByEmail(String email);

	void createUser(String username, String password, Long customerId);

}