package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import com.jrd.task.taskproject.entities.Priority;


public interface PriorityService {

	public List<Priority> getPrioritys();

	public Optional<Priority> getPriority(Long priority_id);

	public Priority addPriority(Priority priority_id);

	public boolean updatePriority(Priority priority);
	
	public boolean deletePriority(Long priority_id);

	
	
	

	

	

}
