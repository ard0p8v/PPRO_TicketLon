package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IEventDao;
import cz.uhk.fim.ppro.model.Event;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDaoImpl extends GeneralDaoImpl<Event, Integer> implements IEventDao{

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> findAllEvents() {
        Criteria c = currentSession().createCriteria(Event.class);
        return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> findEventId(int idEvent) {
        Criteria c = currentSession().createCriteria(Event.class);
        return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> findEventsByName(String title) {
        Criteria c = currentSession().createCriteria(Event.class);
        if(title != null) {
            c.add(Restrictions.ilike("title", title, MatchMode.ANYWHERE));
        }
        return c.list();
    }
}
