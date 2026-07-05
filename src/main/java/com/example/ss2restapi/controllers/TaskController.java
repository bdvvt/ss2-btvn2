package com.example.ss2restapi.controllers;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam(name = "search",defaultValue = "") String sreach) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findAllTasks(sreach));
    }
}