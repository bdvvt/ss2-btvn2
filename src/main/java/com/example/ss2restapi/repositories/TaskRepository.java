package com.example.ss2restapi.repositories;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.models.User;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks;

    public TaskRepository(UserRepository userRepository) {

        tasks = new ArrayList<>(
                List.of(
                        new Task(1, "Task 1", "Description 1", "HIGH", userRepository.u1),
                        new Task(2, "Task 2", "Description 2", "LOW", userRepository.u2),
                        new Task(3, "Task 3", "Description 3", "MEDIUM", userRepository.u3),
                        new Task(4, "Task 4", "Description 4", "HIGH",userRepository.u1),
                        new Task(5, "Task 5", "Description 5", "LOW", userRepository.u2),
                        new Task(6, "Task 6", "Description 6", "MEDIUM", userRepository.u3),
                        new Task(7, "Task 7", "Description 7", "HIGH", userRepository.u1),
                        new Task(8, "Task 8", "Description 8", "LOW", userRepository.u2),
                        new Task(9, "Task 9", "Description 9", "MEDIUM", userRepository.u3),
                        new Task(10, "Task 10", "Description 10", "HIGH", userRepository.u1)
                )
        );
    }

    public List<Task> findAll(String search) {
        return tasks.stream()
                .filter( task -> task.getTitle().toLowerCase().contains(search.toLowerCase()))
                .toList();
    }

    public Task createTask(Task task){
        Task maxId = tasks.stream().max(Comparator.comparingInt(Task::getId)).orElse(null);
        Task newTask =new Task(
                maxId != null ? maxId.getId() + 1 : 1,
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getAssignedTo()
        );
        tasks.add(newTask);
        return  newTask;
    }

    public Task findById(Integer id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task updateTask(Task task,Integer id){
        Task taskUp = tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
        if(taskUp != null){
            taskUp.setTitle(task.getTitle());
            taskUp.setDescription(task.getDescription());
            taskUp.setPriority(task.getPriority());
            if (task.getAssignedTo() != null){
                taskUp.setAssignedTo(task.getAssignedTo());
            }
            return  taskUp;
        }
        return null;
    }

    public Task deleteTask(Integer id){
        Task taskDelete = tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (taskDelete != null) {
            tasks.remove(taskDelete);
            return taskDelete;
        }
        return null;
    }
}
