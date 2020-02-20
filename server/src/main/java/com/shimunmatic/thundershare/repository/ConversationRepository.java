package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    List<Conversation> findConversationsByUserConversationsUserId(Long id);
}

