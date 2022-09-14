package com.jrd.task.taskproject.controller;

import java.util.ArrayList;
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

import com.jrd.task.taskproject.entities.Tasks;
import com.jrd.task.taskproject.services.TasksService;

@RestController
public class TasksController {

	@Autowired
	private TasksService tasksService;

	// get the tasks
	@GetMapping("/tasks")
	public List<Tasks> getTaskses() {

		return tasksService.getTaskses();

	}

	// get the single Tasks id
	@GetMapping("/tasks/{task_id}")
	public ResponseEntity<?> getTasks(@PathVariable Long task_id) {

		Optional<Tasks> tasks = tasksService.getTasks(task_id);

		if (tasks.isPresent())
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		else
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	// add the new Tasks id
	@PostMapping("/tasks")
	public ResponseEntity<?> addTasks(@RequestBody Tasks tasks) {

		Tasks addedtasks = tasksService.addTasks(tasks);

		if (addedtasks != null) {
			return new ResponseEntity<>(addedtasks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(tasks, HttpStatus.NOT_FOUND);

		}

	}

	// update the tasks
	@PutMapping("/tasks")
	public ResponseEntity<?> updateTasks(@RequestBody Tasks tasks) {
		System.out.println("from controller");
		// tasks.printinfo();
		boolean updatedtasks = tasksService.updateTasks(tasks);

		if (updatedtasks == true) {
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(tasks, HttpStatus.NOT_FOUND);
		}
	}

	// delete the task Id
	@DeleteMapping("/tasks/{task_id}")
	public ResponseEntity<HttpStatus> deleteTasks(@PathVariable Long task_id) {

		boolean deltasks = tasksService.deleteTasks(task_id);
		if (deltasks == true)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	} 
	
	@GetMapping("/taskbykeyword")
	public List<Tasks> getTaskByDescrip(@RequestBody Tasks tasks) {
		
		  List<Tasks> lsttasks = tasksService.getTaskByDescrip(tasks);
		
		    return lsttasks;
		
		
				
		}
		
		
		
	}


