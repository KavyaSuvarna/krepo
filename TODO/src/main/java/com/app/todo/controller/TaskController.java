package com.app.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.todo.model.TaskEntity;
import com.app.todo.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value ="/todo", method = RequestMethod.GET)
	public String getTasks(Model model) {
		List<TaskEntity> taskList = taskService.getAllTasks();
	    model.addAttribute("taskList",taskList);
	    return "index";
	  }

    @RequestMapping(value = "/todo/addTask/{taskName}", method = RequestMethod.GET)
    public String addTask(@PathVariable("taskName") String taskName, Map<String, Object> model ) {
        taskService.addTask(taskName);
        List<TaskEntity> taskList = taskService.getAllTasks();
	    model.put("taskList",taskList);
	    return "index";
    }
    
    @RequestMapping(value = "/todo/deleteTask/{taskId}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("taskId") int taskId, Model model ) {
    	taskService.deleteTask(taskId);
    	List<TaskEntity> taskList = taskService.getAllTasks();
	    model.addAttribute("taskList",taskList);
		return "index";
    	
    }
    
    @RequestMapping(value = "/todo/completeTask/{taskId}", method = RequestMethod.GET)
    public String taskComplete(@PathVariable("taskId") int taskId, Model model ){
    	taskService.completeTask(taskId);
    	return "index";
    }
    
	@RequestMapping(value = "/todo/getPendingTasks", method = RequestMethod.GET)
    public String getPendingTasks(Model model ){
    	taskService.getPendingTasks();
    	model.addAttribute("taskList",taskService.getPendingTasks());
    	return "index";
	}
	
	@RequestMapping(value = "/todo/getCompletedTasks", method = RequestMethod.GET)
    public String getCompletedTasks(Model model ){
    	taskService.getCompletedTasks();
    	model.addAttribute("taskList",taskService.getCompletedTasks());
    	return "index";
    	
    }
    
	    

}
