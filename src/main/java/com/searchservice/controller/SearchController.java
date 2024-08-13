package com.searchservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.searchservice.model.IndexedProject;
import com.searchservice.model.IndexedTask;
import com.searchservice.model.IndexedUser;
import com.searchservice.services.SearchService;

@RestController
@RequestMapping("v0/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/task/{id}")
    public Optional<IndexedTask> getTaskById(@PathVariable Long id) {
        return searchService.findById(id, IndexedTask.class);
    }

    @GetMapping("/project/{id}")
    public Optional<IndexedProject> getProjectById(@PathVariable Long id) {
        return searchService.findById(id, IndexedProject.class);
    }

    @GetMapping("/user/{id}")
    public Optional<IndexedUser> getUserById(@PathVariable Long id) {
        return searchService.findById(id, IndexedUser.class);
    }

    @PostMapping("/task")
    public void saveTask(@RequestBody IndexedTask task) {
        searchService.saveTask(task);
    }

    @PostMapping("/project")
    public void saveProject(@RequestBody IndexedProject project) {
        searchService.saveProject(project);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody IndexedUser user) {
        searchService.saveUser(user);
    }

    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        searchService.deleteTask(id);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProject(@PathVariable Long id) {
        searchService.deleteProject(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        searchService.deleteUser(id);
    }
    
    @DeleteMapping("/deleteallusers")
    public void deleteUser() {
        searchService.deleteAllUser();
    }
    @GetMapping("/getallTask")
    public List<IndexedTask> getAllTasks()
    {
    	List<IndexedTask> indexedTasks= searchService.getallTask();
    	return indexedTasks;
    }
    
    @GetMapping("/getallproject")
    public List<IndexedProject> getAllProjects()
    {
    	List<IndexedProject> indexedProjects= searchService.getallProject();
    	return indexedProjects;
    }
    
    @GetMapping("/getalluser")
    public List<IndexedUser> getAllUsers()
    {
    	List<IndexedUser> indexedUsers = searchService.getallUser();
    	return indexedUsers;
    }
}
