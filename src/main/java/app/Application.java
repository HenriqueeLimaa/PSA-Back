package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {   
    SpringApplication.run(Application.class, args);
    }

    public CommandLineRunner demo(UsersRepository ur){
        return (args) ->{

        ur.save(new UserS("Iago", "FUNCIONARIO"));
        ur.save(new UserS("Henrique", "GERENTE"));
        ur.save(new UserS("Eduardo", "Funcionario"));


        log.info("All Users");
        log.info("------------------");
        for(UserS us: ur.findAll()){
            log.info(us.toString());
        }
        };
    }

}
