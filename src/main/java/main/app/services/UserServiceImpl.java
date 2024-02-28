package main.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import main.app.dto.UserDto;
import main.app.entities.UserDb;
import main.app.mapper.UserMapper;
import main.app.repository.UserRepository;






@Configuration
@Service
public class UserServiceImpl implements  UserDetailsService ,UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserDb createUser(UserDto userDto) {
        UserDb user = UserMapper.INSTANCE.toUser(userDto);
        return userRepository.save(user);
    }

    public UserDb getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserDb> getAllUsers() {
        return userRepository.findAll();
    }
    

    public UserDb updateUser(Long id, UserDto userDto) {
        UserDb existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            return null; // Gérer le cas où l'utilisateur n'existe pas
        }
        // Mettre à jour les champs de l'utilisateur existant avec les données du DTO
        existingUser.setFirstname(userDto.getFirstName());
        existingUser.setUserName(userDto.getUserName());
        existingUser.setLogin(userDto.getLogin());
        existingUser.setRole(userDto.getRole());
        // Ne pas oublier de gérer le champ "token" si nécessaire
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDb findbyUserName(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username);
	}


	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDb user = userRepository.findByUserName(username);
		
		return new User(user.getUserName(), user.getPassword(), getGrantedAuthorities(user.getRole()));
	}

	private List<GrantedAuthority> getGrantedAuthorities(String role) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		return authorities;
	}




}
