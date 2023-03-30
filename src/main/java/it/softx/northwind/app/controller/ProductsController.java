package it.softx.northwind.app.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public ResponseEntity<Object> getAll(@RequestParam(name = "c", required = false) String c,
			@RequestParam(name = "n", required = false) String n, @RequestParam(name = "p", required = false) Integer p,
			@RequestParam(name = "s", required = false) Integer s,
			@RequestParam(name = "m", required = false) BigDecimal minPrice,
			@RequestParam(name = "x", required = false) BigDecimal maxPrice,
			@RequestParam(name = "d", required = false) String d) {
		if (!StringUtils.hasText(c)) {
			if (StringUtils.hasText(n)) {
				return getByName(n);
			}
			if (StringUtils.hasText(d)) {
				return getByDescriptionContaining(d);
			}
			// devo necessariamente gocciolare
		}
		if (StringUtils.hasText(c) && minPrice != null && maxPrice != null) {
			return getByCategoryAndMaxPrice(c, minPrice, maxPrice);
		}
		if (StringUtils.hasText(c) && StringUtils.hasText(n) && s != null) {
			return getByCatAndName(c, n, s);
		}
		if (StringUtils.hasText(c) && p != null) {
			return getByCategoryAndPriceAscOrDesc(c, p);
		}
		if (StringUtils.hasText(c) || StringUtils.hasText(n) || minPrice != null || maxPrice != null
				|| StringUtils.hasText(d) || p != null || s != null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(getAll());
	}
	
	private List<ProductResourceDto> getAll() {
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
	private ResponseEntity<Object> getByCatAndName(@RequestParam(name = "c") String c,
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
	private ResponseEntity<Object> getByCategoryAndMaxPrice(@RequestParam(name = "c") String c,
			@RequestParam(name = "m") BigDecimal minPrice, @RequestParam(name = "x") BigDecimal maxPrice) {
		
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndPrice(c, minPrice, maxPrice)));
		
	}
	//cerca prodotti per parte nome prodotto DAL FRONTEND VOGLIO ( n => il nome)
	private ResponseEntity<Object> getByName(@RequestParam(name = "n") String n) {
		if(StringUtils.hasText(n)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByName(n)));
		}
		return ResponseEntity.badRequest().build();
	}
	//cerca prodotti per parte di descrizione. DAL FRONTEND VOGLIO (d => parte di descrizione)
	private ResponseEntity<Object> getByDescriptionContaining(@RequestParam(name = "d") String d) {
		if(StringUtils.hasText(d)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByDescription(d)));
		}
		return ResponseEntity.badRequest().build();
	}

}
