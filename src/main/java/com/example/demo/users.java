package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;

@Entity
@SequenceGenerator(name="seq", initialValue=1)
public class users {
    @NotEmpty
    private String flname;
    @Id@NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String mber;
    @NotEmpty
    private String roles;

    @Override
    public String toString() {
        return "users{" +
                "flname='" + flname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mber='" + mber + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMber() {
        return mber;
    }

    public void setMber(String mber) {
        this.mber = mber;
    }
}
