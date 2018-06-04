package cz.uhk.fim.ppro.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Reservation", catalog = "ticketLon")
public class Reservation {

    private Integer idReservation;
    private User user;
    private Event event;
    private int numberOfTickets;
    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    private Date added;

    public Reservation(){

    }

    public Reservation(Event event) {
        this.event = event;
    }

    public Reservation(Integer idReservation, User user, Event event, int numberOfTickets, Date added) {
        this.idReservation = idReservation;
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
        this.added = added;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idReservation", unique = true, nullable = false)
    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_idUser")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Event_idEvent")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Column(name = "numberOfTickets", nullable = false)
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added", nullable = false, length = 19)
    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }
}
