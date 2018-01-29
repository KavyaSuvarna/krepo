package com.app.todo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.todo.model.TaskEntity;

@Transactional
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
	
	@Query("SELECT t FROM TaskEntity t WHERE t.iscomplete=TRUE")
    public List<TaskEntity> findByIscomplete();
	
	@Query("SELECT t FROM TaskEntity t WHERE t.iscomplete=FALSE")
    public List<TaskEntity> findByIscompleteFalse();
	
	
}