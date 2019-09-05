package com.shimunmatic.thundershare.configuration.auth.provider;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Shimun
 * On 04/09/2019 20:56
 */

@Component
public class AuthenticationProviderFactory {
    private Map<Class<?>, CustomAuthenticationProvider> authenticationProviderMap;

    public AuthenticationProviderFactory(List<CustomAuthenticationProvider> customAuthenticationProviders) {
        this.authenticationProviderMap = customAuthenticationProviders.stream().collect(
                Collectors.toMap(CustomAuthenticationProvider::getType, Function.identity()));
    }

    public CustomAuthenticationProvider getAuthenticationProvider(Class<?> type) {
        return authenticationProviderMap.getOrDefault(type, null);
    }

    public Collection<CustomAuthenticationProvider> getAuthenticationProviders() {
        return authenticationProviderMap.values();
    }
}
