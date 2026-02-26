package com.mybuddy.backend.service.impl;

import com.mybuddy.backend.dto.ChatMessageRequest;
import com.mybuddy.backend.entity.ChatMessage;
import com.mybuddy.backend.entity.StudyBuddyRelationship;
import com.mybuddy.backend.entity.User;
import com.mybuddy.backend.repository.ChatMessageRepository;
import com.mybuddy.backend.repository.StudyBuddyRelationshipRepository;
import com.mybuddy.backend.repository.UserRepository;
import com.mybuddy.backend.service.BuddyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuddyServiceImpl implements BuddyService {
    private final StudyBuddyRelationshipRepository relationshipRepository;
    private final ChatMessageRepository chatMessageRepository;
    private final UserRepository userRepository;

    @Override
    public StudyBuddyRelationship joinByInviteCode(Long userId, String inviteCode) {
        StudyBuddyRelationship origin = relationshipRepository.findByInviteCode(inviteCode).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        StudyBuddyRelationship relationship = new StudyBuddyRelationship();
        relationship.setUser(origin.getUser());
        relationship.setBuddy(user);
        relationship.setInviteCode("JOINED-" + origin.getInviteCode());
        return relationshipRepository.save(relationship);
    }

    @Override
    public List<StudyBuddyRelationship> listRelationships(Long userId) {
        return relationshipRepository.findByUserIdOrBuddyId(userId, userId);
    }

    @Override
    public ChatMessage sendMessage(Long relationshipId, ChatMessageRequest request) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setRelationship(relationshipRepository.findById(relationshipId).orElseThrow());
        chatMessage.setSender(userRepository.findById(request.getSenderId()).orElseThrow());
        chatMessage.setType(request.getType());
        chatMessage.setContent(request.getContent());
        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessage> listMessages(Long relationshipId) {
        return chatMessageRepository.findByRelationshipIdOrderByCreatedAtAsc(relationshipId);
    }
}
