package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jrd.task.taskproject.dao.PriorityDao;
import com.jrd.task.taskproject.entities.Priority;

@Service
@Transactional
public class PriorityServiceImpl implements PriorityService {

	@Autowired
	private PriorityDao priorityDao;
	// private Integer priority_id;

	@Override
	public List<Priority> getPrioritys() {

		return priorityDao.findAll();
	}

	@Override
	public Optional<Priority> getPriority(Long priority_id) {
		// TODO Auto-generated method stub
		return priorityDao.findById(priority_id);

	}

	@Override
	public Priority addPriority(Priority priority) {

		Long priorityId = priorityDao.findByDescription(priority.getDescription());
		System.out.println("print the value:" + priorityId);
		if (priorityId == null) {

			Long priorityMaxId = priorityDao.findMax();

			Priority priorityDb = new Priority();
			priorityDb.setPriority_id(priorityMaxId + 1);
			priorityDb.setDescription(priority.getDescription());
			priority.printinfo();
			System.out.println("max info" + priorityMaxId);

			priorityDao.save(priorityDb);
			return priorityDb;
		} else {

			return null;
		}

	}

	@Override
	public boolean updatePriority(Priority priority) {

		Long priority_id = priorityDao.findByDescription(priority.getDescription());

		if (priority_id != null)
			return false;
		else {
			Optional<Priority> priorityDb = priorityDao.findById(priority.getPriority_id());
			if (!priorityDb.isPresent()) {
				return false;
			} else {
				Priority priority1 = priorityDb.get();
				System.out.println("before setting value");
				priority1.printinfo();
				priority1.setDescription(priority.getDescription());
				System.out.println("after setting value");
				priority1.printinfo();
				priorityDao.save(priority1);

				return true;

			}

		}

	}

	@Override
	public boolean deletePriority(Long priority_id) {
		Optional<Priority> priority = priorityDao.findById(priority_id);
		if (priority.isPresent()) {
			priorityDao.deleteById(priority_id);
			return true;
		} else
			return false;
	}

}
