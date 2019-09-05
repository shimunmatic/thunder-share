package com.shimunmatic.thundershare.configuration.auth.resolver.implementation;

import com.shimunmatic.thundershare.configuration.auth.resolver.AuthenticationResolver;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by Shimun
 * On 04/09/2019 20:11
 */

@Component
public class DefaultAuthenticationResolver implements AuthenticationResolver<UsernamePasswordAuthenticationToken> {
    @Override
    public Class<UsernamePasswordAuthenticationToken> getResolvedType() {
        return UsernamePasswordAuthenticationToken.class;
    }

    @Override
    public boolean canResolve(UserCredentials userCredentials) {
        return userCredentials != null &&
               (userCredentials.getUsername() != null || userCredentials.getPassword() != null);
    }

    @Override
    public Authentication resolve(UserCredentials userCredentials) {
        return new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());
    }
}
