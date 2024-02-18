/**
 * 
 */
package com.example.demo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository AuthUserRepository;

    @Override
    public List<AuthUser> getAllUsers() {
        return AuthUserRepository.findAll();
    }

    @Override
    public Optional<AuthUser> getUserById(Long id) {
        return AuthUserRepository.findById(id);
    }

    @Override
    public AuthUser createUser(AuthUser user) {
        return AuthUserRepository.save(user);
    }

    @Override
    public AuthUser updateUser(Long id, AuthUser user) {
        Optional<AuthUser> existingUserOptional = AuthUserRepository.findById(id);
        if (existingUserOptional.isPresent()) {
        	AuthUser existingUser = existingUserOptional.get();
            existingUser.setMail(null);
            existingUser.setPassword(user.getPassword());
            return AuthUserRepository.save(existingUser);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        if (AuthUserRepository.existsById(id)) {
        	AuthUserRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
  
    
    @Override
    public Optional<AuthUser> findByMail(String email) {
        return AuthUserRepository.findByMail(email);
    }
}
