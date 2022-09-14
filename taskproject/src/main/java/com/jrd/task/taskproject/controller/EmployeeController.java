package com.jrd.task.taskproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrd.task.taskproject.entities.Employee;
import com.jrd.task.taskproject.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// get the employee details
	@GetMapping("/employee")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	// get the single employee id
	@GetMapping("/employee/{employee_id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long employee_id) {

		Optional<Employee> employee = employeeService.getEmployee(employee_id);

		if (employee.isPresent())
			return new ResponseEntity<>(employee, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// adding employee to the table
	@PostMapping("/employee")
	public ResponseEntity<?> addEmployees(@RequestBody Employee employee) {
		
		Employee addedemployee = employeeService.addEmployee(employee);
		
		if(addedemployee != null) {
	          return new ResponseEntity<>(addedemployee, HttpStatus.OK);
		}else {
			  return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
		}
	}

	// update employee
	@PutMapping("/employee")
	public ResponseEntity<?> updatEmployee(@RequestBody Employee employee) {
		System.out.println("ffrom controller");
		//employee.printinfo();
		boolean updatedemployee = employeeService.updateEmployee(employee);
		
		if (updatedemployee == true) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(employee, HttpStatus.NOT_FOUND);
		}
	}

	// delete the employee
	@DeleteMapping("/employee/{employee_id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable Long employee_id) {
		
		boolean delemployee = employeeService.deleteEmployee(employee_id);
		     if(delemployee == true)
		    	 return new ResponseEntity<>(HttpStatus.OK);
		     else
		    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

}
