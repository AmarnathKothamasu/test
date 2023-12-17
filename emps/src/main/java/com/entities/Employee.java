package com.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	// Emp ID , Emp Name , Emp Age , Emp Gender , Emp City , Emp Phone , Emp mail ,
	// Emp_Salary , Emp_Joining_Date
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;

	private String name;

	private int age;

	private String gender;

	private String city;

	private String phone_number;

	private String email;

	private int salary;

	private Date joining_date;

	public Employee(int emp_id, String name, int age, String gender, String city, String phone_number, String email,
			int salary, Date joining_date) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.phone_number = phone_number;
		this.email = email;
		this.salary = salary;
		this.joining_date = joining_date;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(Date joining_date) {
		this.joining_date = joining_date;
	}

}
