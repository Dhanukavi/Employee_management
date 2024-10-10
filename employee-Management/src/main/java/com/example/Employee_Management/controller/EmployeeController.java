package com.example.Employee_Management.controller;

import com.example.Employee_Management.exception.ResourceNotFoundException;
import com.example.Employee_Management.model.Employee;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Employee_Management.repository.EmployeeRepository;

@CrossOrigin(origins = "https://emp1.netlify.app/")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
			return ResponseEntity.ok(employee);	
	
	}
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
		Employee updateEmployee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:"+id));
	
	updateEmployee.setFirstname(employeeDetails.getFirstname());
    updateEmployee.setLastname(employeeDetails.getLastname());
	updateEmployee.setEmailId(employeeDetails.getEmailId());
	updateEmployee.setPhoneNo(employeeDetails.getPhoneNo());
	updateEmployee.setAddress(employeeDetails.getAddress());
	
	
	employeeRepository.save(updateEmployee);
	return ResponseEntity.ok(updateEmployee);
	
	}
	@DeleteMapping("{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not exist with id :"+id));
	employeeRepository.delete(employee);
	
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
