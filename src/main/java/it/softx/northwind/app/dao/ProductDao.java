package it.softx.northwind.app.dao;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.softx.northwind.app.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	@Query("SELECT DISTINCT p.category FROM Product p")
	List<String> findDistinctByCategory();

	List<Product> findByProductName(String productName);
	List<Product> findByCategory(String category);
	List<Product> findByDescriptionContaining(String description);
 	List<Product> findByCategoryOrderByListPriceAsc(String category);
    List<Product> findByCategoryOrderByListPriceDesc(String category);
    List<Product> findByCategoryAndListPriceLessThan(String category, BigDecimal listPrice);
    
}
