package com.simplebootapp.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.EmployeeNotFoundException;

@Service
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
	private Firestore db = new EmployeeDAOUtil().getRepo();
	

	@Override
	public List<EmployeeModel> getEmployees() throws InterruptedException, ExecutionException {
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		
		ApiFuture<QuerySnapshot> query = db.collection("Employees").get();
		QuerySnapshot querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
		for (QueryDocumentSnapshot document : documents) {
		EmployeeModel emp = new EmployeeModel();
		  emp.setId(Integer.parseInt(document.getString("Id")));
		  emp.setAddress(document.getString("Address"));
		  emp.setDepartment(document.getString("Department"));
		  emp.setName(document.getString("Name"));
		  emp.setSalary(document.getDouble("Salary"));
		  employees.add(emp);
		}
		
		return employees;
	}

	@Override
	public boolean addEmployee(EmployeeModel newEmployee) {
		System.out.println("Inside");
		Map<String, Object> data = new HashMap<>();
		data.put("Id", String.valueOf(newEmployee.getId()));
		data.put("Name", newEmployee.getName());
		data.put("Address", newEmployee.getAddress());
		data.put("Department", newEmployee.getDepartment());
		data.put("Salary", newEmployee.getSalary());
		DocumentReference docRef = db.collection("Employees").document(String.valueOf(newEmployee.getId()));
		docRef.set(data);
		return true;
	}

	@Override
	public boolean removeEmployee(String employeeId) throws InterruptedException, ExecutionException {

		DocumentReference docRef = db.collection("Employees").document(String.valueOf(employeeId));
		boolean isExists= docRef.get().get().exists();
		if(!isExists)
			throw new EmployeeNotFoundException(employeeId);
		docRef.delete();
		return true;
	}

}
