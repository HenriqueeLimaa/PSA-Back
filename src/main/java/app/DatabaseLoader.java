package app;


import app.repository.RefundRepository;
import app.repository.UsersRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner{

    private final UsersRepository ur;

    private final RefundRepository rr;

    @Autowired
    public DatabaseLoader(UsersRepository ur, RefundRepository rr){
        this.ur = ur;
        this.rr = rr;
    }


    @Override
    public void run(String... strings) throws Exception{
        this.ur.save(new UserService("Iago", "FUNCIONARIO", "iago", "123456"));
        this.ur.save(new UserService("Henrique", "GERENTE", "henrique", "1234"));
        this.ur.save(new UserService("Eduardo", "FUNCIONARIO", "edu", "123"));
        

        this.rr.save(new RefundRequest("Teste", 250, "12-06-2023", 1, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 2", 250, "13-06-2023", 3, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 3", 250, "12-06-2023", 3, "PENDENTE"));

    }

}
