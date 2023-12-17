package com.utilities;

import org.springframework.stereotype.Component;

@Component
public class Constants {

	// Error quotes for customer controller
	public String CustomerNotFound = "The customer for the given Id is not found";

	// Error quotes for Product controller
	public String ProductNotFound = "The product for the given Id is not found";

	// Error quotes for Employee controller
	public String EmployeeNotFound = "The employee for the given Id is not found";

}
