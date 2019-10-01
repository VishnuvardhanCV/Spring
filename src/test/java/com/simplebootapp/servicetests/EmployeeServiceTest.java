package com.simplebootapp.servicetests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.simplebootapp.DAO.EmployeeDAO;
import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;
import com.simplebootapp.exceptions.EmployeeNotFoundException;
import com.simplebootapp.services.EmployeeService;
import com.simplebootapp.services.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeDAO employeeDAO;

	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();

	// getEmployees() method should success
	@Test
	public void getEmployeesShouldReturnListOfEmployees() throws DatabaseException {
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		employees.add(new EmployeeModel(3, "vishnu", "Uppal", "Java", 12345.45));
		employees.add(new EmployeeModel(4, "Ram", "Uppal", "Java", 12345.45));
		employees.add(new EmployeeModel(5, "Shyam", "Uppal", "Java", 12345.45));
		when(employeeDAO.getEmployees()).thenReturn(employees);

		assertThat(employees, is(employeeService.getEmployees()));
	}

	// getEmployees() should throw an Exception (failure case)

	@Test(expected = DatabaseException.class)
	public void getEmployeesShouldFail() throws DatabaseException {
		when(employeeDAO.getEmployees()).thenThrow(new DatabaseException());
		employeeService.getEmployees();
	}

	// addEmployees should success
	@Test
	public void addEmployeeShouldSuccess() throws DatabaseException {
		EmployeeModel employee = new EmployeeModel();
		when(employeeDAO.addEmployee(employee)).thenReturn(true);
		assertTrue(employeeService.addEmployee(employee));
	}

	//// addEmployees should fail with DatabaseException
	@Test(expected = DatabaseException.class)
	public void addEmployeeShouldFail() throws DatabaseException {
		EmployeeModel employee = new EmployeeModel();
		when(employeeDAO.addEmployee(employee)).thenThrow(new DatabaseException());
		employeeService.addEmployee(employee);
	}

	// removeEmployee should fail with DatabaseException

	@Test(expected = DatabaseException.class)
	public void removeEmployeeShouldFail() throws DatabaseException {
		when(employeeDAO.removeEmployee("5")).thenThrow(new DatabaseException());
		employeeService.removeEmployee("5");
	}

	// removeEmployee should fail when id not found

	@Test(expected = EmployeeNotFoundException.class)
	public void removeEmployeeShouldFailWithEmployeeNotFound() throws DatabaseException {
		when(employeeDAO.removeEmployee("5")).thenThrow(new EmployeeNotFoundException("5"));
		employeeService.removeEmployee("5");
	}

	// removeEmployee should success
	@Test
	public void removeEmployeeShouldSuccess() throws DatabaseException {
		when(employeeDAO.removeEmployee("5")).thenReturn(true);
		assertTrue(employeeService.removeEmployee("5"));
	}
}
