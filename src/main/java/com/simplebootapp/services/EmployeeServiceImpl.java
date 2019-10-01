package com.simplebootapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplebootapp.DAO.EmployeeDAO;
import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	

	@Override
	public List<EmployeeModel> getEmployees() throws DatabaseException {
		
		return employeeDAO.getEmployees();
	}

	@Override
	public boolean addEmployee(EmployeeModel newEmployee) throws DatabaseException {
		return employeeDAO.addEmployee(newEmployee);
	}

	@Override
	public boolean removeEmployee(String employeeId) throws DatabaseException {
		return employeeDAO.removeEmployee(employeeId);
	}

}
