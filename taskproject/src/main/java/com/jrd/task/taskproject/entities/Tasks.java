package com.jrd.task.taskproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Tasks {

	@Id
	@Column(name = "task_id")
	private Long task_id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "priority_id")
	private Priority priority;

	@ManyToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Employee owner;

	@ManyToOne
	@JoinColumn(name = "assignee_id")
	private Employee assignee;

	public void printinfo() {
		System.out.println("task_id :" + task_id + "description :" + description);
	}

	public Tasks() {

	}

	public Long getTask_id() {
		return task_id;
	}

	public void setTask_id(Long task_id) {
		System.out.println("settig the value to :" + task_id);

		this.task_id = task_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	public Employee getAssignee() {
		return assignee;
	}

	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return "Tasks [task_id=" + task_id + ", description=" + description + ", priority=" + priority + ", status="
				+ status + ", owner=" + owner + ", assignee=" + assignee + "]";
	}

}
