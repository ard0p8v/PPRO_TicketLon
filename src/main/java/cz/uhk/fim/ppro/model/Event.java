package cz.uhk.fim.ppro.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Event", catalog = "ticketLon", uniqueConstraints = @UniqueConstraint(columnNames = "title"))
public class Event implements java.io.Serializable {

    private Integer idEvent;
    private String title;
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")
    private Date date;
    private int duration;
    private String description;
    private int numberOfFreeTickets;
    private double priceOfOneTicket;
    private EventType type;
    private Place place;
    private User user;

    public Event() {
    }

    public Event(Integer idEvent, String title, Date date, int duration, String description, int numberOfFreeTickets, double priceOfOneTicket, EventType type, Place place, User user) {
        this.idEvent = idEvent;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.numberOfFreeTickets = numberOfFreeTickets;
        this.priceOfOneTicket = priceOfOneTicket;
        this.type = type;
        this.place = place;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idEvent", unique = true, nullable = false)
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    @Column(name = "title", unique = true, nullable = false, length = 200)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 19)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "duration", nullable = false)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Column(name = "description", nullable = false, length = 9999)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "numberOfFreeTickets", nullable = false)
    public int getNumberOfFreeTickets() {
        return numberOfFreeTickets;
    }

    public void setNumberOfFreeTickets(int numberOfFreeTickets) {
        this.numberOfFreeTickets = numberOfFreeTickets;
    }

    @Column(name = "priceOfOneTicket", nullable = false)
    public double getPriceOfOneTicket() {
        return priceOfOneTicket;
    }

    public void setPriceOfOneTicket(double priceOfOneTicket) {
        this.priceOfOneTicket = priceOfOneTicket;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EventType_idEventType")
    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Place_idPlace")
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_idUser")
    public User getUser() { return user;  }

    public void setUser(User user) {
        this.user = user;
    }
}
