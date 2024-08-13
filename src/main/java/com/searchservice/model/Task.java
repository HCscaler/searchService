package com.searchservice.model;

import java.util.Date;
import com.searchservice.enums.*;





public class Task {
	
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Long projectId;
    private Date createdAt;
    private Date updatedAt;
    private Status status;

    

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String title, String description, Long userId,Long projectId, Date createdAt, Date updatedAt,Status status) {
		super();
		this.title = title;
		this.description = description;
		this.userId = userId;
		this.projectId =projectId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.status=status;
	}

	
	   public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public Long getProjectId() {
			return projectId;
		}

		public void setProjectId(Long projectId) {
			this.projectId = projectId;
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", title=" + title + ", description=" + description + ", userId=" + userId
					+ ", projectId=" + projectId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", status="
					+ status + "]";
		}


}

