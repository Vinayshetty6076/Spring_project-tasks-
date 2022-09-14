package com.jrd.task.taskproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jrd.task.taskproject.entities.Employee;


public interface EmployeeDao extends JpaRepository<Employee, Long> {
	
	@Query(value = "select employee_id from employee e where e.email_id=:email_id", nativeQuery = true)
	Long findByEmail_id(@Param("email_id") String email_id);
	
	//@Query(value = "select employee_id from employee e where e.first_name=:first_name", nativeQuery = true)
	//Long findByFirst_name(@Param("first_name") String first_name);
	
	//@Query(value = "select employee_id from employee e where e.last_name=:last_name", nativeQuery = true)
	//Long findByLast_name(@Param("last_name") String last_name);

	@Query(value = "select max(employee_id) from employee", nativeQuery = true)
	Long findMax();

	

	
}
