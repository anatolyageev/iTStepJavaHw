package com.example.itstep.ageev.springsecuritydemo.services;


import com.example.itstep.ageev.springsecuritydemo.dao.UserRepositiry;
import com.example.itstep.ageev.springsecuritydemo.domain.User;
import com.example.itstep.ageev.springsecuritydemo.dto.UserDto;
import com.example.itstep.ageev.springsecuritydemo.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    private UserRepositiry userRepositiry;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepositiry userRepositiry, PasswordEncoder passwordEncoder) {
        this.userRepositiry = userRepositiry;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerNewUser(UserDto userDto) throws UserAlreadyExistException {
        if (checkEmail(userDto.getEmail()) || checkUser(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with user name and email: " +
                    userDto.getUsername() + " / " + userDto.getEmail());
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("ROLE_USER");
        return userRepositiry.save(user);
    }

    private boolean checkEmail(String email) {
        return userRepositiry.findByEmail(email) != null;
    }

    private boolean checkUser(String username) {
        return userRepositiry.findByUsername(username) != null;
    }
}
