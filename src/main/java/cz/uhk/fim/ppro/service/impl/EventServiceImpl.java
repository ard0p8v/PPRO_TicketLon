package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IEventDao;
import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IEventTypeService;
import cz.uhk.fim.ppro.service.IPlaceService;
import cz.uhk.fim.ppro.service.IUserService;
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
    public List<String> getEventNames(String title) {
        return eventDao.findEventNames(title);
    }

    @Override
    public List<Event> getEventsByName(String title) {
        return eventDao.findEventsByName(title);
    }

    @Override
    public List<Event> getEventsByUser(int idUser) {
        return eventDao.findEventsByUser(idUser);
    }
}
