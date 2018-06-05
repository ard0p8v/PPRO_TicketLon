package cz.uhk.fim.ppro.dao.impl;

import cz.uhk.fim.ppro.dao.IReservationDao;
import cz.uhk.fim.ppro.model.Reservation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-context.xml"})
public class ReservationDaoImplTest {

    @Autowired
    private IReservationDao reservationDao;

    @Test
    public void getReservationsByUser() {
        List<Reservation> reservations = reservationDao.getReservationsByUser(1);
        assertTrue(!reservations.isEmpty());
    }
}