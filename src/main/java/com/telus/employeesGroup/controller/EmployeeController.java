package com.telus.employeesGroup.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.employeesGroup.json.pojo.Employees;
import com.telus.employeesGroup.model.Employee;
import com.telus.employeesGroup.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	private String staticDataString;

	@GetMapping("/read")
	public ResponseEntity<Map<String, Object>> getRadarData() throws IOException {
		ClassPathResource staticDataResource = new ClassPathResource("employeeDetails.json");

		String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
		
		ResponseEntity rt = new ResponseEntity(staticDataString, HttpStatus.OK);
		
		return rt;
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Map<String, Object>> save() throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapperE = new ObjectMapper();
		Employees employees = mapperE.readValue(staticDataString, Employees.class);
		
		List<com.telus.employeesGroup.model.Employee> saveEmpList = new ArrayList<com.telus.employeesGroup.model.Employee>();
		
		List<Employee> empllist = employees.getEmployee();
		for(Employee e : empllist) {
			com.telus.employeesGroup.model.Employee ee = com.telus.employeesGroup.model.Employee.builder().marritalStatus(e.getMaritalStatus())
					.firstName(e.getFirstName()).lastName(e.getLastName()).email(e.getEmail()).salary(e.getSalary()).id(e.getId()).build();
			com.telus.employeesGroup.model.Employee savedE =   employeeService.save(ee);
			saveEmpList.add(savedE);
		}
		
		ResponseEntity rt = new ResponseEntity(saveEmpList, HttpStatus.OK);
		return rt;
	}
	@GetMapping("/allEmp")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
	}
	@GetMapping()
	@RequestMapping("/filter")
	 public  ResponseEntity<List<Employee>> getfilteredEmployees(String marrital, Integer salary){
		  
  return new ResponseEntity<List<Employee>>(employeeService.getFilteredEmployees(marrital,salary),HttpStatus.OK);
		    }
	
}
