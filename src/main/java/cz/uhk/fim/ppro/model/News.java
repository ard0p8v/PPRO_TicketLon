package cz.uhk.fim.ppro.model;

import java.util.Date;

public class News implements java.io.Serializable {

    private Integer idNews;
    private String name;
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

    public Integer getIdNews() {
        return idNews;
    }

    public void setIdNews(Integer idNews) {
        this.idNews = idNews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
