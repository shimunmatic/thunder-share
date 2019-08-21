package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

@Slf4j
public class BaseController {
    private UserService userService;

    public BaseController(UserService userService) {
        this.userService = userService;
    }

    User getCurrentUser() {
        return userService.getByUsername(getCurrentUsername());
    }

    String getCurrentUsername() {
        return String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
