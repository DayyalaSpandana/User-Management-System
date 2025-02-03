package com.example.spandy.controller;

import com.example.spandy.model.User;
import com.example.spandy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController 
{
    @Autowired
    UserRepository ur;

    // Registration Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(String username, String password, String email, Model model) {
        if (ur.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }
        User user = new User();
        user.setName(username);  // Properly set username
        user.setEmail(email);
        user.setPassword(password);
        ur.save(user);
        return "registerSuccess";
    }

    // Login Page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        User user = ur.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("user", user);
            return "home";
        }
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }

    // Delete Page
    @GetMapping("/delete")
    public String deletePage() {
        return "verify";
    }

    @PostMapping("/delete")
    public String delete(String username, String password, Model model) {
        User user = ur.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            ur.delete(user);
            return "deletesuccess";
        }
        model.addAttribute("error", "Invalid credentials");
        return "verify";
    }

    // Update Page
    @GetMapping("/update")
    public String updatePage() {
        return "verifyupdate";
    }

    @PostMapping("/verifyupdate")
    public String verifyUpdate(String username, String password, Model model) {
        User user = ur.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            model.addAttribute("uname", username);
            return "update";
        }
        model.addAttribute("error", "Invalid credentials");
        return "verifyupdate";
    }
    @GetMapping("/verify")
public String verifyPage() {
    return "verify"; // Ensure the verify.html page is available
}
    @PostMapping("/update")
    public String update(String username, String email, String password, Model model) {
        User user = ur.findByUsername(username);
        if (user != null) {
            user.setEmail(email);
            user.setPassword(password);
            ur.save(user);
            return "updatesuccess";
        }
        model.addAttribute("error", "User not found");
        return "update";
    }
}
