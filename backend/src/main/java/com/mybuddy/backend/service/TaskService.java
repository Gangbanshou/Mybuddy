package com.mybuddy.backend.service;

import com.mybuddy.backend.dto.TaskCreateRequest;
import com.mybuddy.backend.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task createTask(TaskCreateRequest request);
    List<Task> getTasksByDate(Long userId, LocalDate date);
    List<Task> getDeadlineTasks(Long userId);
    void reorderTasks(List<Long> orderedTaskIds);
    Task markDone(Long taskId);
}
