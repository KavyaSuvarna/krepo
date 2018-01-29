package com.app.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class TaskEntity {
	
	@Id
    @GeneratedValue
    @Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String taskName;
	
	@Column(name="ISCOMPLETE")
	private Boolean iscomplete;
	
	public TaskEntity() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Boolean getIscomplete() {
		return iscomplete;
	}
	public void setIscomplete(Boolean iscomplete) {
		this.iscomplete = iscomplete;
	}
}
