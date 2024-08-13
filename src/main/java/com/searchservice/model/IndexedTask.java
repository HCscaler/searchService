package com.searchservice.model;



import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.searchservice.enums.Status;

@Document(indexName = "indexed_task")
public class IndexedTask {

	@Id
	private Long id;
	
	@Field(type = FieldType.Text)
	private String title;
	
	 @Field(type = FieldType.Text)
	    private String description;

	    @Field(type = FieldType.Long)
	    private Long userId;

	    @Field(type = FieldType.Long)
	    private Long projectId;

	    @Field(type = FieldType.Date)
	    private Date createdAt;

	    @Field(type = FieldType.Date)
	    private Date updatedAt;

	    @Field(type = FieldType.Keyword)
	    private Status status;

	    public IndexedTask() {}

	    public IndexedTask(Long id, String title, String description, Long userId, Long projectId, Date createdAt, Date updatedAt, Status status) {
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.userId = userId;
	        this.projectId = projectId;
	        this.createdAt = createdAt;
	        this.updatedAt = updatedAt;
	        this.status = status;
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

	    public Long getProjectId() {
	        return projectId;
	    }

	    public void setProjectId(Long projectId) {
	        this.projectId = projectId;
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
}
