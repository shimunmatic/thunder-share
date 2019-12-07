package com.shimunmatic.thundershare.configuration.auth;

import com.shimunmatic.thundershare.configuration.auth.filter.JwtAuthenticationFilter;
import com.shimunmatic.thundershare.configuration.auth.filter.JwtAuthorizationFilter;
import com.shimunmatic.thundershare.configuration.auth.provider.AuthenticationProviderFactory;
import com.shimunmatic.thundershare.configuration.auth.resolver.AuthenticationResolverFactory;
import com.shimunmatic.thundershare.service.definition.user.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final AuthenticationResolverFactory resolverFactory;
    private final AuthenticationProviderFactory providerFactory;

    public SecurityConfiguration(UserService userService, AuthenticationResolverFactory resolverFactory,
                                 AuthenticationProviderFactory providerFactory) {
        this.userService = userService;
        this.resolverFactory = resolverFactory;
        this.providerFactory = providerFactory;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests().antMatchers("/", "/user/register")
            .permitAll()
            .anyRequest().authenticated().and()
            .addFilter(new JwtAuthenticationFilter(authenticationManager(), resolverFactory))
            .addFilter(new JwtAuthorizationFilter(authenticationManager())).sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
        providerFactory.getAuthenticationProviders().forEach(auth::authenticationProvider);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

        return source;
    }
}
