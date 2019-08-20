package com.shimunmatic.thundershare.service;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.util.auth.UserCredentials;

public interface UserService extends CrudService<User, Long> {

    User getByUsername(String username);

    boolean checkCredentials(UserCredentials userCredentials);
}