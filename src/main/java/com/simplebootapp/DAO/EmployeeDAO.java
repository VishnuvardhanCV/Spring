package com.simplebootapp.DAO;

import java.util.List;

import org.springframework.stereotype.Component;

import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;

@Component
public interface EmployeeDAO {
	
	public List<EmployeeModel> getEmployees() throws DatabaseException;
	
	public boolean addEmployee(EmployeeModel newEmployee) throws DatabaseException;
	
	public boolean	removeEmployee(String id) throws DatabaseException;

}
