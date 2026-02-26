package com.mybuddy.backend.controller;

import com.mybuddy.backend.dto.TaskCreateRequest;
import com.mybuddy.backend.dto.TaskReorderRequest;
import com.mybuddy.backend.entity.Task;
import com.mybuddy.backend.service.FileService;
import com.mybuddy.backend.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final FileService fileService;

    @PostMapping
    public Task createTask(@Valid @RequestBody TaskCreateRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping
    public List<Task> getByDate(@RequestParam Long userId,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return taskService.getTasksByDate(userId, date);
    }

    @GetMapping("/deadlines")
    public List<Task> deadlines(@RequestParam Long userId) {
        return taskService.getDeadlineTasks(userId);
    }

    @PatchMapping("/reorder")
    public ResponseEntity<Void> reorder(@RequestBody TaskReorderRequest request) {
        taskService.reorderTasks(request.getOrderedTaskIds());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{taskId}/done")
    public Task done(@PathVariable Long taskId) {
        return taskService.markDone(taskId);
    }

    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam Long userId, @RequestParam MultipartFile file) {
        String imageUrl = fileService.uploadTaskImage(file, userId);
        String aiText = fileService.parseTaskByAi(imageUrl);
        return Map.of("imageUrl", imageUrl, "recognizedTask", aiText);
    }
}
