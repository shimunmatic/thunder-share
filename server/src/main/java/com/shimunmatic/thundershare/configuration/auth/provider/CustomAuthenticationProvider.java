package com.shimunmatic.thundershare.configuration.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;

public interface CustomAuthenticationProvider extends AuthenticationProvider {

    Class<?> getType();

    @Override
    default boolean supports(Class<?> aClass) {
        return getType().equals(aClass);
    }
}
