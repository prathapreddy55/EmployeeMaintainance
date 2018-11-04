package com.pt.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.pt.dao.EmployeeDAO;
import com.pt.domain.Employee;
import com.pt.dto.EmployeeDTO;
import com.pt.service.EmployeeService;
import com.pt.service.EmployeeServiceImpl;

@Repository
public class EmployeeDAOImplMockTest {

	
	@Test
	public void test() {
		Employee emp,emp1;
		List<Employee> listemp=new ArrayList<>();
	
		emp=new Employee();
		emp.setE_no(123);
		emp.setE_name("prathap");
		emp.setE_pn(9701030843l);
		emp.setSalary(55000.0f);
		emp1=new Employee();
		emp1.setE_no(123);
		emp1.setE_name("prathap");
		emp1.setE_pn(9701030843l);
		emp1.setSalary(55000.0f);
		listemp.add(emp);listemp.add(emp1);
		List<EmployeeDTO> listdto=new ArrayList<>();
		listemp.forEach(emps->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(emps, dto);
			listdto.add(dto);
		});
		
		EmployeeDAO dao=mock(EmployeeDAO.class);
		EmployeeService service=new EmployeeServiceImpl();
		System.out.println(listdto.size());
		when(service.GetEmpSerData()).thenReturn(listdto);
		
	}

}
