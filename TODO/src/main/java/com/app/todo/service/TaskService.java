package com.app.todo.service;

import java.util.List;

import com.app.todo.model.TaskEntity;

public interface TaskService {
	
	public List<TaskEntity> getAllTasks();
	public void addTask(String task);
	public void deleteTask(int id);
	public void completeTask(int id);
	public List<TaskEntity> getPendingTasks();
	public List<TaskEntity> getCompletedTasks();
;}
