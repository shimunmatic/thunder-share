package com.shimunmatic.thundershare.configuration.auth.resolver;

import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.security.core.Authentication;

/**
 * Created by Shimun
 * On 04/09/2019 19:59
 */

public interface AuthenticationResolver<T extends Authentication> {

    Class<T> getResolvedType();

    boolean canResolve(UserCredentials userCredentials);

    Authentication resolve(UserCredentials userCredentials);
}
