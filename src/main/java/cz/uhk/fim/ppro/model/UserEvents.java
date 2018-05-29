package cz.uhk.fim.ppro.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "User_Events", catalog = "ticketLon")
public class UserEvents {

    private Integer idUserEvents;
    private User user;
    private Event event;
    private int numberOfTickets;

    public UserEvents() {
    }

    public UserEvents(Integer idUserEvents, User user, Event event, int numberOfTickets) {
        this.idUserEvents = idUserEvents;
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idUserEvents", unique = true, nullable = false)
    public Integer getIdUserEvents() {
        return idUserEvents;
    }

    public void setIdUserEvents(Integer idUserEvents) {
        this.idUserEvents = idUserEvents;
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
}
