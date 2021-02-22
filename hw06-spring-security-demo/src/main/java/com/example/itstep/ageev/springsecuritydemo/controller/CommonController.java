package com.example.itstep.ageev.springsecuritydemo.controller;

import com.example.itstep.ageev.springsecuritydemo.domain.UserForm;
import com.example.itstep.ageev.springsecuritydemo.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {
    private UserRegistrationService registrationService;

    @Autowired
    public CommonController(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/")
    public String index(Model model, @RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        String text = "Hello 2, " + name;
        model.addAttribute("message", text);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String singin(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @PostMapping("/signup")
    public String registerNewUser(@ModelAttribute("user") UserForm user){
        System.out.println(user.getPasswordOne());
        System.out.println(user.getPasswordTwo());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        //проверить есть ликой езер
        // проверть емейл уникальный
        // если да то сохранить
        // если нет то вернуть регистрацию
        return "signup";
    }

}
