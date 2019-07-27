package com.shimunmatic.thundershare.controller;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private UserRepository repository;

    public TestController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "test")
    public String test() {
        return "Test";
    }

    @GetMapping(path = "users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(repository.findAll());
    }
}
