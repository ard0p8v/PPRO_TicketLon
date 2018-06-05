package cz.uhk.fim.ppro.service;

import cz.uhk.fim.ppro.model.Event;

import java.util.List;

public interface IEventService extends IGeneralService<Event, Integer> {

    /**
     * Method which finds all events
     * @return list of found Events
     */
    public List<Event> findAllEvents();

    /**
     * Method finds names of events with corresponding name
     * @param title whole or partial name of events
     * @return returns collection of String
     */
    public List<Event> findEventId(int id);

    /**
     * Method finds events by name
     * @param title partial or whole name
     * @return returns collection of {@link Event}
     */
    public List<Event> getEventsByName(String title);

}
