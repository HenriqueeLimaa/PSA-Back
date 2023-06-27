package app.controller;

import app.services.UserService;
import app.model.UserDto;
import app.repository.UsersRepository;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@RequestMapping("/api")
@RestController
class UsersController {
    
    private final UsersRepository ur;

    UsersController(UsersRepository ur){
        this.ur = ur;
    }

    @GetMapping("/userServices")
    public List<UserDto> getAll(){
        return ur.findAll();
    }

    @PostMapping("/userServices")
    UserDto newUserS(@RequestBody UserDto user){
        UserDto u1 = new UserDto(user.getName(), user.getUsername(), user.getPassword(), user.getRole());
        System.out.println("Entrou controller" + user.toString());
        return ur.save(u1); 
    }    
}
