package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IUserDao;
import cz.uhk.fim.ppro.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl extends GeneralDaoImpl<User, Integer> implements IUserDao {

    @Override
    public User findByUsername(String username) {
        Criteria c = currentSession().createCriteria(User.class);
        c.add(Restrictions.eq("username", username));
        return (User)c.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllManagersAndAdmins() {
        List<String> names = new ArrayList<String>();
        names.add("ROLE_ADMIN");
        names.add("ROLE_MANAGER");

        Criteria c = currentSession().createCriteria(User.class);
//		c.add(Restrictions.in("roles.name", names));
        return c.list();
    }
}
