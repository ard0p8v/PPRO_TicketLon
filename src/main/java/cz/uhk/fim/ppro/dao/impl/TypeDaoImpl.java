package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.ITypeDao;
import cz.uhk.fim.ppro.model.Type;
import org.springframework.stereotype.Repository;

@Repository
public class TypeDaoImpl extends GeneralDaoImpl<Type, Integer> implements ITypeDao {
}
