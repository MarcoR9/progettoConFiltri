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
	public BigDecimal readMaxPrice() {
		return productDao.findFirstByOrderByListPriceDesc().getListPrice();
	}
	@Override
	public List<Product> readAll(BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findAllByListPriceGreaterThanAndListPriceLessThan(minListPrice, maxListPrice);
	}
	@Override
	public List<Product> readAllAsc(BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findAllByListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(minListPrice, maxListPrice);
	}
	@Override
	public List<Product> readAllDesc(BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findAllByListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(minListPrice,maxListPrice);
	}
	@Override
	public Product readById(Long id){
		return productDao.findById(id).orElse(null);
	}
	@Override
	public List<Product> readByCategory(String category, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndListPriceGreaterThanAndListPriceLessThan(category, minListPrice,  maxListPrice);
	}
	@Override
	public List<Product> readByCatAndName(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThan(category, name, minListPrice,  maxListPrice);
	}
	@Override
	public List<Product> readByCatAndNameAsc(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(category, name, minListPrice,  maxListPrice);
	}
	@Override
	public List<Product> readByCatAndNameDesc(String category, String name, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndProductNameContainingAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(category, name, minListPrice,  maxListPrice);
	}
	
	@Override
	public List<Product> readByName(String name, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByProductNameContainingAndListPriceGreaterThanAndListPriceLessThan(name, minListPrice,  maxListPrice);
	}

	@Override
	public List<Product> readByCategoryAsc(String category, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceAsc(category, minListPrice,  maxListPrice);
	}
	@Override
	public List<Product> readByCategoryDesc(String category, BigDecimal minListPrice, BigDecimal maxListPrice){
		return productDao.findByCategoryAndListPriceGreaterThanAndListPriceLessThanOrderByListPriceDesc(category, minListPrice,  maxListPrice);
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
	@Override
	public List<Product> readByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCategoryAsc(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCategoryDesc(String category) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCatAndName(String category, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCatAndNameDesc(String category, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readByCatAndNameAsc(String category, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readAllAsc() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Product> readAllDesc() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
