package it.softx.northwind.model.service;

import java.math.BigDecimal;
import java.util.List;

import it.softx.northwind.app.entity.Product;

public interface ProductService {

	List<Product> readByDescription(String description);

	List<Product> readByName(String name);

	List<Product> readByCategory(String category);

     
	
	List<String> getCategories();

	List<Product> readByCategoryAsc(String category);

	List<Product> readByCategoryDesc(String category);

	List<Product> readAll();

	List<Product> readByCatAndPrice(String category,BigDecimal minPrice, BigDecimal maxPrice);

	List<Product> readByCatAndName(String category, String name);

	List<Product> readByCatAndNameDesc(String category, String name);

	List<Product> readByCatAndNameAsc(String category, String name);

	Product readById(Long id);

}