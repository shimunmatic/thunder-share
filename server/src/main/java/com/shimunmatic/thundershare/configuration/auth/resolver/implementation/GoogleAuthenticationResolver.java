package com.shimunmatic.thundershare.configuration.auth.resolver.implementation;

import com.shimunmatic.thundershare.configuration.auth.resolver.AuthenticationResolver;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by Shimun
 * On 04/09/2019 20:21
 */

@Component
public class GoogleAuthenticationResolver implements AuthenticationResolver<GoogleTokenAuthentication> {
    @Override
    public Class<GoogleTokenAuthentication> getResolvedType() {
        return GoogleTokenAuthentication.class;
    }

    @Override
    public boolean canResolve(UserCredentials userCredentials) {
        return userCredentials != null &&
               (userCredentials.getGoogleId() != null || userCredentials.getGoogleToken() != null);
    }

    @Override
    public Authentication resolve(UserCredentials userCredentials) {
        return new GoogleTokenAuthentication(userCredentials.getGoogleId(), userCredentials.getGoogleToken(),
                userCredentials.getEmail());
    }
}
