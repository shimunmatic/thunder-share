package com.shimunmatic.thundershare.configuration.auth.resolver.implementation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Shimun
 * On 04/09/2019 20:16
 */

public class GoogleTokenAuthentication implements Authentication {
    private String googleId;
    private String token;
    private String email;
    private boolean authenticated;

    public GoogleTokenAuthentication(String googleId, String token, String email) {
        this.googleId = googleId;
        this.token = token;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptySet();
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getDetails() {
        return email;
    }

    @Override
    public Object getPrincipal() {
        return googleId;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {
        authenticated = b;
    }

    @Override
    public String getName() {
        return "Google";
    }
}
