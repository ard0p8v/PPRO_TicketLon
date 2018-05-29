package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IRoleDao;
import cz.uhk.fim.ppro.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GeneralDaoImpl<Role, Integer> implements IRoleDao {
}
