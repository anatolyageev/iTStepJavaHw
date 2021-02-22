package com.example.itstep.ageev.springsecuritydemo.services;


import com.example.itstep.ageev.springsecuritydemo.dao.UserRepositiry;
import com.example.itstep.ageev.springsecuritydemo.domain.User;
import com.example.itstep.ageev.springsecuritydemo.domain.UserSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    private UserRepositiry userRepositiry;


    public UserService(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositiry.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("no such");
        }
        UserDetails userDetails = new UserSecurity(user);
        return userDetails;
    }
}
