package com.pt.service;

import java.util.List;

import com.pt.dto.EmployeeDTO;

public interface EmployeeService {

	public List<EmployeeDTO> GetEmpSerData();
	public EmployeeDTO GetEmpData(int eno);
	public int SaveEmployeeData(EmployeeDTO empdto);
}
