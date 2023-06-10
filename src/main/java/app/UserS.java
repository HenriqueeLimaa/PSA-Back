package app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Cargo c;

    public enum Cargo{
        GERENTE, FUNCIONARIO;
    }

    public UserS(String name, String c) {
        this.name = name;
        if(c.equals("GERENTE"))
        this.c = Cargo.GERENTE;
        if(c.equals("FUNCIONARIO"))
        this.c = Cargo.FUNCIONARIO;
    }

    public String toString(){
        return id + "\n Nome: " + name + "\n Cargo: " + c;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cargo getCargo(){
        return c;
    }

}
