package it.softx.northwind.app.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.dao.ProductDao;
import it.softx.northwind.app.entity.Product;
import it.softx.northwind.model.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> readAll(){
		return productDao.findAll();
	}
	@Override
	public List<Product> readAllAsc(){
		return productDao.findAllByOrderByListPriceAsc();
	}
	@Override
	public List<Product> readAllDesc(){
		return productDao.findAllByOrderByListPriceDesc();
	}
	@Override
	public Product readById(Long id){
		return productDao.findById(id).orElse(null);
	}
	@Override
	public List<Product> readByCategory(String category){
		return productDao.findByCategory(category);
	}
	@Override
	public List<Product> readByCatAndName(String category, String name){
		return productDao.findByCategoryAndProductNameContaining(category, name);
	}
	@Override
	public List<Product> readByCatAndNameAsc(String category, String name){
		return productDao.findByCategoryAndProductNameContainingOrderByListPriceAsc(category, name);
	}
	@Override
	public List<Product> readByCatAndNameDesc(String category, String name){
		return productDao.findByCategoryAndProductNameContainingOrderByListPriceDesc(category, name);
	}
	
	@Override
	public List<Product> readByName(String name){
		return productDao.findByProductNameContaining(name);
	}

	@Override
	public List<Product> readByCategoryAsc(String category){
		return productDao.findByCategoryOrderByListPriceAsc(category);
	}
	@Override
	public List<Product> readByCategoryDesc(String category){
		return productDao.findByCategoryOrderByListPriceDesc(category);
	}
	@Override
	public List<Product> readByDescription(String description){
		return productDao.findByDescriptionContaining(description);
	}
	@Override
	public List<Product> readByCatAndPrice(String category,BigDecimal minPrice, BigDecimal maxPrice){
		return productDao.findByCategoryAndListPriceGreaterThanAndListPriceLessThan(category,minPrice, maxPrice);
	}

	
	@Override
	public List<String> getCategories(){
		return productDao.findDistinctByCategory();
	}
	
}
