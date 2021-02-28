package com.example.itstep.ageev.springsecuritydemo.security;


import com.example.itstep.ageev.springsecuritydemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
private UserService userService;

@Autowired
public SecurityConfig(UserService userService){
    this.userService = userService;
}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //настройка прав доступа и действий авторизации
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/notes/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout()
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .and()
                .exceptionHandling().accessDeniedPage("/login?denied")
                .and()
                .csrf().disable()
        ;
    }

    //AuthenticationManagerBuilder - управляет всеми процессами авторизации
    //настройка хранения информации о пользователях
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserDetails user1 = User
//                .builder()
//                .username("user")
//                .password(bCryptPasswordEncoder().encode("user"))
//                .roles("USER")
//                .build();
//        UserDetails user2 = User
//                .builder()
//                .username("admin")
//                .password(bCryptPasswordEncoder().encode("admin"))
//                .roles("ADMIN")
//                .build();
//
//        auth.inMemoryAuthentication()
//                .withUser(user1)
//                .withUser(user2);
//    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //предоставляет данные об авторизации
        var daoAuthProvider = new DaoAuthenticationProvider();
        //UserDetails  - пользователь понятный стрингу

        //UserDetailsService - сервис который ищет и знает где искать пользователей
        daoAuthProvider.setUserDetailsService(userService);

//        auth.authenticationProvider(daoAuthProvider);
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
