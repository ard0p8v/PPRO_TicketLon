package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.model.EventType;
import cz.uhk.fim.ppro.service.IEventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EventTypeServiceImpl extends GeneralServiceImpl<EventType, Integer> implements IEventTypeService {

    @Autowired
    public EventTypeServiceImpl(@Qualifier("eventTypeDaoImpl") IGeneralDao<EventType, Integer> generalDao) {
        super(generalDao);
    }
}
