package com.shubham.taskmanager.service;

import com.shubham.taskmanager.model.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<List<Task>> getAllTasks();
    ResponseEntity<Task> getTaskById(Long id);
    ResponseEntity<Task> createTask(Task task);
    ResponseEntity<Task> updateTask(Long id, Task task);
    ResponseEntity<Void> deleteTask(Long id);
}