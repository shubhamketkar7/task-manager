package com.shubham.taskmanager.service;

import com.shubham.taskmanager.model.Task;
import com.shubham.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return ResponseEntity.ok().body(tasks);
    }

    @Override
    public ResponseEntity<Task> getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(task -> ResponseEntity.ok().body(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Task> createTask(Task task) {
        Task createdTask = taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @Override
    public ResponseEntity<Task> updateTask(Long id, Task task) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setName(task.getName());
            existingTask.setDescription(task.getDescription());
            existingTask.setPriority(task.getPriority());
            existingTask.setDueDate(task.getDueDate());
            Task updatedTask = taskRepository.save(existingTask);
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}