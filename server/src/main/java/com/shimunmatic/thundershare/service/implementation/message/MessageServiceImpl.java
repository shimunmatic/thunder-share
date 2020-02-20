package com.shimunmatic.thundershare.service.implementation.message;

import com.shimunmatic.thundershare.model.Message;
import com.shimunmatic.thundershare.repository.MessageRepository;
import com.shimunmatic.thundershare.service.definition.message.MessageService;
import com.shimunmatic.thundershare.service.implementation.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends AbstractService<Message, Long> implements MessageService {
    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        super(messageRepository);
        this.messageRepository = messageRepository;
    }
}
