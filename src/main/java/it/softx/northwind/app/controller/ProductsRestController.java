package it.softx.northwind.app.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.softx.northwind.model.service.ProductMapperService;
import it.softx.northwind.model.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductsRestController {

	@Autowired
	private ProductService prodService;
	@Autowired
	private ProductMapperService prodMap;

	@GetMapping
	public ResponseEntity<Object> getAll(@RequestParam(name = "c", required = false) String c,
			@RequestParam(name = "n", required = false) String n, @RequestParam(name = "p", required = false) Integer p,
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
			return ResponseEntity.badRequest().build();
		}
		if (minPrice != null && maxPrice != null) {
			return getByCategoryAndMaxPrice(c, minPrice, maxPrice);
		}
		if (p == null) {
			return ResponseEntity.badRequest().build();
		}
		if (StringUtils.hasText(n)) {
			return getByCatAndName(c, n, p);
		}
		return getByCategoryAndPriceAscOrDesc(c, p);
	}

	// DAL FRONTEND VOGLIO: (-LA CATEGORIA) e (-0 se senza filtro per prezzo, 1 se
	// prezzo crescente, 2 se prezzo decrescente)
	private ResponseEntity<Object> getByCategoryAndPriceAscOrDesc(String c, int p) {
		switch (p) {
		case 0:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategory(c)));
		case 1:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategoryAsc(c)));
		case 2:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCategoryDesc(c)));
		default:
			return ResponseEntity.badRequest().build();
		}
	}

	private ResponseEntity<Object> getByCatAndName(String c, String n, int s) {
		switch (s) {
		case 0:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndName(c, n)));
		case 1:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndNameAsc(c, n)));
		case 2:
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndNameDesc(c, n)));
		default:
			return ResponseEntity.badRequest().build();
		}
	}

	private ResponseEntity<Object> getByCategoryAndMaxPrice(String c, BigDecimal minPrice, BigDecimal maxPrice) {

		return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByCatAndPrice(c, minPrice, maxPrice)));

	}

	// cerca prodotti per parte nome prodotto DAL FRONTEND VOGLIO ( n => il nome)
	private ResponseEntity<Object> getByName(String n) {
		if (StringUtils.hasText(n)) {
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByName(n)));
		}
		return ResponseEntity.badRequest().build();
	}

	// cerca prodotti per parte di descrizione. DAL FRONTEND VOGLIO (d => parte di
	// descrizione)
	private ResponseEntity<Object> getByDescriptionContaining(String d) {
		if (StringUtils.hasText(d)) {
			return ResponseEntity.ok(prodMap.mapToResourceList(prodService.readByDescription(d)));
		}
		return ResponseEntity.badRequest().build();
	}

}
