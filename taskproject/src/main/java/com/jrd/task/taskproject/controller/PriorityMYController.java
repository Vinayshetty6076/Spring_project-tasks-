package com.jrd.task.taskproject.controller;

import java.util.List;
import java.util.NoSuchElementException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jrd.task.taskproject.entities.Priority;
import com.jrd.task.taskproject.services.PriorityService;

@RestController
public class PriorityMYController {

	@Autowired
	private PriorityService priorityService;
	private boolean existpriority;

	// get the task
	@GetMapping("/priority")
	public List<Priority> getPrioritys() {
		return priorityService.getPrioritys();

	}

	// get the priority with priority id

	@GetMapping("/priority/{priority_id}")
	public ResponseEntity<?> getPriority(@PathVariable Long priority_id) {

		Optional<Priority> priority = priorityService.getPriority(priority_id);

		if (priority.isPresent())
			return new ResponseEntity<>(priority, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// it will add new priority to the database
	@PostMapping("/priority")
	public ResponseEntity<?> addPriority(@RequestBody Priority priority) {

		Priority addedpriority = priorityService.addPriority(priority);

		if (addedpriority != null) {
			return new ResponseEntity<>(addedpriority, HttpStatus.OK);
		} else {

			return new ResponseEntity<>(priority, HttpStatus.NOT_FOUND);
		}
	}

	// update the priority using Put method
	@PutMapping("/priority")
	public ResponseEntity<?> updatePriority(@RequestBody Priority priority) {
		System.out.println("from controller");
		priority.printinfo();
		boolean updatedpriority = priorityService.updatePriority(priority);

		if (updatedpriority == true) {

			return new ResponseEntity<>(priority, HttpStatus.OK);
		} else

			return new ResponseEntity<>(priority, HttpStatus.NOT_FOUND);

	}

	// delete the priority
	@DeleteMapping("/priority/{priority_id}")
	public ResponseEntity<HttpStatus> deletePriority(@PathVariable Long priority_id) {

		boolean delpriority = priorityService.deletePriority(priority_id);
		if (delpriority == true)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
