package com.telus.employeesGroup;

import java.io.InputStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.employeesGroup.model.Employee;
import com.telus.employeesGroup.service.EmployeeService;

import java.util.List;



@SpringBootApplication
public class EmployeesGroupApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesGroupApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeService employeeService){
		return args  ->  {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			TypeReference<List<Employee>> typeReference = new TypeReference<List<Employee>>() {};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/employee.json");
			try{
				List<Employee> employee = mapper.readValue(inputStream, typeReference);
				employeeService.saveEmployee((Employee) employee);
				System.out.println("Employee saved");
			}catch (Exception e) {
				System.out.println("Unable to save"+ e.getMessage());
			}

		
	};
}
}