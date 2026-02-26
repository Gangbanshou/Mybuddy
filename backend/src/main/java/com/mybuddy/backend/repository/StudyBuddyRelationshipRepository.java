package com.mybuddy.backend.repository;

import com.mybuddy.backend.entity.StudyBuddyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudyBuddyRelationshipRepository extends JpaRepository<StudyBuddyRelationship, Long> {
    Optional<StudyBuddyRelationship> findByInviteCode(String inviteCode);
    List<StudyBuddyRelationship> findByUserIdOrBuddyId(Long userId, Long buddyId);
}
