package com.jrd.task.taskproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jrd.task.taskproject.entities.Priority;

@Repository
public interface PriorityDao extends JpaRepository<Priority, Long> {

	@Query(value = "select priority_id from priority p where p.description=:description", nativeQuery = true)
	Long findByDescription(@Param("description") String description);

	@Query(value = "select  max(priority_id) from priority", nativeQuery = true)
	Long findMax();

}
