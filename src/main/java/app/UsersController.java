package app;

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

    @PostMapping("/userSes")
    UserS newUserS(@RequestBody UserS newUserS){
        UserS u1 = new UserS(newUserS.getName(), newUserS.getRole());
        System.out.println("Entrou controller" + newUserS.toString());
        return ur.save(u1);
        
    }
}
