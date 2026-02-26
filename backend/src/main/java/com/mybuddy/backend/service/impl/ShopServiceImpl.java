package com.mybuddy.backend.service.impl;

import com.mybuddy.backend.dto.ShopItemCreateRequest;
import com.mybuddy.backend.entity.PointTransaction;
import com.mybuddy.backend.entity.ShopItem;
import com.mybuddy.backend.entity.User;
import com.mybuddy.backend.repository.PointTransactionRepository;
import com.mybuddy.backend.repository.ShopItemRepository;
import com.mybuddy.backend.repository.UserRepository;
import com.mybuddy.backend.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopItemRepository shopItemRepository;
    private final UserRepository userRepository;
    private final PointTransactionRepository pointTransactionRepository;

    @Override
    public ShopItem createItem(ShopItemCreateRequest request) {
        ShopItem item = new ShopItem();
        item.setOwner(userRepository.findById(request.getOwnerId()).orElseThrow());
        if (request.getVisibleToBuddyId() != null) {
            item.setVisibleToBuddy(userRepository.findById(request.getVisibleToBuddyId()).orElseThrow());
        }
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setPointCost(request.getPointCost());
        return shopItemRepository.save(item);
    }

    @Override
    public List<ShopItem> listVisibleItems(Long userId) {
        return shopItemRepository.findByOwnerIdOrVisibleToBuddyId(userId, userId);
    }

    @Override
    public void redeem(Long userId, Long itemId) {
        User user = userRepository.findById(userId).orElseThrow();
        ShopItem item = shopItemRepository.findById(itemId).orElseThrow();
        if (user.getPoints() < item.getPointCost()) {
            throw new IllegalStateException("Insufficient points");
        }
        user.setPoints(user.getPoints() - item.getPointCost());
        userRepository.save(user);

        PointTransaction tx = new PointTransaction();
        tx.setUser(user);
        tx.setDelta(-item.getPointCost());
        tx.setReason("Redeem: " + item.getName());
        tx.setRefId(item.getId());
        pointTransactionRepository.save(tx);
    }
}
