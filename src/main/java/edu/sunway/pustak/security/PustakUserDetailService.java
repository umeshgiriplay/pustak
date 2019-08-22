package edu.sunway.pustak.security;

import edu.sunway.pustak.enums.UserStatus;
import edu.sunway.pustak.repositories.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class PustakUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public PustakUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        edu.sunway.pustak.entity.User user = getUser(username);
        return new User(username, user.getPassword(), (user.getStatus() == UserStatus.ACTIVE), true, true, true, Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString())));
    }
    private edu.sunway.pustak.entity.User getUser(String username) {
        return userRepository.findByUsername(username);
    }

}
