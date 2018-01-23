package cz.uhk.fim.ppro.ticketLon;

import java.util.Set;

public class EventType extends BaseEntity{
    private String typeOfEvent;
    private String description;

    private Set<Event> events;

    public String getTypeOfEvent() {
        return typeOfEvent;
    }
    public void setTypeOfEvent(String typeOfEvent) {
        this.typeOfEvent = typeOfEvent;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Event> getEvents() {
        return events;
    }
    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
