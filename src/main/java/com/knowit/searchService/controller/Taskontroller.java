package com.knowit.searchService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowit.searchService.entity.Task;
import com.knowit.searchService.service.TaskService;

@RestController
@RequestMapping("/search")
public class Taskontroller {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("/task/{title}")
	public List<Task> searchTask(@PathVariable String title)
	{
		List<Task> tasks = taskService.searchTask(title);
		return tasks;
	}

}
