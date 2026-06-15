package com.minicodejudge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.minicodejudge.entity.User;
import com.minicodejudge.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterPage(Model model) {

        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "redirect:/users";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "users";
    }
    @GetMapping("/login")
    public String login() {
    	return "login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}