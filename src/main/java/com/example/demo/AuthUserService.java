package com.example.demo;


import java.util.List;
import java.util.Optional;

public interface AuthUserService {
    List<AuthUser> getAllUsers();
    Optional<AuthUser> getUserById(Long id);
    AuthUser createUser(AuthUser user);
    AuthUser updateUser(Long id, AuthUser user);
    boolean deleteUser(Long id);
    Optional<AuthUser> findByMail(String email);
}