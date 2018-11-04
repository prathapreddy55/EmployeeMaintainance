package com.pt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Table(name="EMPLOYEE")
@Entity
public class Employee {

	private int e_no;
	private String e_name;
	private long e_pn;
	private float salary;
		
	@Id
	@Column(name="ENO")
	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	@Column(name="ENAME")
	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
		@Column(name="EPN")
		@Type(type="long")
	public long getE_pn() {
		return e_pn;
	}

	public void setE_pn(long e_pn) {
		this.e_pn = e_pn;
	}

	@Column(name="SALARY")
	@Type(type="float")
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
