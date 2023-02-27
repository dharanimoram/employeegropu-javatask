package com.telus.employeesGroup.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.telus.employeesGroup.model.Employee;
import com.telus.employeesGroup.repository.EmployeeRepository;
import com.telus.employeesGroup.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository  employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee save(Employee employee) {
		
		Employee emp = employeeRepository.save(employee);
		return emp;
	}
	

	@Override
	public  List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}
	@Override
	public List<Employee> getFilteredEmployees(
	        @RequestParam( required = false) String married,
	        @RequestParam( required = false) Integer salary)
	    {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl(employeeRepository);
	    List<Employee> employees =employeeService.getAllEmployees();
	        List<Employee> filteredEmployees = new ArrayList<>();
	        
	        if(married == null && salary == 0) {
		        for (Employee e : employees) {
		        	if((e.getMaritalStatus().equals("married") &&(e.getSalary()<=50000))){
		        		filteredEmployees.add(e);
		        	}
		        }	
		            
		    }
	        else if(married ==  null && salary!=0) {
	        	for (Employee e : employees) {
		        	if((e.getSalary()<=50000)){
		        		filteredEmployees.add(e);
		        	}
		        }	
	        }
	        else if(married !=null && salary !=0) {
	        	for (Employee e : employees) {
		        	if((e.getMaritalStatus().equals("married") && e.getSalary()<=50000)){
		        		filteredEmployees.add(e);
		        	}
		        }	
	        	
	        }else if(married !=null && salary !=0) {
	        	for (Employee e : employees) {
		        	if((e.getMaritalStatus().equals("unmarried") && e.getSalary() > 0)){
		        		filteredEmployees.add(e);
		        	}
		        }
	        	
	        }
	        
	        else if(married!=null && salary == 0) {
	        	for (Employee e : employees) {
		        	if((e.getMaritalStatus().equals("married") )){
		        		filteredEmployees.add(e);
		        	}
	        }
	        

	      
	    }  return filteredEmployees;
	    }

	
}

