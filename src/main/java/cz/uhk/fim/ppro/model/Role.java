package cz.uhk.fim.ppro.model;

import java.util.HashSet;
import java.util.Set;

public class Role implements java.io.Serializable {

    private Integer idRole;
    private String roleName;
    private String description;
    private Set<User> users = new HashSet<User>();

    public Role() {
    }

    public Role(Integer idRole, String roleName, String description, Set<User> users) {
        this.idRole = idRole;
        this.roleName = roleName;
        this.description = description;
        this.users = users;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
