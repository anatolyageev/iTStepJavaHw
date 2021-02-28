package com.example.itstep.ageev.springsecuritydemo.controller;

import com.example.itstep.ageev.springsecuritydemo.domain.User;
import com.example.itstep.ageev.springsecuritydemo.dto.UserDto;
import com.example.itstep.ageev.springsecuritydemo.exception.UserAlreadyExistException;
import com.example.itstep.ageev.springsecuritydemo.services.UserRegistrationService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public String admin() {
        return "admin";
    }

    @GetMapping("/login")
    public String singin() {
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model) {
        model.addAttribute("user", new UserDto());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public ModelAndView registerNewUser(@ModelAttribute("user") @Valid UserDto userDto) {
        try {
            registrationService.registerNewUser(userDto);
        } catch (UserAlreadyExistException ex) {
            ModelAndView mav = new ModelAndView("sign-up", "user", userDto);
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }
        return new ModelAndView("redirect:/login", "user", userDto);
    }

}
