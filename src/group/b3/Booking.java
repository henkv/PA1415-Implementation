package group.b3;


import java.util.Date;

public class Booking {
    private long uid;
    private Customer owner;
    private Flight flight;
    private float cost;
    private int nrOfSeats;
    private Date created;


    public Booking(Customer owner, Flight flight, float cost, int nrOfSeats) {
        //this.uid = uid;
        this.owner = owner;
        this.flight = flight;
        this.cost = cost;
        this.nrOfSeats = nrOfSeats;
        this.created = new Date();
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
