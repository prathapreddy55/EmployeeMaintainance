package com.pt.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

	private int e_no;
	private String e_name;
	private long e_pn;
	private float salary;

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public long getE_pn() {
		return e_pn;
	}

	public void setE_pn(long e_pn) {
		this.e_pn = e_pn;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
