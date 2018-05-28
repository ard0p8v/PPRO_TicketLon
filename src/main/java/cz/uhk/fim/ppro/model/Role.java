package cz.uhk.fim.ppro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Role", catalog = "ticketLon", uniqueConstraints = @UniqueConstraint(columnNames = "roleName"))
public class Role implements java.io.Serializable {

    private Integer idRole;
    private String roleName;
    private String description;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, String description, Set<User> users) {
        this.roleName = roleName;
        this.description = description;
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idRole", unique = true, nullable = false)
    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @Column(name = "roleName", unique = true, nullable = false, length = 100)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Role_has_User", catalog = "ticketLon", joinColumns = {
            @JoinColumn(name = "Role_idRole", nullable = false, updatable = false) }, inverseJoinColumns = {
            @JoinColumn(name = "User_idUser", nullable = false, updatable = false) })
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        if(roleName.length()>5) {
            String role = roleName.substring(5, roleName.length());
            return role.charAt(0) + role.substring(1, role.length()).toLowerCase();
        } else return "";
    }
}
