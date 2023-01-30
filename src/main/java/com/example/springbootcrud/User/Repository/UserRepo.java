package com.example.springbootcrud.User.Repository;

import com.example.springbootcrud.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);

    // not optional so it can return false
    User findByEmail(String email);

    User findUserByEmail(String email);
}
