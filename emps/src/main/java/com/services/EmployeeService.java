package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entities.Employee;
import com.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired	
	EmployeeRepository employeeRepository ;

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployeeByID(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(employeeId);
	}

}
