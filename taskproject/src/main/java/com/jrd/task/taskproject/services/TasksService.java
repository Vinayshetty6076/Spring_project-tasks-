package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import com.jrd.task.taskproject.entities.Tasks;

public interface TasksService {
	
	public List<Tasks> getTaskses();
	
	public Optional<Tasks> getTasks(Long task_id);
	
	public Tasks addTasks(Tasks task_id);
	
	public boolean updateTasks(Tasks tasks);
	
	public boolean deleteTasks(Long task_id);
	
	public  List<Tasks> getTaskByDescrip(Tasks tasks);
	

}
