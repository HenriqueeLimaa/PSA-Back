package app;


import app.model.RefundRequest;
import app.model.UserDto;
import app.repository.RefundRepository;
import app.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner{

    private final UsersRepository ur;

    private final RefundRepository rr;

    public DatabaseLoader(UsersRepository ur, RefundRepository rr){
        this.ur = ur;
        this.rr = rr;
    }


    @Override
    public void run(String... strings) throws Exception{
        this.ur.save(new UserDto("Iago", "iago", "123456", "FUNCIONARIO"));
        this.ur.save(new UserDto("Henrique", "henrique", "1234", "GERENTE"));
        this.ur.save(new UserDto("Eduardo", "edu", "123", "FUNCIONARIO"));
        

        this.rr.save(new RefundRequest("Teste", 250, "12-06-2023", 1, "ACEITO"));
        this.rr.save(new RefundRequest("Teste 2", 250, "13-06-2023", 3, "RECUSADO"));
        this.rr.save(new RefundRequest("Teste 3", 250, "12-06-2023", 3, "ACEITO"));
        this.rr.save(new RefundRequest("Teste 4", 250, "12-06-2023", 1, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 5", 250, "13-06-2023", 3, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 6", 250, "12-06-2023", 3, "PENDENTE"));

    }

}
