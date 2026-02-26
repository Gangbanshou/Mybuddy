package com.mybuddy.backend.repository;

import com.mybuddy.backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserIdAndTaskDateOrderByDisplayOrderAsc(Long userId, LocalDate date);
    List<Task> findByUserIdAndDeadlineIsNotNullOrderByDeadlineAsc(Long userId);
}
