package cz.uhk.fim.ppro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Type", catalog = "ticketLon")
public class Type implements java.io.Serializable {

    private Integer idType;
    private String name;
    private String description;
    private Set<Event> events = new HashSet<Event>();

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(Integer idType, String name, String description, Set<Event> events) {
        this.idType = idType;
        this.name = name;
        this.description = description;
        this.events = events;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idType", unique = true, nullable = false)
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
