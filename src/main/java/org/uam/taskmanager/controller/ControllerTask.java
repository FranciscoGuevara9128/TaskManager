package org.uam.taskmanager.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.uam.taskmanager.model.Task;
import org.uam.taskmanager.service.ServiceTask;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class ControllerTask {

    private final ServiceTask service;

    public ControllerTask(ServiceTask service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Task> findById(@PathVariable UUID id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Task> save(@RequestBody Task task){
        return ResponseEntity.ok(service.save(task));
    }

    @PutMapping("/update")
    public ResponseEntity<Task> update(@RequestBody Task task){
        Task t = service.findById(task.getId());
        t.setTitle(task.getTitle());
        t.setDescription(task.getDescription());
        t.setCompleted(task.isCompleted());
        return ResponseEntity.ok(service.save(t));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
