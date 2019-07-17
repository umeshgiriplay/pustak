package edu.sunway.pustak.entity;


import edu.sunway.pustak.enums.Roles;
import edu.sunway.pustak.enums.UserStatus;
import jdk.net.SocketFlow;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String userName;

    private String password;

    private UserStatus status;

    private Roles role;

    public User()
    {
        super();
    }

    public User(String name)
    {
        super();
        this.name=name;
    }
    public User(Long id,String name)
    {
        super();
        this.id = id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
