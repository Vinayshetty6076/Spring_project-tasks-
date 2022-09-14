package com.jrd.task.taskproject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.jrd.task.taskproject.entities.Tasks;

@Repository
public interface TasksDao extends JpaRepository<Tasks, Long> {
	
	@Query(value = "select task_id from tasks t where t.description=:description", nativeQuery = true)
	Long findByDescription(@Param("description") String description);
	
	@Query(value = "select max(task_id) from tasks", nativeQuery = true)
	Long findMax();
	
	
	@Query(value =" select t FROM Tasks t WHERE description LIKE %:description%", nativeQuery = false)
	public List<Tasks> findByDescriptionLike(@Param("description") String description);
	
	
	
    
	
	

}
