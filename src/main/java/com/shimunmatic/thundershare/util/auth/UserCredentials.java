package com.shimunmatic.thundershare.util.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCredentials {
    private String username;
    private String password;
}
