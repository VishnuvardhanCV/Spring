package com.simplebootapp.DAO;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;

import com.simplebootapp.Entity.EmployeeModel;

@Component
public interface EmployeeDAO {
	
	public List<EmployeeModel> getEmployees() throws InterruptedException, ExecutionException;
	
	public boolean addEmployee(EmployeeModel newEmployee);
	
	public boolean	removeEmployee(String id) throws InterruptedException, ExecutionException;

}
