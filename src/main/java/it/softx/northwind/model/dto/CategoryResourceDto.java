package it.softx.northwind.model.dto;

import org.springframework.hateoas.server.core.Relation;

@Relation(collectionRelation = "categories")
public class CategoryResourceDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
