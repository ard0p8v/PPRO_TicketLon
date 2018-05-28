package cz.uhk.fim.ppro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "eventType", catalog = "ticketLon")
public class EventType implements java.io.Serializable {

    private Integer idEventType;
    private String name;
    private String description;
    private Set<Event> events = new HashSet<Event>();

    public EventType() {
    }

    public EventType(String name) {
        this.name = name;
    }

    public EventType(Integer idEventType, String name, String description, Set<Event> events) {
        this.idEventType = idEventType;
        this.name = name;
        this.description = description;
        this.events = events;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idEventType", unique = true, nullable = false)
    public Integer getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(Integer idEventType) {
        this.idEventType = idEventType;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String typeOfEvent) {
        this.name = name;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "eventType")
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
