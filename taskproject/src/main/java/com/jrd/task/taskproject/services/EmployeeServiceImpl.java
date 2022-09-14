package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrd.task.taskproject.dao.EmployeeDao;
import com.jrd.task.taskproject.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployees() {

		return employeeDao.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(Long employee_id) {
		return employeeDao.findById(employee_id);
	}

	@Override
	public Employee addEmployee(Employee employee) {

		Long employeeId = employeeDao.findByEmail_id(employee.getEmail_id());
		System.out.println("print the value" + employeeId);

		// Long employeeId1 = employeeDao.findByFirst_name(employee.getFirst_name());
		// System.out.println("print the value" + employeeId1);

		// Long employeeId2 = employeeDao.findByLast_name(employee.getLast_name());
		// System.out.println("print the value" + employeeId2);

		if (employeeId == null) {

			Long employeeMaxId = employeeDao.findMax();

			Employee employeeDb = new Employee();
			employeeDb.setEmployee_id(employeeMaxId + 1);
			employeeDb.setEmail_id(employee.getEmail_id());
			employeeDb.setFirst_name(employee.getFirst_name());
			employeeDb.setLast_name(employee.getLast_name());
			employee.printinfo();
			System.out.println("max info" + employeeMaxId);

			employeeDao.save(employeeDb);
			return employeeDb;
		} else {

			return null;

		}
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		Long employee_id = employeeDao.findByEmail_id(employee.getEmail_id());

		if (employee_id != null)

			return false;
		else {
			Optional<Employee> employeeDb = employeeDao.findById(employee.getEmployee_id());
			if (!employeeDb.isPresent()) {
				return false;
			} else {
				Employee employee1 = employeeDb.get();
				System.out.println("print before info");
				employee1.printinfo();
				employee1.setEmail_id(employee.getEmail_id());
				System.out.println("print after info");
				employee1.printinfo();
				employeeDao.save(employee1);

				return true;

			}
		}

	}

	@Override
	public boolean deleteEmployee(Long employee_id) {

		Optional<Employee> employee = employeeDao.findById(employee_id);
		if (employee.isPresent()) {
			employeeDao.deleteById(employee_id);
			return true;
		} else
			return false;
	}
}
