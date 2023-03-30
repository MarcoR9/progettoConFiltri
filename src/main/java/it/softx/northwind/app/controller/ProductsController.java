package it.softx.northwind.app.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.dto.ProductResourceDto;
import it.softx.northwind.model.service.ProductMapperService;
import it.softx.northwind.model.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductsController {

	@Autowired
	private ProductService prodService;
	@Autowired
	private ProductMapperService prodMap;
	
	private ProductResourceModelAssembler productResourceModelAssembler = new ProductResourceModelAssembler();

	@GetMapping
	public ResponseEntity<CollectionModel<EntityModel<ProductResourceDto>>> getAll(@RequestParam(name = "c", required = false) String c,
			@RequestParam(name = "n", required = false) String n, @RequestParam(name = "p", required = false) Integer p,
			@RequestParam(name = "s", required = false) Integer s,
			@RequestParam(name = "m", required = false) BigDecimal minPrice,
			@RequestParam(name = "x", required = false) BigDecimal maxPrice,
			@RequestParam(name = "d", required = false) String d) {
		if (!StringUtils.hasText(c)) {
			if (StringUtils.hasText(n)) {
				return mapToCollectionModel(getByName(n), linkTo(methodOn(ProductsController.class).getByName(n)).withSelfRel());
			}
			if (StringUtils.hasText(d)) {
				return mapToCollectionModel(getByDescriptionContaining(d), linkTo(methodOn(ProductsController.class).getByDescriptionContaining(d)).withSelfRel());
			}
			// devo necessariamente gocciolare
		}
		if (StringUtils.hasText(c) && minPrice != null && maxPrice != null) {
			return mapToCollectionModel(getByCategoryAndMaxPrice(c, minPrice, maxPrice), linkTo(methodOn(ProductsController.class).getByCategoryAndMaxPrice(c, minPrice, maxPrice)).withSelfRel());
		}
		if (StringUtils.hasText(c) && StringUtils.hasText(n) && s != null) {
			return mapToCollectionModel(getByCatAndName(c, n, s), linkTo(methodOn(ProductsController.class).getByCatAndName(c, n, s)).withSelfRel());
		}
		if (StringUtils.hasText(c) && p != null) {
			return mapToCollectionModel(getByCategoryAndPriceAscOrDesc(c, p), linkTo(methodOn(ProductsController.class).getByCategoryAndPriceAscOrDesc(c, p)).withSelfRel());
		}
		if (StringUtils.hasText(c) || StringUtils.hasText(n) || minPrice != null || maxPrice != null
				|| StringUtils.hasText(d) || p != null || s != null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(productResourceModelAssembler.toCollectionModel(getAll()).add(linkTo(ProductsController.class).withSelfRel()));
	}

	private ResponseEntity<CollectionModel<EntityModel<ProductResourceDto>>> mapToCollectionModel(
			ResponseEntity<Object> r, Link args) {
		@SuppressWarnings("unchecked")
		List<ProductResourceDto> list = (List<ProductResourceDto>) r.getBody();
		if (list != null) {
			return ResponseEntity.status(r.getStatusCode()).body(productResourceModelAssembler.toCollectionModel(list).add(args));
		} else {
			return ResponseEntity.status(r.getStatusCode()).build();
		}
	}
	
	List<ProductResourceDto> getAll() {
		return prodMap.mapToResourceList(prodService.readAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getById(@PathVariable(name = "id") Long id){
		   
			ProductResourceDto dto= prodMap.mapToResource(prodService.readById(id));
			if(null==dto) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(dto);
		
	}
	//DAL FRONTEND VOGLIO: (-LA CATEGORIA) e (-0 se senza filtro per prezzo, 1 se prezzo crescente, 2 se prezzo decrescente)
	public ResponseEntity<Object> getByCategoryAndPriceAscOrDesc(@RequestParam(name = "c") String c,
			@RequestParam(name = "p") int p) {
		switch (p) {
		case 0:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategory(c)));
		case 1:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategoryAsc(c)));
		case 2:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategoryDesc(c)));
		default: return ResponseEntity.badRequest().build();
		}
	}
	ResponseEntity<Object> getByCatAndName(@RequestParam(name = "c") String c,
			@RequestParam(name = "n") String n, @RequestParam(name = "s") int s) {
		switch (s) {
		case 0:
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndName(c, n)));
		case 1:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndNameAsc(c, n)));
		case 2:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndNameDesc(c, n)));
		default: return ResponseEntity.badRequest().build();
		}
	}
	ResponseEntity<Object> getByCategoryAndMaxPrice(@RequestParam(name = "c") String c,
			@RequestParam(name = "m") BigDecimal minPrice, @RequestParam(name = "x") BigDecimal maxPrice) {
		
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndPrice(c, minPrice, maxPrice)));
		
	}
	//cerca prodotti per parte nome prodotto DAL FRONTEND VOGLIO ( n => il nome)
	ResponseEntity<Object> getByName(@RequestParam(name = "n") String n) {
		if(StringUtils.hasText(n)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByName(n)));
		}
		return ResponseEntity.badRequest().build();
	}
	//cerca prodotti per parte di descrizione. DAL FRONTEND VOGLIO (d => parte di descrizione)
	ResponseEntity<Object> getByDescriptionContaining(@RequestParam(name = "d") String d) {
		if(StringUtils.hasText(d)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByDescription(d)));
		}
		return ResponseEntity.badRequest().build();
	}

}
