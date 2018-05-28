package cz.uhk.fim.ppro.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "News", catalog = "ticketLon", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class News implements java.io.Serializable {

    private Integer idNews;
    private String name;
    @DateTimeFormat(pattern="dd.MM.yyyy HH:mm")
    private Date added;
    private String text;

    public News() {
    }

    public News(Integer idNews, String name, Date added, String text) {
        this.idNews = idNews;
        this.name = name;
        this.added = added;
        this.text = text;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "idNews", unique = true, nullable = false)
    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
    }

    @Column(name = "name", unique = true, nullable = false, length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added", nullable = false, length = 19)
    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Column(name = "description", length = 1000)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
