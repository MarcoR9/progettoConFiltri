package it.softx.northwind.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.entity.Customer;
import it.softx.northwind.model.dto.CustomerRegisterDto;
import it.softx.northwind.model.dto.CustomerResourceDto;
import it.softx.northwind.model.service.CustomerMapperService;


@Service
public class CustomerMapperServiceImpl implements CustomerMapperService {
	
	@Override
	public CustomerResourceDto mapToResource(Customer cust) {
		if(cust == null) {
			return null;
		}
		CustomerResourceDto dto = new CustomerResourceDto();
		dto.setId(cust.getId());
		dto.setFirstName(cust.getFirstName());
		dto.setLastName(cust.getLastName());
		dto.setEmailAddress(cust.getEmailAddress());
		
		return dto;
	}
	
	
	@Override
	@NonNull
	public List<CustomerResourceDto> mapToResourceList(@NonNull List<Customer> custList){
		List<CustomerResourceDto> cust = new ArrayList<>();
		for(Customer p : custList) {
			cust.add(mapToResource(p));
		}
	  return cust;
	}
	@Override
	public Customer mapToEntity(CustomerRegisterDto dto) {
		if(dto == null) {
			return null;
		}
		Customer customer= new Customer();
		customer.setLastName(dto.getLastName());
		customer.setFirstName(dto.getFirstName());
		customer.setEmailAddress(dto.getEmailAddress());
		return customer;
	}

}
