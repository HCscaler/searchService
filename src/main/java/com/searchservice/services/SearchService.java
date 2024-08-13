package com.searchservice.services;

import java.util.List;
import java.util.Optional;

import com.searchservice.model.IndexedProject;
import com.searchservice.model.IndexedTask;
import com.searchservice.model.IndexedUser;

public interface SearchService {
    <T> Optional<T> findById(Long id, Class<T> clazz);
    
    List<IndexedTask> getallTask() ;
    List<IndexedProject> getallProject() ;
    List<IndexedUser> getallUser() ;
    
    void saveTask(IndexedTask task);

    void saveProject(IndexedProject project);

    void saveUser(IndexedUser user);

    void deleteTask(Long id);

    void deleteProject(Long id);

    void deleteUser(Long id);
    
    void deleteAllUser();
}
