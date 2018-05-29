package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.service.IGeneralService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class GeneralServiceImpl <T, PK extends Serializable> implements IGeneralService<T, PK> {

    protected IGeneralDao<T, PK> generalDao;

    public GeneralServiceImpl(IGeneralDao<T,PK> generalDao) {
        this.generalDao=generalDao;
    }

    public GeneralServiceImpl() {
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public PK create(T t) {
        return generalDao.create(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public T read(PK id) {
        return generalDao.read(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T t) {
        generalDao.update(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(T t) {
        generalDao.delete(t);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createOrUpdate(T t) {
        generalDao.createOrUpdate(t);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> getAll() {
        return generalDao.getAll();
    }
}
