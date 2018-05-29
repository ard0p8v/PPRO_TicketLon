package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.Role;
import cz.uhk.fim.ppro.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GeneralServiceImpl<Role, Integer> implements IRoleService {

    @Autowired
    public RoleServiceImpl(@Qualifier("roleDaoImpl") IGeneralDao<Role, Integer> generalDao) {
        super(generalDao);
    }
}
