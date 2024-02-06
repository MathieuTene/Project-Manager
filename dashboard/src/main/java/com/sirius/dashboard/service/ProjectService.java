package com.sirius.dashboard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sirius.dashboard.model.Project;
import com.sirius.dashboard.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public Iterable<Project> getAllProject(){
		return projectRepository.findAll();
	}
	
	public Optional<Project> getProjectById(Long id){
		return projectRepository.findById(id);
	}
	
	public Optional<Project> getProjectByTitle(String title){
		return projectRepository.findByTitle(title);
	}
	
	public Project addProject(Project project) {
		return projectRepository.save(project);
	}
	
	public Iterable<Project> addProjects(Iterable<Project> projects){
		return projectRepository.saveAll(projects);
	}
	
	public Project updateProject(Project newValuesProject) {
		if(newValuesProject.getId()!=null) {
			return projectRepository.save(newValuesProject);
		}else {
			return null;
		}
	}
	
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}
	
}
