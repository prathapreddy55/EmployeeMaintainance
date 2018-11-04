package com.pt.dao;

import java.util.List;

import com.pt.domain.Employee;

public interface EmployeeDAO {

	public List<Employee> GetAllUSers();
	public Employee GetEmployeeData(int eno);
	public int Save(Employee emp);
}
