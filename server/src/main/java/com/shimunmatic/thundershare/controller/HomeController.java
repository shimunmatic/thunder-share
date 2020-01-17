package com.shimunmatic.thundershare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shimun
 * On 27/08/2019 23:53
 */
@RestController
public class HomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to Thunder Share! 2019";
    }
}
