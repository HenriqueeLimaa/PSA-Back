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
    private String role;


    protected UserS(){}

    public UserS(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString(){
        return "user{" +
                "\nid=" + id +
                "\nname=" + name +
                "\nrole=" + role +
                "\n}";
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

    public String getRole(){
        return role;
    }

}
