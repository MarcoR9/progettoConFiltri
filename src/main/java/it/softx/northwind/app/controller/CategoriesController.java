package it.softx.northwind.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.dto.CategoryResourceDto;
import it.softx.northwind.model.service.CategoriesMapperService;
import it.softx.northwind.model.service.ProductService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins="*")
public class CategoriesController {

	@Autowired
	private ProductService prodService;
	
	@Autowired
	private CategoriesMapperService categoriesMapperService;
	
//	@GetMapping
//	public  HashSet<String> getAllCategories(){
//		return prodService.getCategories();
//	}
	
	@GetMapping
	public RepresentationModel<?> getAllCategories(){
		List<String> list = prodService.getCategories();
		List<CategoryResourceDto> dtos = categoriesMapperService.mapToDtoList(list);
		return RepresentationModel.of(dtos).add(linkTo(CategoriesController.class).withSelfRel());
	}
	
}
