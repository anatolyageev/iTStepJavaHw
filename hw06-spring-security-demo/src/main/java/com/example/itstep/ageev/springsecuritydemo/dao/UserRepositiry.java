package com.example.itstep.ageev.springsecuritydemo.dao;

import com.example.itstep.ageev.springsecuritydemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositiry extends CrudRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);
}
