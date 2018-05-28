package cz.uhk.fim.ppro.dao;

import cz.uhk.fim.ppro.model.User;

import java.util.List;

public interface IUserDao extends IGeneralDao<User, Integer> {

    /**
     * Method finds user by his username
     * @param username
     * @return returns {@link User} object
     */
    public User findByUsername(String username);

    /**
     * Method finds all users with role Admin and Manager
     * @return returns collection of {@link User} objects
     */
    public List<User> findAllManagersAndAdmins();
}
