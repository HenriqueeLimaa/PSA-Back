package app.services;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.model.UserDto;
import java.util.Collection;

public class UserService implements UserDetails {

    private long id;
    private String name;
    private String role;
    @JsonIgnore
    private String password;
    private String username;

    
    public UserService(){}


    public UserService(String name, String username, String password, String role) {
        System.out.println(role);
              System.out.println(name);
        this.name = name;
        this.role = role;
        this.username = username;
        this.setPassword(password);
    }

    @Override
    public String toString(){
        return "user{" +
                "\nid=" + id +
                "\nname=" + name +
                "\nrole=" + role +
                "\n}";
    }

    public long getId() {
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

    public static UserService build(UserDto user) {

    return new UserService(    user.getName(),
                               user.getUsername(),
                               user.getPassword(), 
                               user.getRole());
  }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    

    public void signup(UserDto userDto) {
        UserService user = new UserService(userDto.getName(), userDto.getUsername(), userDto.getPassword(), userDto.getRole());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
    }

    public void setPassword(String password) { 
		this.password = PASSWORD_ENCODER.encode(password);
	}

    public void setUsername(String username) {
        this.username = username;
    }

    public UserDto toUserDto() {
        return new UserDto(name, password, username, role);
    }


    public void setRole(String role) {
        this.role = role;
    }



}
