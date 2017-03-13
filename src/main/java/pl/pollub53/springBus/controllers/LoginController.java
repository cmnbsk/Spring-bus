package pl.pollub53.springBus.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.pollub53.springBus.LoginForm;
import pl.pollub53.springBus.domain.User;
import pl.pollub53.springBus.services.UserService;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(LoginForm loginForm) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "/login";
        }

//        if (!userService.authenticate(
//                loginForm.getUsername(), loginForm.getPassword())) {
//
//            return "/login";
//        }


        return "redirect:/";
    }

    @RequestMapping(value = "/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";

    }

    @PostMapping(value = "/saveuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }
}
