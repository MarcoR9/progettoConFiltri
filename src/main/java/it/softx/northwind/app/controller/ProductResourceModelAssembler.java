package it.softx.northwind.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;

import it.softx.northwind.model.dto.ProductResourceDto;

public class ProductResourceModelAssembler implements SimpleRepresentationModelAssembler<ProductResourceDto> {

	@Override
	public void addLinks(EntityModel<ProductResourceDto> resource) {
		resource.add(linkTo(methodOn(ProductsController.class).getById(resource.getContent().getId())).withSelfRel());
	}

	@Override
	public void addLinks(CollectionModel<EntityModel<ProductResourceDto>> resources) {
		//
	}

}
