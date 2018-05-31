package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.dao.IReservationDao;
import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IReservationService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReservationServiceImpl extends GeneralServiceImpl<Reservation, Integer> implements IReservationService {

    @Autowired
    private IReservationDao reservationDao;

    @Autowired
    private IEventService eventService;

    @Autowired
    private IUserService userService;

    @Autowired
    public ReservationServiceImpl(@Qualifier("reservationDaoImpl") IGeneralDao<Reservation, Integer> generalDao) {
        super(generalDao);
    }

    @Override
    public Integer create(Reservation reservation) {
        //reservation.setEvent(eventService.read(reservation.getEvent().getIdEvent()));
        //reservation.setUser(userService.read(reservation.getUser().getIdUser()));
        reservation.setAdded(new Date());
        reservation.setEvent(eventService.read(2));
        reservation.setUser(userService.read(1));

        return reservationDao.create(reservation);
    }


}
