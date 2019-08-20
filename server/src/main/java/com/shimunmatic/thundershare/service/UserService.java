package com.shimunmatic.thundershare.service;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<User, Long>, UserDetailsService {

    User getByUsername(String username);

    boolean checkCredentials(UserCredentials userCredentials);
}