package cz.uhk.fim.ppro.ticketLon;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

public interface TicketLon {

    /**
     * Retrieve all <code>User</code>s from the data store.
     */
    Collection<User> getUsers() throws DataAccessException;

    Collection<EventType> getEventTypes() throws DataAccessException;

    Collection<Place> getPlaceTypes() throws DataAccessException;

    Collection<Event> getEvents() throws DataAccessException;

    Collection<News> getNews() throws DataAccessException;

    Collection<Place> getPlaces() throws DataAccessException;

    Collection<UserEvents> getReservations() throws DataAccessException;

    /**
     * Retrieve from the data store by last name,
     * returning all users whose last name <i>starts</i> with the given name.
     */
    Collection<User> findUsers(String lastName) throws DataAccessException;

    /**
     * Retrieve from the data store by id.
     */
    User loadUser(int id) throws DataAccessException;

    Event loadEvent(int id) throws DataAccessException;

    Place loadPlace(int id) throws DataAccessException;

    News loadNews(int id) throws DataAccessException;

    /**
     * Save to the data store, either inserting or updating it.
     */
    void storeUser(User user) throws DataAccessException;

    void storeEvent(Event event) throws DataAccessException;

    void storeNews(News news) throws DataAccessException;

    void storePlace(Place place) throws DataAccessException;

    /**
     * Deletes from the data store.
     */
    void deleteUser(int id) throws DataAccessException;

    void deleteEvent(int id) throws DataAccessException;

    void deletePlace(int id) throws DataAccessException;

    void deleteNew(int id) throws DataAccessException;

}
