package app.controller;

import app.UserDto;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") @Valid UserService userS, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        userService.signup(userS.toUserDto());
        return "redirect:/login?signupSuccess";
    }


}
