package com.maxdegree.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long userId;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Placement> places;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }
    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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



    public List<Placement> getPlaces() {
        return places;
    }

    public void setPlaces(List<Placement> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "User{userID=" + userId + "Login=" + login + ", password=" + password + ", email=" +email + "places SIZE=" + places.size() + "}";
    }
}
