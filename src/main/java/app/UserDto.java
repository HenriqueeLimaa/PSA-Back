package app;

import app.services.UserService;

public class UserDto {

    private String name;
    private String[] role;
    private String password;
    private String username;

    public UserDto() {
    }

    public UserDto(String name, String password, String username, String... role) {
        this.name = name;
        this.role = role;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String[] getRole() {
        return role;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String[] role) {
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
