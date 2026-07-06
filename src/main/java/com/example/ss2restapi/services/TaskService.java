package com.example.ss2restapi.services;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.models.User;
import com.example.ss2restapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> findAllTasks(String search) {
        if (search== null || search.isEmpty()) {
            return taskRepository.findAll(search);
        }
        return taskRepository.findAll(search);
    }

    public Task createTask(Task task){
        if (task.getAssignedTo() == null || task.getAssignedTo().getId() == null) {
            return null;
        }
        User existingUser = userService.findUserById(task.getAssignedTo().getId());
        if (existingUser != null) {
            task.setAssignedTo(existingUser);
            return taskRepository.createTask(task);
        }
        return null;
    }
    public Task findTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    public  Task save(Integer id, Task task){
        if (taskRepository.findById(id) == null) {
            return null;
        }
        User existingUser = userService.findUserById(task.getAssignedTo().getId());
        if (existingUser != null) {
            task.setAssignedTo(existingUser);
            return taskRepository.save(task, id);
        }
        return null;
    }

    public Task deleteTask(Integer id) {
        return taskRepository.deleteTask(id);
    }
}
