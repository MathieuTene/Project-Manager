package com.sirius.dashboard.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sirius.dashboard.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

	Optional<Task> findByTitle(String title);

}
