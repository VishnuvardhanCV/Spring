package com.simplebootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;
import com.simplebootapp.services.EmployeeService;
@CrossOrigin(origins = "*")
@RestController
@EnableAutoConfiguration
@Validated
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path = "/getEmployees")
	public List<EmployeeModel> getEmployees() throws DatabaseException {
			return employeeService.getEmployees();
	}
	
	@RequestMapping("/addEmployee")
	public boolean addEmployee(@RequestBody EmployeeModel employee) throws DatabaseException{
			return employeeService.addEmployee(employee);
	}
	
	@RequestMapping("/removeEmployee")
	public boolean removeEmployee(@RequestParam String id) throws DatabaseException{
			return employeeService.removeEmployee(id);
	}

}
