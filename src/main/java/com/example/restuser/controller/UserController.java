package com.example.restuser.controller;

import com.example.restuser.dto.UserDto;
import com.example.restuser.entity.User;
import com.example.restuser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void updateUser(@ModelAttribute("users") UserDto userDto) {
        userService.saveUser(userDto);
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.findAll();
    }

    @PutMapping("/user")
    public void saveUser(@RequestBody UserDto userDto) {
        userDto.setId(0L);
        userService.saveUser(userDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
}
