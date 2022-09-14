package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrd.task.taskproject.dao.TasksDao;
import com.jrd.task.taskproject.entities.Tasks;

@Service
public class TasksServiceImpl implements TasksService {

	@Autowired
	private TasksDao tasksDao;

	@Override
	public List<Tasks> getTaskses() {

		return tasksDao.findAll();
	}

	@Override
	public Optional<Tasks> getTasks(Long task_id) {
	

		return tasksDao.findById(task_id);
	}

	@Override
	public Tasks addTasks(Tasks tasks) {

		Long tasksId = tasksDao.findByDescription(tasks.getDescription());
		System.out.println("print the value" + tasksId);
		if (tasksId == null) {

			Long tasksMaxId = tasksDao.findMax();

			Tasks tasksDb = new Tasks();
			tasksDb.setTask_id(tasksMaxId + 1);
			tasksDb.setDescription(tasks.getDescription());
			tasks.printinfo();
			System.out.println("max info" + tasksMaxId);

			tasksDao.save(tasksDb);
			return tasksDb;
		} else {

			return null;

		}
	}

	@Override
	public boolean updateTasks(Tasks tasks) {

		Long tasks_id = tasksDao.findByDescription(tasks.getDescription());

		if (tasks_id != null)
			return false;
		else {
			Optional<Tasks> tasksDb = tasksDao.findById(tasks.getTask_id());
			if (!tasksDb.isPresent()) {
				return false;
			} else {
				Tasks tasks1 = tasksDb.get();
				System.out.println("print before info ");
				tasks1.printinfo();
				tasks1.setDescription(tasks.getDescription());
				System.out.println("print after info");
				tasks1.printinfo();
				tasksDao.save(tasks1);

				return true;
			}
		}
	}

	@Override
	public boolean deleteTasks(Long task_id) {

		Optional<Tasks> tasks = tasksDao.findById(task_id);
		if (tasks.isPresent()) {
			tasksDao.deleteById(task_id);
			return true;
		} else
			return false;
	}

	@Override
	public List<Tasks> getTaskByDescrip(Tasks tasks) {
		
		System.out.println("get the description" +tasks.getDescription());
		
		List<Tasks> lsttasks = tasksDao.findByDescriptionLike(tasks.getDescription());
		
		return lsttasks;
	}

	
	

	
	

}
