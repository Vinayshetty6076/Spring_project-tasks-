package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import com.jrd.task.taskproject.entities.Status;

public interface StatusService {
	
	public List<Status> getStatuses();
	
	public Optional<Status> getStatus(Long status_id);
	
	public Status addStatus(Status status_id);
	
	public boolean updateStats(Status status);
	
	public boolean deleteStatus(Long status_id);



}
