package edu.sunway.pustak.security;

import edu.sunway.pustak.dto.UserDTO;
import edu.sunway.pustak.enums.UserStatus;
import edu.sunway.pustak.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = getUser(username);
        return new User(username, user.getPassword(), (user.getStatus() == UserStatus.ACTIVE), true, true, true, Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
    }
    private UserDTO getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
