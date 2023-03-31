package it.softx.northwind.app.dao;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.softx.northwind.app.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	@Query("SELECT DISTINCT p.category FROM Product p")
	List<String> findDistinctByCategory();
	Product findFirstByOrderByListPriceDesc();
	List<Product> findAllByListPriceGreaterThanAndListPriceLessThan(BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findAllByListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findAllByListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findByProductNameContainingAndListPriceGreaterThanAndListPriceLessThan(String productName,BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThan(String category, String productName,BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(String category, String productName,BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(String category, String productName,BigDecimal minListPrice, BigDecimal maxListPrice);
	List<Product> findByDescriptionContaining(String description);
 	List<Product> findByCategoryAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(String category,BigDecimal minListPrice, BigDecimal maxListPrice);
    List<Product> findByCategoryAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(String category,BigDecimal minListPrice, BigDecimal maxListPrice);
    List<Product> findByCategoryAndListPriceGreaterThanAndListPriceLessThan(String category,BigDecimal minListPrice, BigDecimal maxListPrice);	    
}
