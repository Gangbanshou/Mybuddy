package com.mybuddy.backend.service;

import com.mybuddy.backend.dto.ShopItemCreateRequest;
import com.mybuddy.backend.entity.ShopItem;

import java.util.List;

public interface ShopService {
    ShopItem createItem(ShopItemCreateRequest request);
    List<ShopItem> listVisibleItems(Long userId);
    void redeem(Long userId, Long itemId);
}
