package ru.mlg.probe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mlg.probe.entity.User;
import ru.mlg.probe.service.UserService;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> userByName(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (name.isEmpty()) return userService.findAll();
        else return userService.findAllByName(name);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody() User user) {
        return userService.createUser(user);
    }
}
