package com.simplebootapp.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.simplebootapp.Models.EmployeeModel;

@Component
public interface EmployeeService {
	
	public List<EmployeeModel> getEmployees() throws InterruptedException, ExecutionException;
	
	public boolean addEmployee(EmployeeModel newEmployee);
	
	public boolean	removeEmployee(String id) throws InterruptedException, ExecutionException;

}
