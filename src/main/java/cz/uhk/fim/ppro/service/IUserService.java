package cz.uhk.fim.ppro.service;

import cz.uhk.fim.ppro.model.User;

import java.util.List;

public interface IUserService extends IGeneralService<User, Integer> {

    /**
     * Method finds user by his username
     * @param username
     * @return returns {@link User} object
     */
    public User findByUsername(String username);

    /**
     * Method finds all user with ADMIN or MANAGER role
     * @return returns collection of {@link User} objects
     */
    public List<User> findAllManagersAndAdmins();
}
