package com.shimunmatic.thundershare.service.implementation.userconversation;

import com.shimunmatic.thundershare.model.UserConversation;
import com.shimunmatic.thundershare.repository.UserConversationRepository;
import com.shimunmatic.thundershare.service.definition.userconversation.UserConversationService;
import com.shimunmatic.thundershare.service.implementation.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class UserConversationServiceImpl extends AbstractService<UserConversation, Long> implements UserConversationService {
    private UserConversationRepository userConversationRepository;

    public UserConversationServiceImpl(UserConversationRepository userConversationRepository) {
        super(userConversationRepository);
        this.userConversationRepository = userConversationRepository;
    }
}
