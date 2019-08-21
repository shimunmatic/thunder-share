package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.user.UserService;

public class BaseController {
    private UserService userService;

    public BaseController(UserService userService) {
        this.userService = userService;
    }

    User getCurrentUser() {
        return userService.getByUsername("");
    }

}
