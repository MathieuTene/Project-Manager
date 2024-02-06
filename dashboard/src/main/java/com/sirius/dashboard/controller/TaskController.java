package com.sirius.dashboard.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sirius.dashboard.model.Task;
import com.sirius.dashboard.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("api/dashboard/task/all")
	public ResponseEntity<Iterable<Task>> getAllTasks(){
		Iterable<Task> tasks = taskService.getAllTasks();
		return ResponseEntity.status(HttpStatus.OK).body(tasks);
	}
	
	@GetMapping("api/dashboard/task/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable(name = "id") Long id){
		Optional<Task> task = taskService.getTaskById(id);
		return ResponseEntity.status(HttpStatus.OK).body(task.get());
	}
	
	@GetMapping("api/dashboard/task/{title}")
	public ResponseEntity<Task> getTaskByTitle(@PathVariable(name = "title") String title){
		Optional<Task> task = taskService.getTaskByTitle(title);
		return ResponseEntity.status(HttpStatus.OK).body(task.get());
	}
	
	@PostMapping("api/dashboard/task")
	public ResponseEntity<Task> addTask(@RequestBody Task task){
		Task addedTask = taskService.addTask(task);
		return ResponseEntity.status(HttpStatus.OK).body(addedTask);
	}
	
	@PutMapping("api/dashboard/task")
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		Task updatedTask = taskService.updateTask(task);
		return ResponseEntity.status(HttpStatus.OK).body(updatedTask);
	}
	
	@DeleteMapping("api/dashboard/task/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable(name = "id") Long id){
		taskService.deleteTask(id);
		return ResponseEntity.noContent().build();
	}
	
}
