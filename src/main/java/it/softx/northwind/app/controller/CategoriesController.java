package it.softx.northwind.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.service.ProductService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins="*")
public class CategoriesController {

	@Autowired
	private ProductService prodService;
	
//	@GetMapping
//	public  HashSet<String> getAllCategories(){
//		return prodService.getCategories();
//	}
	
	@GetMapping
	public  List<String> getAllCategories(){
		return prodService.getCategories();
	}
	
}
