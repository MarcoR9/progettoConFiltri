package it.softx.northwind.app.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.softx.northwind.model.service.OrderService;
import it.softx.northwind.model.service.PurchaseOrderService;
import it.softx.northwind.model.utils.PdfGeneratorService;

// method= RequestMothod.GET,
@Controller
public class PdfController {
	
	@Autowired
	private OrderService ordService;
	@Autowired
	private PurchaseOrderService poService;

	@GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> pdfOrdine (@RequestParam("i")Long orderId, @RequestParam("d")Long poId) {
		ByteArrayInputStream b = PdfGeneratorService.citiesReport(ordService.readOrderById(orderId), poService.readPurchaseOrderById(poId));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename= prova.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(b));
	}
}
