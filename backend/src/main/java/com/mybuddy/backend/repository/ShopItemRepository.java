package com.mybuddy.backend.repository;

import com.mybuddy.backend.entity.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopItemRepository extends JpaRepository<ShopItem, Long> {
    List<ShopItem> findByOwnerIdAndActiveTrue(Long ownerId);
    List<ShopItem> findByOwnerIdOrVisibleToBuddyId(Long ownerId, Long visibleToBuddyId);
}
