package com.example.itstep.ageev.springsecuritydemo.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {
    String username;
    String passwordOne;
    String passwordTwo;
    String role;
    String email;
}
