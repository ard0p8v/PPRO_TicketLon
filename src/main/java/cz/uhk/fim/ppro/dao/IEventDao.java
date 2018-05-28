package cz.uhk.fim.ppro.dao;

import cz.uhk.fim.ppro.model.Event;

import java.util.List;

public interface IEventDao extends IGeneralDao<Event, Integer> {

    /**
     * Method finds all active events in DB
     * @return return collection of found {@link Event}
     */
    public List<Event> findAllEvents();

    /**
     * Method finds all corresponding names of events
     * @param title whole or partial event name
     * @return returns collection of string
     */
    public List<String> findEventNames(String title);

    /**
     * Method finds all event with corresponding name
     * @param title whole or partial event name
     * @return returns collection of found {@link Event}
     */
    public List<Event> findEventByName(String title);

    /**
     * Method finds all events for user with id
     * @param idUser unique identifier of User
     * @return returns collection of {@link Event}
     */
    public List<Event> findEventByUser(int idUser);
}
