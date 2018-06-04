package cz.uhk.fim.ppro.dao;

import cz.uhk.fim.ppro.model.Event;

import java.util.List;

public interface IEventDao extends IGeneralDao<Event, Integer> {

    /**
     * Method finds all events in DB
     * @return return collection of found {@link Event}
     */
    public List<Event> findAllEvents();

    /**
     * Method finds all corresponding id of events
     * @param id whole or partial event name
     * @return returns collection of string
     */
    public List<String> findEventId(int id);

    /**
     * Method finds all event with corresponding name
     * @param title whole or partial event name
     * @return returns collection of found {@link Event}
     */
    public List<Event> findEventsByName(String title);

}
