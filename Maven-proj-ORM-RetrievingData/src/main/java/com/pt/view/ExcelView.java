
package com.pt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.pt.dto.EmployeeDTO;

public class ExcelView extends AbstractExcelView {
	int count=1;
	
	@Override
	public void buildExcelDocument(Map<String, Object> map, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		@SuppressWarnings("unchecked")
		List<EmployeeDTO> listdto=(List<EmployeeDTO>) map.get("Excellist");
		HSSFSheet sheet=book.createSheet("sheet1");
			System.out.println(listdto.get(0));
			getCell(sheet, 0, 0).setCellValue(new HSSFRichTextString("EMPLOYEE DETAILS"));
			getCell(sheet, 1, 0).setCellValue(new HSSFRichTextString(" NO"));
			getCell(sheet, 1, 1).setCellValue(new HSSFRichTextString(" Name"));
			getCell(sheet, 1, 2).setCellValue(new HSSFRichTextString("EMP PN"));
			getCell(sheet, 1, 3).setCellValue(new HSSFRichTextString("SALARY"));
			listdto.forEach(emp->{
					count++;
				getCell(sheet, count, 0).setCellValue(new HSSFRichTextString(emp.getE_no()+""));
				getCell(sheet, count, 1).setCellValue(new HSSFRichTextString(emp.getE_name()+""));
				getCell(sheet, count, 2).setCellValue(new HSSFRichTextString(emp.getE_pn()+""));
				getCell(sheet, count, 3).setCellValue(new HSSFRichTextString(emp.getSalary()+""));
			});
	}

	
	
}
