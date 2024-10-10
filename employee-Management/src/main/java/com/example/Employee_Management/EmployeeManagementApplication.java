package com.example.Employee_Management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Employee_Management.model.Employee;
import com.example.Employee_Management.repository.EmployeeRepository;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args)throws Exception{
		
		
		
		
		
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

}
