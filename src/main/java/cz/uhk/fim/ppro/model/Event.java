package cz.uhk.fim.ppro.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    public Event() {
    }

    public Event(Integer idEvent, String title, Date date, int duration, String description, int numberOfFreeTickets, double priceOfOneTicket, EventType type, Place place) {
        this.idEvent = idEvent;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.description = description;
        this.numberOfFreeTickets = numberOfFreeTickets;
        this.priceOfOneTicket = priceOfOneTicket;
        this.type = type;
        this.place = place;
    }

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfFreeTickets() {
        return numberOfFreeTickets;
    }

    public void setNumberOfFreeTickets(int numberOfFreeTickets) {
        this.numberOfFreeTickets = numberOfFreeTickets;
    }

    public double getPriceOfOneTicket() {
        return priceOfOneTicket;
    }

    public void setPriceOfOneTicket(double priceOfOneTicket) {
        this.priceOfOneTicket = priceOfOneTicket;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
