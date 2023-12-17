package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Employee;
import com.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);

	}
	
	@GetMapping("{getEmployeeById}")
	public ResponseEntity<Optional> getEmployee(@PathVariable("getEmployeeById") int employeeId){
		Optional<Employee> getEmployee = employeeService.getEmployeeByID(employeeId);
		return new ResponseEntity<>(getEmployee,HttpStatus.OK);
	}
	

}
