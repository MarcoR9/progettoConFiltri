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

	List<Product> readAll(BigDecimal minPrice, BigDecimal maxPrice);

	List<Product> readByCatAndPrice(String category,BigDecimal minPrice, BigDecimal maxPrice);

	List<Product> readByCatAndName(String category, String name);

	List<Product> readByCatAndNameDesc(String category, String name);

	List<Product> readByCatAndNameAsc(String category, String name);

	Product readById(Long id);

	List<Product> readAllAsc();

	List<Product> readAllDesc();

	List<Product> readByName(String name, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCategoryAsc(String category, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCatAndNameDesc(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCatAndNameAsc(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCategory(String category, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readAllDesc(BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCatAndName(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readAllAsc(BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByCategoryDesc(String category, BigDecimal minListPrice, BigDecimal maxListPrice);

	BigDecimal readMaxPrice();

	List<Product> readAll();

	List<Product> readByNameDesc(String name, BigDecimal minListPrice, BigDecimal maxListPrice);

	List<Product> readByNameAsc(String name, BigDecimal minListPrice, BigDecimal maxListPrice);

}