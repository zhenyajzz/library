package io.web.library.controller;

import io.web.library.model.User;
import io.web.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> listUsers = userService.searchUsers();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/user-delete/{id}")
    public String removeUserById(@PathVariable Long id){

        userService.deleteUser(id);

        return "redirect:/users";
    }
}
