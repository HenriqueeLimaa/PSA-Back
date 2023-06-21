package app.controller;

import app.UserDto;
import app.services.UserService;

import ch.qos.logback.core.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class AuthController {

    //@Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    //@Value("${cookies.domain}")
    private String domain;

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

    @PostMapping("/auth")
    public ResponseEntity<?> auth(String username, String password) {
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    username, password));

            User user = (User) authenticate.getPrincipal();
            //user.setPassword(null);

            String token = "blablablasjfkls";
            System.out.println(token);
            ResponseCookie cookie = ResponseCookie.from("jwt", token)
                    .domain(domain)
                    .path("/")
                    .maxAge(Duration.buildByDays(365).getMilliseconds())
                    .build();
            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body(token);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
