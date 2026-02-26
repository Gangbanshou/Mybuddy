package com.mybuddy.backend.dto;

import com.mybuddy.backend.enums.TaskCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskCreateRequest {
    @NotNull
    private Long userId;
    @NotBlank
    private String content;
    @NotNull
    private TaskCategory category;
    private LocalDate taskDate;
    private LocalDateTime deadline;
    private Integer rewardPoints = 0;
}
