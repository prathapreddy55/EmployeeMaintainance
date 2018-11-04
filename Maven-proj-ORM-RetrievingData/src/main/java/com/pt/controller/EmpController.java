package com.pt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.pt.dto.EmployeeDTO;
import com.pt.log4j.utils.UserLogs;
import com.pt.service.EmployeeService;
import com.pt.view.ExcelView;
import com.pt.view.PdfView;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService service;

	@RequestMapping("/home.htm")
	public String HomeProcess() throws Exception {
		UserLogs.logger.debug("RequestMapping-Enters Into Controller-Log4J At Home Page");
		// System.out.println("Home");
		return "home";
	}

	@RequestMapping("/emp.htm")
	public String EmpProcess(Map<String, Object> map) throws Exception {
		UserLogs.logger.debug("RequestMapping-Enters Into Controller-Log4J At ListOf Emp Page");
		final List<EmployeeDTO> listemp;
		listemp = service.GetEmpSerData();
		map.put("listdto", listemp);
		return "emp";
	}

	@RequestMapping("/emps.htm")
	public ModelAndView GetXLandPdf(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<EmployeeDTO> listemp = service.GetEmpSerData();
		return new ModelAndView(new PdfView(), "pdflist", listemp);
	}

	@RequestMapping("/empxcel.htm")
	public ModelAndView GetXL(HttpServletRequest req, HttpServletResponse res) throws Exception {

		List<EmployeeDTO> listemp = service.GetEmpSerData();
		return new ModelAndView(new ExcelView(), "Excellist", listemp);
	}

	@RequestMapping("/emp/{eno}/.htm")
	public ModelAndView EditProcess(@PathVariable("eno") int eno, @ModelAttribute("dto") EmployeeDTO dto)
			throws Exception {
		EmployeeDTO dto1 = null;
		dto1 = service.GetEmpData(eno);
		return new ModelAndView("edit", "dto", dto1);
	}

	@RequestMapping("/emp/{eno}/save.htm")
	public ModelAndView SaveProcess(@PathVariable("eno") int eno, @ModelAttribute("dto") EmployeeDTO dt)
			throws Exception {
		System.out.println("---------------------");
		System.out.println(eno);
		dt.setE_no(eno);
		int info = 0;
		String obtained;
		info = service.SaveEmployeeData(dt);
		if (info == 0) {
			obtained = "Sorry Internal Problem ";
		} else {
			obtained = "Profile Have Been Updated";
		}

		return new ModelAndView("save", "status", obtained);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public String UnHandledException() {
		return "UnknownException";
	}

}
