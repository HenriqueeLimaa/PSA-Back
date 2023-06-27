package app.model;

import app.services.UserService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String role;
    private String password;
    @Column(unique = true) // Specify the column mapping
    private String username;

    public UserDto() {
    }

    public UserDto(String name, String username, String password, String role) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserService toUserS() {
        UserService userS = new UserService();
        userS.setName(name);
        userS.setRole(role);
        userS.setPassword(password);
        userS.setUsername(username);
        return userS;
    }
}
