package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @GetMapping
    public ResponseEntity<List<AuthUser>> getAllAuthUsers() {
        List<AuthUser> AuthUsers = authUserService.getAllUsers();
        return new ResponseEntity<>(AuthUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthUser> getAuthUserById(@PathVariable("id") Long id) {
        Optional<AuthUser> optionalAuthUser = authUserService.getUserById(id);
        if (optionalAuthUser.isPresent()) {
            return new ResponseEntity<>(optionalAuthUser.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<AuthUser> createAuthUser(@RequestBody AuthUser AuthUser) {
        AuthUser createdAuthUser = authUserService.createUser(AuthUser);
        if (createdAuthUser != null) {
            return new ResponseEntity<>(createdAuthUser, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthUser> updateAuthUser(@PathVariable("id") Long id, @RequestBody AuthUser AuthUser) {
        AuthUser updatedAuthUser = authUserService.updateUser(id, AuthUser);
        if (updatedAuthUser != null) {
            return new ResponseEntity<>(updatedAuthUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthUser(@PathVariable("id") Long id) {
        boolean deleted = authUserService.deleteUser(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
	@GetMapping("/user")
	public String getUser() {
		return "Welcome, User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Welcome, Admin";
	}
    
	
    @GetMapping("/email/{email}")
    public ResponseEntity<AuthUser> getUserByEmail(@PathVariable String email) {
        return authUserService.findByMail(email)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}