package com.jrd.task.taskproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrd.task.taskproject.dao.StatusDao;
import com.jrd.task.taskproject.entities.Status;

@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	private StatusDao statusDao;
	//private Integer status_id;

	@Override
	public List<Status> getStatuses() {

		return statusDao.findAll();
	}

	@Override
	public Optional<Status> getStatus(Long status_id) {

		return statusDao.findById(status_id);
	}

	@Override
	public Status addStatus(Status status) {

		Long statusId = statusDao.findByDescription(status.getDescription());
		System.out.println("print the value" + statusId);
		if (statusId == null) {

			Long statusMaxId = statusDao.findMax();

			Status statusDb = new Status();
			statusDb.setStatus_id(statusMaxId + 1);
			statusDb.setDescription(status.getDescription());
			status.printinfo();
			System.out.println("max info" + statusMaxId);

			statusDao.save(statusDb);
			return statusDb;
		} else {

			return null;

		}

	}

	@Override
	public boolean updateStats(Status status) {

		Long status_id = statusDao.findByDescription(status.getDescription());

		if (status_id != null)
			return false;
		else {
			Optional<Status> statusDb = statusDao.findById(status.getStatus_id());
			if (!statusDb.isPresent()) {
				return false;
			} else {
				Status status1 = statusDb.get();
				System.out.println("print before info");
				status1.printinfo();
				status1.setDescription(status.getDescription());
				System.out.println("print after info");
				status1.printinfo();
				statusDao.save(status1);

				return true;

			}
		}

	}

	@Override
	public boolean deleteStatus(Long status_id) {

		Optional<Status> status = statusDao.findById(status_id);
		if (status.isPresent()) {
			statusDao.deleteById(status_id);
			return true;
		} else
			return false;
	}

}
