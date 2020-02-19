package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.UserConversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConversationRepository extends JpaRepository<UserConversation, Long> {
}
