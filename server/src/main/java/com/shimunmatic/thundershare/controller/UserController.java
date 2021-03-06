package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.definition.user.UserService;
import com.shimunmatic.thundershare.service.implementation.user.exception.EmailTakenException;
import com.shimunmatic.thundershare.service.implementation.user.exception.UsernameTakenException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "user")
@Slf4j(topic = "UserController")
public class UserController extends BaseController {
    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            log.trace("Getting all users");
            log.info("{} {}", getCurrentUsername(), getCurrentUser());
            return ResponseEntity.ok(userService.getAll());
        } catch (Exception e) {
            log.warn("Exception while getting all users", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).eTag(e.getMessage()).build();
        }
    }

    @PostMapping(path = "register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            log.trace("Registering new user: {}", user);
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (EmailTakenException | UsernameTakenException e) {
            log.info("Username or Email taken", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).eTag(e.getMessage()).build();
        } catch (Exception e) {
            log.warn("Unknown exception while registering user {}", user, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).eTag(e.getMessage()).build();
        }
    }
}
