package com.app.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.model.Response;
import com.app.todo.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value ="/todo/getAll", method = RequestMethod.GET)
	public Response getTasks() {
		return new Response("taskList",taskService.getAllTasks());
	  }

    @RequestMapping(value = "/todo/addTask/{taskName}", method = RequestMethod.GET)
    public Response addTask(@PathVariable("taskName") String taskName) {
        taskService.addTask(taskName);
        return new Response("taskList",taskService.getAllTasks());
    }
    
    @RequestMapping(value = "/todo/deleteTask/{taskId}", method = RequestMethod.GET)
    public Response deleteTask(@PathVariable("taskId") int taskId, Model model ) {
    	taskService.deleteTask(taskId);
    	return new Response("taskList",taskService.getAllTasks());
    	
    }
    
    @RequestMapping(value = "/todo/completeTask/{taskId}", method = RequestMethod.GET)
    public void taskComplete(@PathVariable("taskId") int taskId, Model model ){
    	taskService.completeTask(taskId);
    }
    
	@RequestMapping(value = "/todo/getPendingTasks", method = RequestMethod.GET)
    public Response getPendingTasks(Model model ){
		return new Response("taskList",taskService.getPendingTasks());
	}
	
	@RequestMapping(value = "/todo/getCompletedTasks", method = RequestMethod.GET)
    public Response getCompletedTasks(Model model ){
		return new Response("taskList",taskService.getCompletedTasks());
    	
    }
    
	    

}
