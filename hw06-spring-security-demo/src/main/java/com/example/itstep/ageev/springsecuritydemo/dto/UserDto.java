package com.example.itstep.ageev.springsecuritydemo.dto;

import com.example.itstep.ageev.springsecuritydemo.validation.PasswordMatches;
import com.example.itstep.ageev.springsecuritydemo.validation.ValidEmail;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    String username;

    @NotNull
    @NotEmpty
    String password;

    @NotNull
    @NotEmpty
    String passwordConfirm;

    @ValidEmail
    @NotNull
    @NotEmpty
    String email;
}
