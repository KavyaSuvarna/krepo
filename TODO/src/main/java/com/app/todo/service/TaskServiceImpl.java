package com.app.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.todo.model.TaskEntity;
import com.app.todo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskRepository taskRepo;
	
	@Override
	public List<TaskEntity> getAllTasks() {
		return taskRepo.findAll();
		
	}
	
	@Override
	public void addTask(String taskName) {
		TaskEntity task = new TaskEntity();
		task.setTaskName(taskName);
		task.setIscomplete(Boolean.FALSE);
		taskRepo.save(task);
		
	}

	@Override
	public void deleteTask(int id) {
		taskRepo.delete(id);
	}

	@Override
	public void completeTask(int id) {
		TaskEntity task = taskRepo.getOne(id);
		task.setIscomplete(Boolean.TRUE);
		taskRepo.save(task);
	}

	@Override
	public List<TaskEntity> getPendingTasks() {
		return taskRepo.findByIscompleteFalse();
	}

	@Override
	public List<TaskEntity> getCompletedTasks() {
		return taskRepo.findByIscomplete();
	}
	
	



	

}
