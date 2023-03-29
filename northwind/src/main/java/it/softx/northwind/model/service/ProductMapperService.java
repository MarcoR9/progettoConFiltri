package it.softx.northwind.model.service;

import java.util.List;

import org.springframework.lang.NonNull;

import it.softx.northwind.app.entity.Product;
import it.softx.northwind.model.dto.ProductResourceDto;

public interface ProductMapperService {

	List<ProductResourceDto> mapToResourceList(@NonNull List<Product> prodList);

	ProductResourceDto mapToResource(Product prod);

}