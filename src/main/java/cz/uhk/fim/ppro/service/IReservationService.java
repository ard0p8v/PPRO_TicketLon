package cz.uhk.fim.ppro.service;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.model.User;

import java.util.List;

public interface IReservationService extends IGeneralService<Reservation, Integer> {

    /**
     * Method finds all reservations with corresponding user
     * @param idUser unique identifier of User
     * @return returns collection of {@link Reservation}
     */
    public List<Reservation> getReservationsByUser(int idUser);

    public List<Event> getEventByReservation(int idEvent);
}
