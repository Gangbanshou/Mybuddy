package com.mybuddy.backend.dto;

import lombok.Data;

@Data
public class ShopItemCreateRequest {
    private Long ownerId;
    private Long visibleToBuddyId;
    private String name;
    private String description;
    private Integer pointCost;
}
