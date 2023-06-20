package app.services;


import app.UserDto;
import app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class UserService implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String role;
    private String password;
    @Column(unique = true) // Specify the column mapping
    private String username;


    public UserService(){}

    public UserService(String name, String role) {
        System.out.println(role);
              System.out.println(name);
        this.name = name;
        if(role.equals("FUNCIONARIO")) {
        this.role = role;
        } else if(role.equals("GERENTE")) {
        this.role = role;
        } else {
            throw new IllegalArgumentException("Invalid role");
        }
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signup(UserDto userDto) {
        UserService user = new UserService(userDto.getName(), userDto.getRole());
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        usersRepository.save(user);
    }

    public void setPassword(String encode) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDto toUserDto() {
        return new UserDto(name, role, password, username);
    }


    public void setRole(String role) {
        this.role = role;
    }



}
