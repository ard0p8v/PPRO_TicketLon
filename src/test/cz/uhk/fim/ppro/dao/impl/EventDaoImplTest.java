package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IEventDao;
import cz.uhk.fim.ppro.model.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-context.xml"})
public class EventDaoImplTest {

    @Autowired
    private IEventDao eventDao;

    @Test
    public void findAllEvents() {
        List<Event> events = eventDao.findAllEvents();
        assertTrue(!events.isEmpty());
    }

    @Test
    public void findEventId() {
        List<Event> events = eventDao.findEventId(1);
        assertTrue(!events.isEmpty());
    }

    @Test
    public void findEventsByName() {
        List<Event> events = eventDao.findEventsByName(null);
        assertTrue(!events.isEmpty());

        events = eventDao.findEventsByName("hokej");
        assertTrue(!events.isEmpty());

        events = eventDao.findEventsByName("fotbal");
        assertTrue(events.isEmpty());
    }

}