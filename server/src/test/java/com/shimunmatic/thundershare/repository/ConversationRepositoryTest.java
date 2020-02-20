package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.Conversation;
import io.jsonwebtoken.lang.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
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
public class ConversationRepositoryTest {
    @Autowired
    private ConversationRepository repository;
    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSaving() {
        repository.save(Conversation.builder().title("test title").profileImagePath("").build());
    }

    @Test
    public void testGetAllForUser() {
        List<Conversation> conversations = repository.findConversationsByUserConversationsUserId(userRepository.findAll().get(0).getId());
        Assert.notNull(conversations);
        Assert.notEmpty(conversations);
        log.info("Conversations: {}", conversations);
    }
}