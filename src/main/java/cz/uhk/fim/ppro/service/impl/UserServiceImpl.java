package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.dao.IUserDao;
import cz.uhk.fim.ppro.model.User;
import cz.uhk.fim.ppro.service.IRoleService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GeneralServiceImpl<User, Integer> implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleService roleService;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") IGeneralDao<User, Integer> generalDao) {
        super(generalDao);
    }

    @Override
    public Integer create(User user) {
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());
        return userDao.create(user);
    }

    @Override
    public void update(User user) {
        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setRole(user.getRole());
        user.setPassword(user.getPassword());
        userDao.update(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAllManagersAndAdmins() {
        return userDao.findAllManagersAndAdmins();
    }
}
