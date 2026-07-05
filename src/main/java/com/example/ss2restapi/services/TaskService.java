package com.example.ss2restapi.services;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.models.User;
import com.example.ss2restapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}
