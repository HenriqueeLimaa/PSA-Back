package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Welcome to the admin dashboard!";
    }
}

//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @GetMapping("/profile")
//    public String userProfile() {
//        return "User profile page";
//    }
//}
