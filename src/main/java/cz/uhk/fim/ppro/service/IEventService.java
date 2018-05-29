package cz.uhk.fim.ppro.service;

import cz.uhk.fim.ppro.model.Event;

import java.util.List;

public interface IEventService {

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
    public List<String> getEventNames(String title);

    /**
     * Method finds events by name
     * @param title partial or whole name
     * @return returns collection of {@link Event}
     */
    public List<Event> getEventsByName(String title);

    /**
     * Method finds all events for user with corresponding identifier
     * @param idUser unique identifier of User
     * @return returns collection of {@link Event}
     */
    public List<Event> getEventsByUser(int idUser);
}