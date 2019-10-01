package com.simplebootapp.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.simplebootapp.Models.EmployeeModel;
import com.simplebootapp.exceptions.DatabaseException;
import com.simplebootapp.exceptions.EmployeeNotFoundException;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private Firestore db = new EmployeeDAOUtil().getRepo();

	@Override
	public List<EmployeeModel> getEmployees() throws DatabaseException {
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();
		try {
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
		} catch (Exception e) {
			throw new DatabaseException();
		}

		return employees;
	}

	@Override
	public boolean addEmployee(EmployeeModel newEmployee) throws DatabaseException {
		Map<String, Object> data = new HashMap<>();
		data.put("Id", String.valueOf(newEmployee.getId()));
		data.put("Name", newEmployee.getName());
		data.put("Address", newEmployee.getAddress());
		data.put("Department", newEmployee.getDepartment());
		data.put("Salary", newEmployee.getSalary());
		boolean isAdded = false;
		try {
			DocumentReference docRef = db.collection("Employees").document(String.valueOf(newEmployee.getId()));
			docRef.set(data);
			isAdded = true;
		} catch (Exception e) {
			throw new DatabaseException();
		}
		return isAdded;
	}

	@Override
	public boolean removeEmployee(String employeeId) throws DatabaseException {
		boolean isDeleted = false;
		try {
			DocumentReference docRef = db.collection("Employees").document(String.valueOf(employeeId));
			boolean isExists;
			isExists = docRef.get().get().exists();
			if (!isExists) {
				throw new EmployeeNotFoundException(employeeId);
			}

			docRef.delete();
			isDeleted = true;
		} catch (InterruptedException | ExecutionException e) {
			throw new DatabaseException();
		}

		return isDeleted;
	}

}
