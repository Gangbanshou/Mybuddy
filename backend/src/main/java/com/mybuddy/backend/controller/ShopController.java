package com.mybuddy.backend.controller;

import com.mybuddy.backend.dto.RedeemRequest;
import com.mybuddy.backend.dto.ShopItemCreateRequest;
import com.mybuddy.backend.entity.ShopItem;
import com.mybuddy.backend.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;

    @PostMapping("/items")
    public ShopItem create(@RequestBody ShopItemCreateRequest request) {
        return shopService.createItem(request);
    }

    @GetMapping("/items")
    public List<ShopItem> list(@RequestParam Long userId) {
        return shopService.listVisibleItems(userId);
    }

    @PostMapping("/redeem")
    public ResponseEntity<Void> redeem(@RequestBody RedeemRequest request) {
        shopService.redeem(request.getUserId(), request.getItemId());
        return ResponseEntity.ok().build();
    }
}
