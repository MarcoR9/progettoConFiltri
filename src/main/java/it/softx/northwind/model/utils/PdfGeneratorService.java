package it.softx.northwind.model.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import it.softx.northwind.app.entity.Order;
import it.softx.northwind.app.entity.PurchaseOrder;

public class PdfGeneratorService {

 
	private PdfGeneratorService() {}
	
	public static ByteArrayInputStream citiesReport(Order order, PurchaseOrder po) {
		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(4);

			table.setWidthPercentage(90);

			table.setWidths(new int[] { 3, 3, 3, 3 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;

			hcell = new PdfPCell(new Phrase("First name", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Last name", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Address", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Payment amount", headFont));

			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);

			table.addCell(hcell);

			PdfPCell cell;

			cell = new PdfPCell(new Phrase(order.getCustomer().getFirstName()));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell);

			cell = new PdfPCell(new Phrase(order.getCustomer().getLastName()));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell);

			cell = new PdfPCell(new Phrase(order.getShipAddress()));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);

			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(po.getPaymentAmount().toString()));

			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);

			cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);

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
