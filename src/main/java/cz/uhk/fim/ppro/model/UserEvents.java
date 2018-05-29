package cz.uhk.fim.ppro.model;

import javax.persistence.*;

@Entity
@Table(name = "User_Events", catalog = "ticketLon")
public class UserEvents {

    private User user;
    private Event event;
    private int numberOfTickets;

    public UserEvents() {
    }

    public UserEvents(User user, Event event, int numberOfTickets) {
        this.user = user;
        this.event = event;
        this.numberOfTickets = numberOfTickets;
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
