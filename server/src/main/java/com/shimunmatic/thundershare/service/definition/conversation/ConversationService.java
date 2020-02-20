package com.shimunmatic.thundershare.service.definition.conversation;

import com.shimunmatic.thundershare.model.Conversation;
import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.CrudService;

import java.util.List;

public interface ConversationService extends CrudService<Conversation, Long> {

    List<Conversation> getUsersConversations(User user);

}
