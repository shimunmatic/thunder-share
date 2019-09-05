package com.shimunmatic.thundershare.configuration.auth.resolver;

import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Shimun
 * On 04/09/2019 20:24
 */

@Component
public class AuthenticationResolverFactory {

    private Map<Class, AuthenticationResolver> resolverMap;

    public AuthenticationResolverFactory(List<AuthenticationResolver> resolverMap) {
        this.resolverMap = resolverMap.stream().collect(
                Collectors.toMap(AuthenticationResolver::getResolvedType, Function.identity()));
    }

    public AuthenticationResolver getResolver(Class<? extends Authentication> type) {
        return resolverMap.getOrDefault(type, null);
    }

    public AuthenticationResolver findResolver(UserCredentials userCredentials) {
        for (AuthenticationResolver resolver : resolverMap.values()) {
            if (resolver.canResolve(userCredentials)) {
                return resolver;
            }
        }
        return null;
    }
}
