package it.softx.northwind.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.softx.northwind.app.dao.CustomerDao;
import it.softx.northwind.app.dao.UserDao;
import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerRegisterDto;
import it.softx.northwind.model.service.CustomerMapperService;
import it.softx.northwind.model.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private CustomerMapperService cusMap;

	
	@Override
	public List<Customer> readCustomerByEmail(String email){
		return customerDao.findByEmailAddress(email);
	}

	@Override
	public Customer readById(Long id) {
		return customerDao.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public Customer createCustomer(CustomerRegisterDto dto) {
		
		Customer customer = customerDao.save(cusMap.mapToEntity(dto));
		userDao.createUser(dto.getEmailAddress(), dto.getPassword(), customer.getId());
		return customer;
	}

}
