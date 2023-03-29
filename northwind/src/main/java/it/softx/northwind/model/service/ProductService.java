package it.softx.northwind.model.service;

import java.util.List;

import it.softx.northwind.app.entity.Product;

public interface ProductService {

	List<Product> readByDescription(String description);

	List<Product> readByName(String name);

	List<Product> readByCategory(String category);

//	HashSet<String> getCategories();
	
	List<String> getCategories();

	List<Product> readByCategoryAsc(String category);

	List<Product> readByCategoryDesc(String category);

	List<Product> readAll();

}