package cz.uhk.fim.ppro.model;

import java.util.HashSet;
import java.util.Set;

public class EventType implements java.io.Serializable {

    private Integer idTypeOfEvent;
    private String typeOfEvent;
    private String description;
    private Set<Event> events = new HashSet<Event>();

    public EventType() {
    }

    public EventType(Integer idTypeOfEvent, String typeOfEvent, String description, Set<Event> events) {
        this.idTypeOfEvent = idTypeOfEvent;
        this.typeOfEvent = typeOfEvent;
        this.description = description;
        this.events = events;
    }

    public Integer getIdTypeOfEvent() {
        return idTypeOfEvent;
    }

    public void setIdTypeOfEvent(Integer idTypeOfEvent) {
        this.idTypeOfEvent = idTypeOfEvent;
    }

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
