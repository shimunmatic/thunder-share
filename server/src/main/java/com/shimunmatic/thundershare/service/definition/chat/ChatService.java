package com.shimunmatic.thundershare.service.definition.chat;

import com.shimunmatic.thundershare.model.Conversation;
import com.shimunmatic.thundershare.model.Message;
import com.shimunmatic.thundershare.model.User;

import java.util.List;

public interface ChatService {

    List<Conversation> getListOfConversationsForUser(User user);

    List<Message> getMessagesForConversation(Conversation conversation);

    Message sendMessageToConversation(Message message, Conversation conversation);
}
