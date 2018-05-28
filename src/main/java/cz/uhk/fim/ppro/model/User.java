package cz.uhk.fim.ppro.model;

import java.util.HashSet;
import java.util.Set;

public class User implements java.io.Serializable {

    private Integer idUser;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;
    private Set<Event> events = new HashSet<Event>();

    public User() {
    }

    public User(Integer idUser, String username, String password, String name, String surname, Role role, Set<Event> events) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.events = events;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}


