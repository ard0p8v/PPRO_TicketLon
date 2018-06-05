package cz.uhk.fim.ppro.dao;

import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Reservation;

import java.util.List;

public interface IReservationDao extends IGeneralDao<Reservation, Integer> {

    /**
     * Method finds all reservation for user with corresponding identifier
     * @param idUser unique identifier of User
     * @return returns collection of {@link Reservation}
     */
    public List<Reservation> getReservationsByUser(int idUser);
}
