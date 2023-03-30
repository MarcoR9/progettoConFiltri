package it.softx.northwind.model.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfGeneratorService {

//	String username, String adress,
//	List<OrderDetailPostPatchDto> orderDetails, double prezzo
	public static ByteArrayInputStream citiesReport() {
		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(3);

			table.setWidthPercentage(70);

			table.setWidths(new int[] { 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;

			hcell = new PdfPCell(new Phrase("Username", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Adress", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Prezzo totale", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			PdfPCell cell;

			cell = new PdfPCell(new Phrase("ciao"));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(cell);

			cell = new PdfPCell(new Phrase("ciao"));

			cell.setPaddingLeft(5);

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(cell);

			cell = new PdfPCell(new Phrase("vvfv0"));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

			cell.setPaddingRight(5);

			table.addCell(cell);
			// ---------FINE PRIMA TABELLA-----------------

			PdfPTable tableProdotti = new PdfPTable(3);

			tableProdotti.setWidthPercentage(90);

			tableProdotti.setWidths(new int[] { 3, 3, 3 });
			// da mettere tutte le vaire colonne dei campi

			/*
			 * for (OrderDetailPostPatchDto dto : orderDetails) {
			 * 
			 * 
			 * }
			 */

			PdfWriter.getInstance(document, out);

			document.open();

			document.add(table);

			document.close();

		} catch (DocumentException ex) {

			System.out.println("NO");

		}

		return new ByteArrayInputStream(out.toByteArray());

	}

}
