package com.shimunmatic.thundershare.configuration.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shimunmatic.thundershare.configuration.auth.SecurityConstants;
import com.shimunmatic.thundershare.configuration.auth.resolver.AuthenticationResolver;
import com.shimunmatic.thundershare.configuration.auth.resolver.AuthenticationResolverFactory;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationResolverFactory authenticationResolverFactory;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
                                   AuthenticationResolverFactory authenticationResolverFactory) {
        this.authenticationManager = authenticationManager;
        this.authenticationResolverFactory = authenticationResolverFactory;

        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            UserCredentials credentials = new ObjectMapper().readValue(body, UserCredentials.class);

            AuthenticationResolver resolver = authenticationResolverFactory.findResolver(credentials);

            return authenticationManager.authenticate(resolver.resolve(credentials));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return authenticationManager.authenticate(null);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain filterChain, Authentication authentication) {
        var user = String.valueOf(authentication.getPrincipal());

        var roles = authentication.getAuthorities();

        var signingKey = SecurityConstants.JWT_SECRET.getBytes();

        var token = Jwts.builder().signWith(Keys.hmacShaKeyFor(signingKey), SignatureAlgorithm.HS512)
                        .setHeaderParam("typ", SecurityConstants.TOKEN_TYPE).setIssuer(SecurityConstants.TOKEN_ISSUER)
                        .setAudience(SecurityConstants.TOKEN_AUDIENCE).setSubject(user)
                        .setExpiration(new Date(System.currentTimeMillis() + 864000000)).claim("rol", roles).compact();

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
    }
}
