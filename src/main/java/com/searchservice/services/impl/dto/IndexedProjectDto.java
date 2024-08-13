//package com.searchservice.services.impl.dto;
//
//import java.time.LocalDateTime;
//
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//public class IndexedProjectDto {
//	
//	 private String name;
//
//	    private String description;
//
//	    private LocalDateTime startDate;
//
//	    private LocalDateTime endDate;
//
//	    private Long userId;
//
//	    private Long taskId;
//
//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public String getDescription() {
//			return description;
//		}
//
//		public void setDescription(String description) {
//			this.description = description;
//		}
//
//		public LocalDateTime getStartDate() {
//			return startDate;
//		}
//
//		public void setStartDate(LocalDateTime startDate) {
//			this.startDate = startDate;
//		}
//
//		public LocalDateTime getEndDate() {
//			return endDate;
//		}
//
//		public void setEndDate(LocalDateTime endDate) {
//			this.endDate = endDate;
//		}
//
//		public Long getUserId() {
//			return userId;
//		}
//
//		public void setUserId(Long userId) {
//			this.userId = userId;
//		}
//
//		public Long getTaskId() {
//			return taskId;
//		}
//
//		public void setTaskId(Long taskId) {
//			this.taskId = taskId;
//		}
//
//		public IndexedProjectDto(String name, String description, LocalDateTime startDate, LocalDateTime endDate,
//				Long userId, Long taskId) {
//			super();
//			this.name = name;
//			this.description = description;
//			this.startDate = startDate;
//			this.endDate = endDate;
//			this.userId = userId;
//			this.taskId = taskId;
//		}
//
//		public IndexedProjectDto() {
//			super();
//			// TODO Auto-generated constructor stub
//		}
//	    
//	    
//
//}
