package com.jrd.task.taskproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrd.task.taskproject.entities.Status;

@Repository
public interface StatusDao extends JpaRepository<Status, Long> {

	@Query(value = "select status_id from status s where s.description=:description", nativeQuery = true)
	Long findByDescription(@Param("description") String description);

	@Query(value = "select max(status_id) from status", nativeQuery = true)
	Long findMax();

}
