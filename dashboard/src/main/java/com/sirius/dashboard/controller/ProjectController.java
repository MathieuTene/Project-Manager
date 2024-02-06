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

import com.sirius.dashboard.model.Project;
import com.sirius.dashboard.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("api/dashboard/project/all")
	public ResponseEntity<Iterable<Project>> getAllProjects(){
		Iterable<Project> allProjects = projectService.getAllProject();
		return ResponseEntity.status(HttpStatus.OK).body(allProjects);
	}
	
	@GetMapping("api/dashboard/projectid/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable(name = "id") Long id){
		Optional<Project> project = projectService.getProjectById(id);
		return ResponseEntity.status(HttpStatus.OK).body(project.get());
	}
	
	@GetMapping("api/dashboard/projecttitle/{title}")
	public ResponseEntity<Project> getProjectByTitle(@PathVariable(name = "title") String title){
		Optional<Project> project = projectService.getProjectByTitle(title);
		return ResponseEntity.status(HttpStatus.OK).body(project.get());
	}
	
	@PostMapping("api/dashboard/project")
	public ResponseEntity<Project> addProject(@RequestBody Project project){
		Project addedProject = projectService.addProject(project);
		return ResponseEntity.status(HttpStatus.OK).body(addedProject);
	}
	
	@PutMapping("api/dashboard/project")
	public ResponseEntity<Project> updateProject(@RequestBody Project project){
		Project updatedProject = projectService.updateProject(project);
		return ResponseEntity.status(HttpStatus.OK).body(updatedProject);
	}
	
	@DeleteMapping("api/dashboard/project/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable(name = "id") Long id){
		projectService.deleteProject(id);
		return ResponseEntity.noContent().build();
	}

}
