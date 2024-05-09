package com.shubham.taskmanager.controller;

import com.shubham.taskmanager.model.Task;
import com.shubham.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("taskmanager")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("home")
    public String home() {
        return "index";
    }

    @GetMapping("allTasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") Long id) {
        return taskService.deleteTask(id);
    }
}