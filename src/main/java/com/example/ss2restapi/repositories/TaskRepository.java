package com.example.ss2restapi.repositories;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.models.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks;

    public TaskRepository(UserRepository userRepository) {

        tasks = new ArrayList<>(
                List.of(
                        new Task(1L, "Task 1", "Description 1", "HIGH", userRepository.u1),
                        new Task(2L, "Task 2", "Description 2", "LOW", userRepository.u2),
                        new Task(3L, "Task 3", "Description 3", "MEDIUM", userRepository.u3),
                        new Task(4L, "Task 4", "Description 4", "HIGH",userRepository.u1),
                        new Task(5L, "Task 5", "Description 5", "LOW", userRepository.u2),
                        new Task(6L, "Task 6", "Description 6", "MEDIUM", userRepository.u3),
                        new Task(7L, "Task 7", "Description 7", "HIGH", userRepository.u1),
                        new Task(8L, "Task 8", "Description 8", "LOW", userRepository.u2),
                        new Task(9L, "Task 9", "Description 9", "MEDIUM", userRepository.u3),
                        new Task(10L, "Task 10", "Description 10", "HIGH", userRepository.u1)
                )
        );
    }

    public List<Task> findAll(String search) {
        return tasks;
    }
}
