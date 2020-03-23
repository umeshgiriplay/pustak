package edu.sunway.pustak.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Authentication {

    public static String getCurrentUsername() {

        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication.getPrincipal() instanceof User) {
                return ((User) authentication.getPrincipal()).getUsername();
            }
        }
        return null;
    }

}
