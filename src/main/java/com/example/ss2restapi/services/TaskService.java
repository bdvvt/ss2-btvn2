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

    public List<Task> findAllTasks(String search) {
        if (search== null || search.isEmpty()) {
            return taskRepository.findAll(search);
        }
        return taskRepository.findAll(search).stream()
                .filter( user -> user.getTitle().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }
}
