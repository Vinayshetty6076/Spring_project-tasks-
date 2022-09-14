package com.jrd.task.taskproject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {

	@Id
	@Column(name = "status_id")
	private Long status_id;
	
	@Column(name = "description")
	private String description;
	
	//@OneToMany(mappedBy = "tasks")
	//private List<Tasks> tasks;
	
	public void printinfo() {
		System.out.println("status_id :" +status_id+ "description :" +description);
	}
	

	public Long getStatus_id() {
		return status_id;
	}

	public void setStatus_id(Long status_id) {
		System.out.println("setting the value to" +status_id);
		this.status_id = status_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Status [status_id=" + status_id + ", description=" + description + "]";
	}

}
