package it.softx.northwind.app.serviceimpl;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import it.softx.northwind.model.dto.CategoryResourceDto;
import it.softx.northwind.model.service.CategoriesMapperService;

@Service
public class CategoriesMapperServiceImpl implements CategoriesMapperService {
	@Override
	public CategoryResourceDto mapToDto(String name) {
		if (name == null) {
			return null;
		}
		CategoryResourceDto dto = new CategoryResourceDto();
		dto.setName(name);
		return dto;
	}

	@Override
	@NonNull
	public List<CategoryResourceDto> mapToDtoList(@NonNull List<String> names) {
		return names.stream().map(this::mapToDto).toList();
	}
}
