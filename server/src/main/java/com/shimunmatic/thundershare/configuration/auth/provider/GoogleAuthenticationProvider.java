package com.shimunmatic.thundershare.configuration.auth.provider;

import com.shimunmatic.thundershare.configuration.auth.resolver.implementation.GoogleTokenAuthentication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * Created by Shimun
 * On 04/09/2019 20:46
 */

@Component
public class GoogleAuthenticationProvider implements CustomAuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        authentication.setAuthenticated("googleTestToken".equals(authentication.getCredentials()));
        return authentication;
    }

    @Override
    public Class<?> getType() {
        return GoogleTokenAuthentication.class;
    }
}
