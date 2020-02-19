package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.UserConversation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
@Slf4j
public class UserConversationRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConversationRepository userConversationRepository;
    @Autowired
    private ConversationRepository conversationRepository;

    @Test
    public void testSaving() {
        userConversationRepository.save(new UserConversation(userRepository.findAll().get(0), conversationRepository.findAll().get(0)));
    }

    @Test
    public void testFetchAll() {
        List<UserConversation> userConversationList = userConversationRepository.findAll();
        log.info("List {}", userConversationList);
    }
}