package cz.uhk.fim.ppro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "User", catalog = "ticketLon", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {

    private Integer idUser;
    private String username;
    private String password;
    private String name;
    private String surname;
    private Role role;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String name, String surname, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idUser", unique = true, nullable = false)
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Column(name = "username", unique = true, nullable = false, length = 200)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", length = 100)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "Role_has_User", catalog = "ticketLon", joinColumns = {
            @JoinColumn(name = "User_idUser", nullable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "Role_idRole", nullable = false) })
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}


