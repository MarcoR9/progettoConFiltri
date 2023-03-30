package it.softx.northwind.model.service;

import java.util.List;

import it.softx.northwind.model.dto.CategoryResourceDto;

public interface CategoriesMapperService {

	CategoryResourceDto mapToDto(String name);

	List<CategoryResourceDto> mapToDtoList(List<String> names);

}