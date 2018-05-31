package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.Type;
import cz.uhk.fim.ppro.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends GeneralServiceImpl<Type, Integer> implements ITypeService {

    @Autowired
    public TypeServiceImpl(@Qualifier("typeDaoImpl") IGeneralDao<Type, Integer> generalDao) {
        super(generalDao);
    }
}
