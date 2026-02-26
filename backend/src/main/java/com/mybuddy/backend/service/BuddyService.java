package com.mybuddy.backend.service;

import com.mybuddy.backend.dto.ChatMessageRequest;
import com.mybuddy.backend.entity.ChatMessage;
import com.mybuddy.backend.entity.StudyBuddyRelationship;

import java.util.List;

public interface BuddyService {
    StudyBuddyRelationship joinByInviteCode(Long userId, String inviteCode);
    List<StudyBuddyRelationship> listRelationships(Long userId);
    ChatMessage sendMessage(Long relationshipId, ChatMessageRequest request);
    List<ChatMessage> listMessages(Long relationshipId);
}
