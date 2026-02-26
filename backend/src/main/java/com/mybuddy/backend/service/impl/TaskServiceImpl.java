package com.mybuddy.backend.service.impl;

import com.mybuddy.backend.dto.TaskCreateRequest;
import com.mybuddy.backend.entity.Task;
import com.mybuddy.backend.entity.User;
import com.mybuddy.backend.enums.TaskStatus;
import com.mybuddy.backend.repository.TaskRepository;
import com.mybuddy.backend.repository.UserRepository;
import com.mybuddy.backend.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public Task createTask(TaskCreateRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow();
        Task task = new Task();
        task.setUser(user);
        task.setContent(request.getContent());
        task.setCategory(request.getCategory());
        task.setTaskDate(request.getTaskDate() == null ? LocalDate.now() : request.getTaskDate());
        task.setDeadline(request.getDeadline());
        task.setRewardPoints(request.getRewardPoints() == null ? 0 : request.getRewardPoints());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByDate(Long userId, LocalDate date) {
        return taskRepository.findByUserIdAndTaskDateOrderByDisplayOrderAsc(userId, date);
    }

    @Override
    public List<Task> getDeadlineTasks(Long userId) {
        return taskRepository.findByUserIdAndDeadlineIsNotNullOrderByDeadlineAsc(userId);
    }

    @Override
    public void reorderTasks(List<Long> orderedTaskIds) {
        for (int i = 0; i < orderedTaskIds.size(); i++) {
            Task task = taskRepository.findById(orderedTaskIds.get(i)).orElseThrow();
            task.setDisplayOrder(i);
            taskRepository.save(task);
        }
    }

    @Override
    public Task markDone(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(TaskStatus.DONE);
        return taskRepository.save(task);
    }
}
