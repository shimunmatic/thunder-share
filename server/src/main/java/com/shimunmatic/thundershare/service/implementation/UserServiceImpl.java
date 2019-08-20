package com.shimunmatic.thundershare.service.implementation;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.repository.UserRepository;
import com.shimunmatic.thundershare.service.AbstractService;
import com.shimunmatic.thundershare.service.UserService;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUserNameEquals(username);
    }

    @Override
    public boolean checkCredentials(UserCredentials userCredentials) {
        return false;
    }
}
