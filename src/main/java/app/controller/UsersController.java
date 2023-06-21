package app.controller;

import app.services.UserService;
import app.repository.UsersRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
class UsersController {
    private final UsersRepository ur;

    UsersController(UsersRepository ur){
        this.ur = ur;
    }

    @PostMapping("/userServices")
    UserService newUserS(@RequestBody UserService newUserS){
        UserService u1 = new UserService(newUserS.getName(), newUserS.getRole(), newUserS.getUsername(), newUserS.getPassword());
        System.out.println("Entrou controller" + newUserS.toString());
        return ur.save(u1);
        
    }
}
