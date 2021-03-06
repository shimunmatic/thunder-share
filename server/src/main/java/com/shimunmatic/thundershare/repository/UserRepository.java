package com.shimunmatic.thundershare.repository;

import com.shimunmatic.thundershare.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserNameEquals(String username);

    User findByEmailEquals(String email);
}
