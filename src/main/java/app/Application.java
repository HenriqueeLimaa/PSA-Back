package app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Application implements CommandLineRunner{

    private final UsersRepository ur;

    private final RefundRepository rr;

    @Autowired
    public Application(UsersRepository ur, RefundRepository rr){
        this.ur = ur;
        this.rr = rr;
    }


    @Override
    public void run(String... strings) throws Exception{
        this.ur.save(new UserS("Iago", "FUNCIONARIO"));
        this.ur.save(new UserS("Henrique", "GERENTE"));
        this.ur.save(new UserS("Eduardo", "FUNCIONARIO"));
        

        this.rr.save(new RefundRequest("Teste", 250, "12-06-2023", 1, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 2", 250, "13-06-2023", 3, "PENDENTE"));
        this.rr.save(new RefundRequest("Teste 3", 250, "12-06-2023", 3, "PENDENTE"));

    }

}
