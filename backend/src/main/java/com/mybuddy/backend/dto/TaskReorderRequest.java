package com.mybuddy.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class TaskReorderRequest {
    private List<Long> orderedTaskIds;
}
