package com.sirius.dashboard.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sirius.dashboard.model.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{

	Optional<Project> findByTitle(String title);

}
