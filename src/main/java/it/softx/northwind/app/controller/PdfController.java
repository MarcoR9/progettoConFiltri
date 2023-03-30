package it.softx.northwind.app.controller;

import java.io.ByteArrayInputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import it.softx.northwind.model.utils.PdfGeneratorService;

// method= RequestMothod.GET,
@Controller
public class PdfController {

	@RequestMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citiesReport() {
		ByteArrayInputStream b = PdfGeneratorService.citiesReport();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "inline; filename= prova.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(b));
	}
}
