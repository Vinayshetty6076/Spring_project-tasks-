package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import com.jrd.task.taskproject.entities.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Optional<Employee> getEmployee(Long employee_id);
	
	public Employee addEmployee(Employee employee_id);
	
	public boolean updateEmployee(Employee employee);
	
	public boolean deleteEmployee(Long Employee_id);

}
