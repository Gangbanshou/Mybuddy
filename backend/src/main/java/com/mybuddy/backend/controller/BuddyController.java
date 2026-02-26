package com.mybuddy.backend.controller;

import com.mybuddy.backend.dto.BuddyJoinRequest;
import com.mybuddy.backend.dto.ChatMessageRequest;
import com.mybuddy.backend.entity.ChatMessage;
import com.mybuddy.backend.entity.StudyBuddyRelationship;
import com.mybuddy.backend.service.BuddyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buddies")
@RequiredArgsConstructor
public class BuddyController {
    private final BuddyService buddyService;

    @PostMapping("/join")
    public StudyBuddyRelationship join(@Valid @RequestBody BuddyJoinRequest request) {
        return buddyService.joinByInviteCode(request.getUserId(), request.getInviteCode());
    }

    @GetMapping
    public List<StudyBuddyRelationship> list(@RequestParam Long userId) {
        return buddyService.listRelationships(userId);
    }

    @PostMapping("/{relationshipId}/messages")
    public ChatMessage sendMessage(@PathVariable Long relationshipId, @Valid @RequestBody ChatMessageRequest request) {
        return buddyService.sendMessage(relationshipId, request);
    }

    @GetMapping("/{relationshipId}/messages")
    public List<ChatMessage> messages(@PathVariable Long relationshipId) {
        return buddyService.listMessages(relationshipId);
    }
}
