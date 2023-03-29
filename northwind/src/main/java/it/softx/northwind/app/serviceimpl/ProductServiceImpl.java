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
	public List<Product> readByCategory(String category){
		return productDao.findByCategory(category);
	}
	
	@Override
	public List<Product> readByName(String name){
		return productDao.findByProductName(name);
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
	
//	@Override
//	public HashSet<String> getCategories(){
//		List<String> categoryList=new ArrayList<>();
//		List<Product> p=productDao.findAll();
//		
//		for (Product product : p) {
//			categoryList.add(product.getCategory().toString());
//			
//		}
//		return new HashSet<String>(categoryList);
//	}
	@Override
	public List<String> getCategories(){
		return productDao.findDistinctByCategory();
	}
	
}
