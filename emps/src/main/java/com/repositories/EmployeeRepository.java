package com.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	

}
