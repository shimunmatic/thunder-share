package com.shimunmatic.thundershare.service.implementation;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.repository.UserRepository;
import com.shimunmatic.thundershare.service.AbstractService;
import com.shimunmatic.thundershare.service.UserService;
import com.shimunmatic.thundershare.util.auth.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUserNameEquals(username);
    }

    @Override
    public boolean checkCredentials(UserCredentials userCredentials) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = getByUsername(s);
        if (u == null) { return null; }
        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.emptyList();
            }

            @Override
            public String getPassword() {
                return u.getPassword();
            }

            @Override
            public String getUsername() {
                return u.getUserName();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
