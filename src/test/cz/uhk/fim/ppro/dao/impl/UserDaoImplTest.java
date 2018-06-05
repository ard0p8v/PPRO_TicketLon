package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IUserDao;
import cz.uhk.fim.ppro.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-context.xml"})
public class UserDaoImplTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void findByUsername() {
        User u = userDao.findByUsername(null);
        assertTrue(u == null);

        u = userDao.findByUsername("adminHonza");
        assertTrue(u.getRole().getRoleName().equals("ROLE_ADMIN"));
    }

    @Test
    public void findAllManagersAndAdmins() {
        List<User> users = userDao.findAllManagersAndAdmins();
        assertTrue(!users.isEmpty());
    }
}