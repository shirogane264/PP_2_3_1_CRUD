package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersALL(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/user")
    public String usersId(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "user";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";

    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit")
    public String updateUser(@RequestParam("id") long id, Model model) {
        model.addAttribute(userService.getUserId(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }
}


