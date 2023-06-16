package com.example.spring_boot.controller;

import com.example.spring_boot.model.User;
import com.example.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String updateUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }


    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }
    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }


    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}