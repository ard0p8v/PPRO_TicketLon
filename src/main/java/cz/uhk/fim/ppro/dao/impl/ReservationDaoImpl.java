package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IReservationDao;
import cz.uhk.fim.ppro.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDaoImpl extends GeneralDaoImpl<Event, Integer> implements IReservationDao {
}
