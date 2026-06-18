package org.uam.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.uam.taskmanager.model.Task;

import java.util.UUID;

@Repository
public interface RepositoryTask extends JpaRepository<Task, UUID> {

}
