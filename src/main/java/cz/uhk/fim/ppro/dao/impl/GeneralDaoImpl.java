package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public abstract class GeneralDaoImpl<T, PK extends Serializable> implements IGeneralDao<T, PK> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<? extends T> entityClass;

    private Logger logger;

    public GeneralDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class<? extends T>) pt.getActualTypeArguments()[0];
        this.logger = LoggerFactory.getLogger(entityClass.getClass());
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public PK create(T t) {
        logger.info(entityClass.getName() + "succesfuly create");
        return (PK) currentSession().save(t);

    }

    @Override
    public T read(PK id) {
        return (T) currentSession().get(entityClass, id);
    }

    @Override
    public void update(T t) {
        currentSession().saveOrUpdate(t);
    }

    @Override
    public void delete(T t) {
        logger.info(entityClass.getName() + "succesfuly deleted");
        currentSession().delete(t);

    }

    @Override
    public List<T> getAll() {
        logger.info(entityClass.getName() + "blalkfaskddklsfkl");
        return currentSession().createCriteria(entityClass).list();
    }

    @Override
    public void createOrUpdate(T t) {
        currentSession().saveOrUpdate(t);
    }
}
