package cz.uhk.fim.ppro.ticketLon;

public class NamedEntity extends BaseEntity{

    private String namee;


    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getNamee() {
        return this.namee;
    }

    @Override
    public String toString() {
        return this.getNamee();
    }
}
