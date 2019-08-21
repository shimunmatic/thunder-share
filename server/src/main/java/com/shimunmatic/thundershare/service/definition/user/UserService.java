package com.shimunmatic.thundershare.service.definition.user;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.CrudService;
import com.shimunmatic.thundershare.service.implementation.user.exception.EmailTakenException;
import com.shimunmatic.thundershare.service.implementation.user.exception.UsernameTakenException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends CrudService<User, Long>, UserDetailsService {

    User getByUsername(String username);

    User getByEmail(String email);

    User registerUser(User user) throws UsernameTakenException, EmailTakenException;
}