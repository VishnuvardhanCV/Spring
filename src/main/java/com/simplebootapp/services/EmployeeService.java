package com.simplebootapp.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;

@Component
public interface EmployeeService {
	
	public List<EmployeeModel> getEmployees() throws DatabaseException;
	
	public boolean addEmployee(EmployeeModel newEmployee) throws DatabaseException;
	
	public boolean	removeEmployee(String id) throws  DatabaseException;

}
