package com.pt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pt.dao.EmployeeDAO;
import com.pt.domain.Employee;
import com.pt.dto.EmployeeDTO;

@Service("service")
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired	
	private EmployeeDAO dao;
	
	public List<EmployeeDTO> GetEmpSerData() {
		List<Employee> listemp=null;
		List<EmployeeDTO> listdto=new ArrayList<EmployeeDTO>();
		listemp=dao.GetAllUSers();
		listemp.forEach(emp->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(emp, dto);
			listdto.add(dto);
		});
		return listdto;
	}

	@Override
	public EmployeeDTO GetEmpData(int eno) {
		Employee emp=null;
		emp=dao.GetEmployeeData(eno);
		EmployeeDTO dto=new EmployeeDTO();
		BeanUtils.copyProperties(emp, dto);
		return dto;
	}

	@Override
	@Transactional(transactionManager="txmgr",propagation=Propagation.REQUIRED,readOnly=false)
	public int SaveEmployeeData(EmployeeDTO empdto) {
		int status=0;
		Employee emp=new Employee();
		BeanUtils.copyProperties(empdto, emp);
		status=dao.Save(emp);
		return status;
	}

}
