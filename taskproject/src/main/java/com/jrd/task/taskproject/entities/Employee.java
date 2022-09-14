package com.jrd.task.taskproject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@Column(name="employee_id")
	private Long employee_id;
	
	@Column(name="email_id")
	private String email_id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	
	public void printinfo() {
		System.out.println("employee_id :" +employee_id+ "email_id :" +email_id+ "first_name :" +first_name+ "last_name :" +last_name);
	}
	
	
	public Employee() {
		
	}


	public Long getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(Long employee_id) {
		System.out.println("setting the value to" +employee_id);
		this.employee_id = employee_id;
	}


	public String getEmail_id() {
		return email_id;
	}


	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", email_id=" + email_id + ", first_name=" + first_name
				+ ", last_name=" + last_name + "]";
	}
	
	
	
	

}
