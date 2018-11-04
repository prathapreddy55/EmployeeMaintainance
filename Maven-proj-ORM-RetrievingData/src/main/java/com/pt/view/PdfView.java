package com.pt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.pt.dto.EmployeeDTO;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pdf, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		List<EmployeeDTO> listdto = null;
		Paragraph paragraph = null;
		Table table = null;
		listdto = (List<EmployeeDTO>) map.get("pdflist");
		paragraph = new Paragraph("listemp", new Font(Font.BOLD));
		doc.add(paragraph);
		table = new Table(4, 2);
		for (EmployeeDTO dto : listdto) {
			table.addCell(String.valueOf(dto.getE_no()));
			table.addCell(dto.getE_name());
			table.addCell(String.valueOf(dto.getE_pn()));
			table.addCell(String.valueOf(dto.getSalary()));
		}
			doc.add(table);
	}

}
