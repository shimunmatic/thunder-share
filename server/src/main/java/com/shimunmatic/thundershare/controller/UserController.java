package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController extends BaseController {
    private UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping(path = "hi")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello");
    }
}
