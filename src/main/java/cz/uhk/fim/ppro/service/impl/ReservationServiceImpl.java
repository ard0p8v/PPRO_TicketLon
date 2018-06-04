package cz.uhk.fim.ppro.service.impl;

import cz.uhk.fim.ppro.dao.IGeneralDao;
import cz.uhk.fim.ppro.dao.IReservationDao;
import cz.uhk.fim.ppro.model.Reservation;
import cz.uhk.fim.ppro.model.User;
import cz.uhk.fim.ppro.service.IEventService;
import cz.uhk.fim.ppro.service.IReservationService;
import cz.uhk.fim.ppro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
        String s = (String)SecurityContextHolder.getContext().getAuthentication().getName();
        User u = userService.findByUsername(s);

        reservation.setUser(userService.read(u.getIdUser()));
        reservation.setAdded(new Date());
        //reservation.setEvent(eventService.read());

        return reservationDao.create(reservation);
    }


    @Override
    public List<Reservation> getReservationsByUser(int idUser) {
        return reservationDao.getReservationsByUser(idUser);
    }
}
