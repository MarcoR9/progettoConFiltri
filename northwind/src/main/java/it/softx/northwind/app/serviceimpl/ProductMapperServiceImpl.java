package it.softx.northwind.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import it.softx.northwind.app.entity.Product;
import it.softx.northwind.model.dto.ProductResourceDto;
import it.softx.northwind.model.service.ProductMapperService;

@Service
public class ProductMapperServiceImpl implements ProductMapperService {
	
	@Override
	public ProductResourceDto mapToResource(Product prod) {
		if(prod == null) {
			return null;
		}
		ProductResourceDto dto = new ProductResourceDto();
		dto.setId(prod.getId());
		dto.setCategory(prod.getCategory());
		dto.setListPrice(prod.getListPrice());
		dto.setProductName(prod.getProductName());
		dto.setProductCode(prod.getProductCode());
		dto.setDescription(prod.getDescription());
		
		return dto;
	}
	
	
	@Override
	@NonNull
	public List<ProductResourceDto> mapToResourceList(@NonNull List<Product> prodList){
		List<ProductResourceDto> prod = new ArrayList<>();
		for(Product p :prodList) {
			prod.add(mapToResource(p));
		}
	  return prod;
	}
	

}
