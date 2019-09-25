package com.simplebootapp.Entity;

public class EmployeeModel {
	
	private int id;
	
	private String name;
	
	private String address;
	
	private String department;
	
	private Double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double double1) {
		this.salary = double1;
	}
	

	@Override
	public String toString() {
		return "EmployeeModal [id=" + id + ", name=" + name + ", address=" + address + ", department=" + department
				+ ", salary=" + salary + "]";
	}

}
