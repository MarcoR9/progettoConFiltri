package it.softx.northwind.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import it.softx.northwind.model.dto.CategoryResourceDto;

public class CategoryResourceModelAssembler implements SimpleRepresentationModelAssembler<CategoryResourceDto> {
	@Override
	public void addLinks(EntityModel<CategoryResourceDto> resource) {
		resource.add(linkTo(
				methodOn(ProductsController.class).getByCategoryAndPriceAscOrDesc(resource.getContent().getName(), 0))
				.withRel("products"));
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<CategoryResourceDto>> resources) {
		resources.add(linkTo(CategoriesController.class).withSelfRel());
	}
}