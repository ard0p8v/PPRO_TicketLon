package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IEventTypeDao;
import cz.uhk.fim.ppro.model.EventType;
import org.springframework.stereotype.Repository;

@Repository
public class EventTypeDaoImpl extends GeneralDaoImpl<EventType, Integer> implements IEventTypeDao {
}
