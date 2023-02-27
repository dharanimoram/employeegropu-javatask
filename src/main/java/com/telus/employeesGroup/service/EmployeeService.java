package com.telus.employeesGroup.service;

import java.util.List;

import com.telus.employeesGroup.model.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	List<Employee> getAllEmployees();
	
	List<Employee> getFilteredEmployees(String married, Integer salary);
	
}
	