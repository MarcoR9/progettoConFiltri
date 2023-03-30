package it.softx.northwind.app.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.softx.northwind.app.dao.UserDao;
import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.app.entity.User;
import it.softx.northwind.model.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public Customer readByUsernamePassword(String u, String p) {
		return userDao.findByUsernamePassword(u, p).map(User::getCustomer).orElse(null);
	}
	
	@Transactional
	public User createUser(String username, String password, Long customerId) {
		return userDao.createUser(username, password, customerId);
	}
}
