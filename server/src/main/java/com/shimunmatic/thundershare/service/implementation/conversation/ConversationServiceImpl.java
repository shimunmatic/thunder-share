package com.shimunmatic.thundershare.service.implementation.conversation;

import com.shimunmatic.thundershare.model.Conversation;
import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.repository.ConversationRepository;
import com.shimunmatic.thundershare.service.definition.conversation.ConversationService;
import com.shimunmatic.thundershare.service.implementation.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationServiceImpl extends AbstractService<Conversation, Long> implements ConversationService {
    private ConversationRepository conversationRepository;

    public ConversationServiceImpl(ConversationRepository conversationRepository) {
        super(conversationRepository);
        this.conversationRepository = conversationRepository;
    }

    @Override
    public List<Conversation> getUsersConversations(User user) {
        return conversationRepository.findConversationsByUserConversationsUserId(user.getId());
    }
}
