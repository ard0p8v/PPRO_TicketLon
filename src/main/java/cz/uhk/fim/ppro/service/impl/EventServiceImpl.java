package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IEventDao;
import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl extends GeneralServiceImpl<Event, Integer> implements IEventService {

    @Autowired
    private IEventDao eventDao;

    @Autowired
    public EventServiceImpl(@Qualifier("eventDaoImpl") IGeneralDao<Event, Integer> generalDao) {
        super(generalDao);
    }

    //read and update method impl

    @Override
    public List<Event> findAllEvents() {
        return eventDao.findAllEvents();
    }

    @Override
    public List<Event> findEventId(int id) {
        return eventDao.findEventId(id);
    }

    @Override
    public List<Event> getEventsByName(String title) {
        return eventDao.findEventsByName(title);
    }

}
