package it.softx.northwind.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.softx.northwind.app.entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	
	@Query(nativeQuery =true, value ="SELECT * FROM northwind.users u WHERE u.username=?1 AND u.password=sha1(?2)")
	Optional<User> findByUsernamePassword(String username, String password);
}
