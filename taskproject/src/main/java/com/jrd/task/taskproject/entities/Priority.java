package com.jrd.task.taskproject.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "priority") 
public class Priority {

	@Id
	@Column(name="priority_id")
	private Long priority_id;

	@Column(name = "description") 
	private String description;
	
	//@OneToMany
	//@JoinColumn
	//private List<Tasks> tasks;
	

	public void printinfo() {
		System.out.println("priority id :" +priority_id + "description :" +description);
	}

	public Long getPriority_id() {
		return priority_id;
	}

	public void setPriority_id(Long priority_id) {
		System.out.println("setting the value to" +priority_id);
		this.priority_id = priority_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Priority [priority_id=" + priority_id + ", description=" + description + "]";
	}

}
