package org.mannayakasha.security;

import java.util.Collections;

import org.mannayakasha.entity.User;
//import org.mannayakasha.entity.UserService;
import org.mannayakasha.service.interfaces.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserDetailService implements UserDetailsService {

    private final IUserService userService;

    public AppUserDetailService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public final UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        final User user = this.userService.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return org.springframework.security.core.userdetails.User.withUsername(username)
                .password(user.getPassword()).authorities(Collections.emptyList())
                .accountExpired(false).accountLocked(false).credentialsExpired(false)
                .disabled(false).build();
    }

}