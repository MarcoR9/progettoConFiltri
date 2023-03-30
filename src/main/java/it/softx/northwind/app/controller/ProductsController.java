package it.softx.northwind.app.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.dto.ProductResourceDto;
import it.softx.northwind.model.service.ProductMapperService;
import it.softx.northwind.model.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductsController {

	@Autowired
	private ProductService prodService;
	@Autowired
	private ProductMapperService prodMap;

	@GetMapping
	public List<ProductResourceDto> getAll() {
		return prodMap.mapToResourceList(prodService.readAll());
	}

	@GetMapping("/id")
	public ResponseEntity<Object> getById(@RequestParam(name = "i") Long id){
		
			return ResponseEntity.ok(prodMap.mapToResource(prodService.readById(id)));
		
	}
	//DAL FRONTEND VOGLIO: (-LA CATEGORIA) e (-0 se senza filtro per prezzo, 1 se prezzo crescente, 2 se prezzo decrescente)
	@GetMapping("/cat")
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
	@GetMapping("/cat/name")
	public ResponseEntity<Object> getByCatAndName(@RequestParam(name = "c") String c,
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
	@GetMapping("/cat/price")
	public ResponseEntity<Object> getByCategoryAndMaxPrice(@RequestParam(name = "c") String c,
			@RequestParam(name = "m") BigDecimal minPrice, @RequestParam(name = "x") BigDecimal maxPrice) {
		
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndPrice(c, minPrice, maxPrice)));
		
	}
	//cerca prodotti per parte nome prodotto DAL FRONTEND VOGLIO ( n => il nome)
	@GetMapping("/name")
	public ResponseEntity<Object> getByName(@RequestParam(name = "n") String n) {
		if(StringUtils.hasText(n)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByName(n)));
		}
		return ResponseEntity.badRequest().build();
	}
	//cerca prodotti per parte di descrizione. DAL FRONTEND VOGLIO (d => parte di descrizione)
	@GetMapping("/des")
	public ResponseEntity<Object> getByDescriptionContaining(@RequestParam(name = "d") String d) {
		if(StringUtils.hasText(d)) {
		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByDescription(d)));
		}
		return ResponseEntity.badRequest().build();
	}

}
