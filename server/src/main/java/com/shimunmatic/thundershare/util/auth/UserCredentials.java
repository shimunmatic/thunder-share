package com.shimunmatic.thundershare.util.auth;

import lombok.Data;

@Data
public class UserCredentials {
    private String username;
    private String password;
    private String googleToken;
    private String googleId;
    private String email;
}
