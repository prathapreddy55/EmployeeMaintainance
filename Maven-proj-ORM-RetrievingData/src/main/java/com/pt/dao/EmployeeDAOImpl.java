package com.pt.dao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.pt.domain.Employee;

@Repository("dao")
@EnableTransactionManagement
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {
		@Autowired
	private HibernateTemplate ht;
	
		private static final String HQL_GET_EMPS="from Employee";
	
	public List<Employee> GetAllUSers() {
		
		List<Employee> listemp=null;
		listemp=(List<Employee>) ht.find(HQL_GET_EMPS);
		return listemp;
	}

	@Override
	public Employee GetEmployeeData(int eno) {
			Employee emp;
			emp=ht.get(Employee.class, eno);
		return emp;
	}

	@Override
	
	public int Save(Employee emp) {
		int result=1;
		try {
			ht.setCheckWriteOperations(true);
			ht.saveOrUpdate(emp);
			//ht.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
