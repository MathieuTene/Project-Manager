package com.sirius.dashboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirius.dashboard.model.Task;
import com.sirius.dashboard.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Iterable<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(Long id){
		return taskRepository.findById(id);
	}
	
	public Optional<Task> getTaskByTitle(String title){
		return taskRepository.findByTitle(title);
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public Iterable<Task> addTasks(Iterable<Task> tasks){
		return taskRepository.saveAll(tasks);
	}
	
	public Task updateTask(Task task){
		if(task.getId() != null) {
			return taskRepository.save(task);
		}else {
			return null;
		}
	}
	
	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

}
