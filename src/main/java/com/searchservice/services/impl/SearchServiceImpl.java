package com.searchservice.services.impl;

import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchservice.model.IndexedProject;
import com.searchservice.model.IndexedTask;
import com.searchservice.model.IndexedUser;
import com.searchservice.model.Task;
import com.searchservice.repository.ProjectSearchRepository;
import com.searchservice.repository.TaskSearchRepository;
import com.searchservice.repository.UserSearchRepository;
import com.searchservice.services.SearchService;


@Service
public class SearchServiceImpl implements SearchService {

	
    private static final Logger log = LoggerFactory.getLogger(SearchServiceImpl.class);
	
    @Autowired
    private TaskSearchRepository taskSearchRepository;
    
    @Autowired
    private ProjectSearchRepository projectSearchRepository;
    
    @Autowired
    private UserSearchRepository userSearchRepository; 

    private final ObjectMapper objectMapper;

    public SearchServiceImpl() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }
    
    @Override
  public <T> Optional<T> findById(Long id, Class<T> clazz) {
      if (clazz.equals(IndexedTask.class)) {
          return (Optional<T>) taskSearchRepository.findById(id);
      } else if (clazz.equals(IndexedProject.class)) {
          return (Optional<T>) projectSearchRepository.findById(id);
      } else if (clazz.equals(IndexedUser.class)) {
          return (Optional<T>) userSearchRepository.findById(id);
      } else {
          return Optional.empty();
      }
  }

    @Override
    public void saveTask(IndexedTask task) {
        taskSearchRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskSearchRepository.deleteById(id);
    }
    
    @KafkaListener(topics = "tasks", groupId = "elasticsearch-group")
    public void consumeTaskMessage(String message) {
        log.info("Received message from 'tasks' topic: {}", message);
        try {
            IndexedTask task = objectMapper.readValue(message, IndexedTask.class);
            if (task.getId() == null) {
                log.error("Task ID is null, cannot save task: {}", message); 
            }
            task.setId(generateUniqueId());
            log.info("Saving task from message with ID: {}", task.getId());
            saveTask(task);
        } catch (JsonProcessingException e) {
            log.error("Error processing task message: {}", message, e);
        } catch (Exception e) {
            log.error("Unexpected error while saving task from message: {}", message, e);
        }
    }
    
    @KafkaListener(topics = "projects", groupId = "elasticsearch-group")
    public void consumeProjectMessage(String message) {
        log.info("Received message from 'projects' topic: {}", message);
        try {
        	IndexedProject indexedProject = objectMapper.readValue(message, IndexedProject.class);
     
//            log.info("Saving task from message with ID: {}", indexedProject.getId());
            saveProject(indexedProject);
        } catch (JsonProcessingException e) {
            log.error("Error processing task message: {}", message, e);
        } catch (Exception e) {
            log.error("Unexpected error while saving task from message: {}", message, e);
        }
    }
    
    @KafkaListener(topics = "users", groupId = "elasticsearch-group")
    public void consumeUserMessage(String message) {
        log.info("Received message from 'users' topic: {}", message);
        try {
            IndexedUser user = objectMapper.readValue(message, IndexedUser.class);
            if (user.getId() != null) {
                log.info("Received user with existing ID: {}", user.getId());
            } else {
                log.info("Generating new ID for user");
                user.setId(generateUniqueId());
            }
            saveUser(user);
        } catch (JsonProcessingException e) {
            log.error("Error processing user message: {}", message, e);
        } catch (Exception e) {
            log.error("Unexpected error while saving user from message: {}", message, e);
        }
    }

//    @KafkaListener(topics = "users", groupId = "elasticsearch-group")
//    public void consumeUserMessage(String message) {
//        log.info("Received message from 'users' topic: {}", message);
//        try {
//        	IndexedUser user = objectMapper.readValue(message, IndexedUser.class);
//        	user.setId(generateUniqueId());
//            saveUser(user);
//        } catch (JsonProcessingException e) {
//            log.error("Error processing task message: {}", message, e);
//        } catch (Exception e) {
//            log.error("Unexpected error while saving task from message: {}", message, e);
//        }
//    }
    
    private Long generateUniqueId() {
        return System.currentTimeMillis(); 
        
    }

	@Override
	public void saveProject(IndexedProject project) {
		 projectSearchRepository.save(project);
		
	}

	@Override
	public void saveUser(IndexedUser user) {
		userSearchRepository.save(user);
	}

	@Override
	public void deleteProject(Long id) {
		projectSearchRepository.deleteById(id);
		
	}

	@Override
	public void deleteUser(Long id) {
		userSearchRepository.deleteById(id);
		
	}

	@Override
	public List<IndexedTask> getallTask() {
		Page<IndexedTask> page = taskSearchRepository.findAll(PageRequest.of(0,100));
		return page.getContent();
	}

	@Override
	public List<IndexedProject> getallProject() {
		Page<IndexedProject> page = projectSearchRepository.findAll(PageRequest.of(0,100));
		return page.getContent();
	}

	@Override
	public List<IndexedUser> getallUser() {
		Page<IndexedUser> page = userSearchRepository.findAll(PageRequest.of(0,100));
		return page.getContent();
	}

	@Override
	public void deleteAllUser() {
		userSearchRepository.deleteAll();
		
	}

	
}
