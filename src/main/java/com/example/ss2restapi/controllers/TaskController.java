package com.example.ss2restapi.controllers;

import com.example.ss2restapi.models.Task;
import com.example.ss2restapi.models.User;
import com.example.ss2restapi.services.TaskService;
import com.example.ss2restapi.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam(name = "search",defaultValue = "") String sreach) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(taskService.findAllTasks(sreach));
    }

    @PostMapping
    public ResponseEntity<?> addTask(@RequestBody Task task) { // Đổi kiểu dữ liệu nhận về thành ResponseEntity<?>
        Task createdTask = taskService.createTask(task);

        if (createdTask != null) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(createdTask);
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Không thể tạo Task: Người được giao không tồn tại trong hệ thống!");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable(name = "id") Integer id) {
        Task task = taskService.findTaskById(id);
        if(task == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable(name = "id") Integer id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);

        if (updatedTask != null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedTask);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Không tìm thấy công việc cần cập nhật hoặc thông tin User gán vào không hợp lệ.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(name = "id") Integer id) {
        Task deletedTask = taskService.deleteTask(id);

        if (deletedTask != null) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Không tìm thấy công việc mang ID: " + id + " để tiến hành xóa.");
        }
    }
}