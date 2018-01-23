package cz.uhk.fim.ppro.ticketLon;

import java.util.Date;

public class Event extends BaseEntity{
    private String title;
    private Date date;
    private int duration;
    private String description;
    private int numberOfFreeTickets;
    private double priceOfOneTicket;
    private EventType type;
    private Place place;

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
        return this.type;
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

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
