package com.simplebootapp.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplebootapp.DAO.EmployeeDAO;
import com.simplebootapp.Entity.EmployeeModel;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO; 
	

	@Override
	public List<EmployeeModel> getEmployees() throws InterruptedException, ExecutionException {
		
		return employeeDAO.getEmployees();
	}

	@Override
	public boolean addEmployee(EmployeeModel newEmployee) {
		return employeeDAO.addEmployee(newEmployee);
	}

	@Override
	public boolean removeEmployee(String employeeId) throws InterruptedException, ExecutionException {
		return employeeDAO.removeEmployee(employeeId);
	}

}
