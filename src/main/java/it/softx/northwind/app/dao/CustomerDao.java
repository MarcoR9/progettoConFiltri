package it.softx.northwind.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.softx.northwind.app.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long> {

	List<Customer> findByEmailAddress(String emailAddress);
	
//	@Modifying
//	@Query(nativeQuery =true, value ="insert into northwind.customers(last_name,first_name,email_address) values(?1,?2,?3)")
//	Customer createCustomer(String lastName, String firstName, Long emailAddress);
}
