package cz.uhk.fim.ppro.ticketLon;

import java.util.Date;

public class News extends BaseEntity{
    private String name;
    private Date added;
    private String text;

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
