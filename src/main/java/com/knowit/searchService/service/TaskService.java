package com.knowit.searchService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knowit.searchService.entity.Task;
import com.knowit.searchService.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> searchTask(String title)
	{
		List<Task> tasks = taskRepository.searchTask(title);
		return tasks;
	}
}
