package com.mybuddy.backend.dto;

import com.mybuddy.backend.enums.MessageType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChatMessageRequest {
    @NotNull
    private Long senderId;
    @NotNull
    private MessageType type;
    @NotBlank
    private String content;
}
