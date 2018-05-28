package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.INewsDao;
import cz.uhk.fim.ppro.model.News;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl extends GeneralDaoImpl<News, Integer> implements INewsDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<News> findAllNews() {
        Criteria c = currentSession().createCriteria(News.class);
        return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> findNewsName(String name) {
        Criteria c = currentSession().createCriteria(News.class);
        if(name != null) {
            c.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        }
        c.setProjection(Projections.property("name"));
        return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<News> findNewsByName(String name) {
        Criteria c = currentSession().createCriteria(News.class);
        if(name != null) {
            c.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        }
        return c.list();
    }
}
