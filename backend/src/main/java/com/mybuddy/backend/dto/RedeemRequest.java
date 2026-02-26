package com.mybuddy.backend.dto;

import lombok.Data;

@Data
public class RedeemRequest {
    private Long userId;
    private Long itemId;
}
