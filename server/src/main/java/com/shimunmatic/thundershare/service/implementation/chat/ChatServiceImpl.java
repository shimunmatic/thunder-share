package com.shimunmatic.thundershare.service.implementation.chat;

import com.shimunmatic.thundershare.model.Conversation;
import com.shimunmatic.thundershare.model.Message;
import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.chat.ChatService;
import com.shimunmatic.thundershare.service.definition.conversation.ConversationService;
import com.shimunmatic.thundershare.service.definition.message.MessageService;
import com.shimunmatic.thundershare.service.definition.userconversation.UserConversationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private UserConversationService userConversationService;
    private ConversationService conversationService;
    private MessageService messageService;

    @Autowired
    public ChatServiceImpl(UserConversationService userConversationService, ConversationService conversationService, MessageService messageService) {
        this.userConversationService = userConversationService;
        this.conversationService = conversationService;
        this.messageService = messageService;
    }

    @Override
    public List<Conversation> getListOfConversationsForUser(User user) {
        return conversationService.getUsersConversations(user);
    }

    @Override
    public List<Message> getMessagesForConversation(Conversation conversation) {
        return null;
    }

    @Override
    public Message sendMessageToConversation(Message message, Conversation conversation) {
        return null;
    }
}
