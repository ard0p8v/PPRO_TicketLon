package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IUserEventsDao;
import cz.uhk.fim.ppro.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public class UserEventsDaoImpl extends GeneralDaoImpl<Event, Integer> implements IUserEventsDao{
}
