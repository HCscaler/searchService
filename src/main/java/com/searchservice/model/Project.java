package com.searchservice.model;

import java.time.LocalDateTime;

public class Project {

	 private Long id;
	    private String name;
	    private String description;
	    private LocalDateTime startDate;
	    private LocalDateTime endDate;
	    private Long userId;
	    private Long taskId;

	    public Project() {}

	    public Project(Long id, String name, String description, LocalDateTime startDate, LocalDateTime endDate, Long userId, Long taskId) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.startDate = startDate;
	        this.endDate = endDate;
	        this.userId = userId;
	        this.taskId = taskId;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public LocalDateTime getStartDate() {
	        return startDate;
	    }

	    public void setStartDate(LocalDateTime startDate) {
	        this.startDate = startDate;
	    }

	    public LocalDateTime getEndDate() {
	        return endDate;
	    }

	    public void setEndDate(LocalDateTime endDate) {
	        this.endDate = endDate;
	    }

	    public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public Long getTaskId() {
	        return taskId;
	    }

	    public void setTaskId(Long taskId) {
	        this.taskId = taskId;
	    }

	    @Override
	    public String toString() {
	        return "ProjectVO{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", description='" + description + '\'' +
	                ", startDate=" + startDate +
	                ", endDate=" + endDate +
	                ", userId=" + userId +
	                ", taskId=" + taskId +
	                '}';
	    }
	    
}
