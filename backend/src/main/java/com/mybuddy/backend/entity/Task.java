package com.mybuddy.backend.entity;

import com.mybuddy.backend.enums.TaskCategory;
import com.mybuddy.backend.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status = TaskStatus.TODO;

    private LocalDate taskDate;

    private LocalDateTime deadline;

    @Column(nullable = false)
    private Integer displayOrder = 0;

    @Column(nullable = false)
    private Integer rewardPoints = 0;

    private String imageUrl;
}
