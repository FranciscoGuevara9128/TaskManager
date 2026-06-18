package org.uam.taskmanager.service;

import org.springframework.stereotype.Service;
import org.uam.taskmanager.model.Task;
import org.uam.taskmanager.repository.RepositoryTask;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceTask {
    private final RepositoryTask repo;

    public ServiceTask(RepositoryTask repo) {
        this.repo = repo;
    }

    public List<Task> findAll(){
        return repo.findAll();
    }

    public Task findById(UUID id){
        return repo.findById(id).orElseThrow(
                ()->new RuntimeException("No se encontro la tarea, con el id:"+id));
    }

    public Task save(Task task){
        return repo.save(task);
    }


    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
