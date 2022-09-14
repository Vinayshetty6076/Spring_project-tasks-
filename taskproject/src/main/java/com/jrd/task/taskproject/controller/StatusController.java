package com.jrd.task.taskproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jrd.task.taskproject.entities.Status;
import com.jrd.task.taskproject.services.StatusService;

@RestController
public class StatusController {

	@Autowired
	private StatusService statusService;
	//private boolean existstatus;

	// get the Status
	@GetMapping("/status")
	public List<Status> getStatuses() {
		return statusService.getStatuses();
	}

	// get the single status id
	@GetMapping("/status/{status_id}")
	public ResponseEntity<?> getStatus(@PathVariable Long status_id) {
		
		Optional<Status> status = statusService.getStatus(status_id);
		
		if(status.isPresent())
			return new ResponseEntity<>(status, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		
	}

	// adding new status
	@PostMapping("/status")
	public ResponseEntity<?> addStatuses(@RequestBody Status status) {
		
		Status addedstatus = statusService.addStatus(status);
		
		if(addedstatus != null) {
			return new ResponseEntity<>(addedstatus, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
		}
			
	}

	// update Status
	@PutMapping("/status")
	public ResponseEntity<?> updateStatuses(@RequestBody Status status) {
		System.out.println("from controller");
		status.printinfo();
		boolean updatedstatus = statusService.updateStats(status);
		
		if(updatedstatus == true) {
			
			return new ResponseEntity<>(status, HttpStatus.OK);
		}else
			return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
		}
	

	// delete the status
	@DeleteMapping("/status/{status_id}")
	public ResponseEntity<HttpStatus> deleteStatus(@PathVariable Long status_id) {
		
	boolean delstatus = statusService.deleteStatus(status_id);
	     if(delstatus == true)
	    	 return new ResponseEntity<>(HttpStatus.OK);
	     else
	    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		}

	}

