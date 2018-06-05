package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IReservationDao;
import cz.uhk.fim.ppro.model.Event;
import cz.uhk.fim.ppro.model.Reservation;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDaoImpl extends GeneralDaoImpl<Reservation, Integer> implements IReservationDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Reservation> getReservationsByUser(int idUser) {
        Criteria c = currentSession().createCriteria(Reservation.class);
        c.add(Restrictions.eq("user.idUser", idUser));
        return c.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Event> getEventByReservation(int idEvent) {
        Criteria c = currentSession().createCriteria(Reservation.class);
        c.add(Restrictions.eq("event.idEvent", idEvent));
        return c.list();
    }


}
