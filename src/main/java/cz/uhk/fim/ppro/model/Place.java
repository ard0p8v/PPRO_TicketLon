package cz.uhk.fim.ppro.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Place", catalog = "ticketLon")
public class Place implements java.io.Serializable {

    private Integer idPlace;
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private int numberOfPlaces;
    private Set<Event> events = new HashSet<Event>();

    public Place() {
    }

    public Place(Integer idPlace, String name, String street, String city, String zipCode, int numberOfPlaces, Set<Event> events) {
        this.idPlace = idPlace;
        this.name = name;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.numberOfPlaces = numberOfPlaces;
        this.events = events;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idPlace", unique = true, nullable = false)
    public Integer getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(Integer idPlace) {
        this.idPlace = idPlace;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "street", nullable = false, length = 200)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "city", nullable = false, length = 100)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "zipCode", nullable = false, length = 10)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "numberOfPlaces", nullable = false)
    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place")
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
