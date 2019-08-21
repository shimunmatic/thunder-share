package com.shimunmatic.thundershare.service.implementation.user;

import com.shimunmatic.thundershare.model.User;
import com.shimunmatic.thundershare.repository.UserRepository;
import com.shimunmatic.thundershare.service.definition.user.UserService;
import com.shimunmatic.thundershare.service.implementation.AbstractService;
import com.shimunmatic.thundershare.service.implementation.user.exception.EmailTakenException;
import com.shimunmatic.thundershare.service.implementation.user.exception.UsernameTakenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUserNameEquals(username);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmailEquals(email);
    }

    @Override
    public User registerUser(User user) throws UsernameTakenException, EmailTakenException {
        User u = getByUsername(user.getUserName());
        if (u != null) { throw new UsernameTakenException(); }
        u = getByEmail(user.getEmail());
        if (u != null) { throw new EmailTakenException(); }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
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
                return u.getDeleted() == null || !u.getDeleted();
            }
        };
    }
}
