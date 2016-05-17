package group.b3;

import java.util.Date;

public class Flight {
    private static long currentUid = 0;
    private long uid;
    private String origin;
    private String destination;
    private float baseCost;
    private int totalSeats;
    private Date departure;
    private Date arrival;
    private int reservedSeats;

    public Flight(String origin, String destination, float baseCost, int totalSeats, Date departure, Date arrival) {
        this.uid = currentUid++;
        this.origin = origin;
        this.destination = destination;
        this.baseCost = baseCost;
        this.totalSeats = totalSeats;
        this.departure = departure;
        this.arrival = arrival;
        this.reservedSeats = 0;
    }

    public float calculateCost() {
        return baseCost + baseCost * (reservedSeats / totalSeats);
    }

    public int nrOfemptySeats()
    {
        return totalSeats - reservedSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    public void setReservedSeats(int reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public float getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(float baseCost) {
        this.baseCost = baseCost;
    }

    @Override
    public String toString() {
        return origin + " -> " + destination + '\t' +
               ", Departure: " + departure +
               ", Arrival: " + arrival +
               ", Cost:" + calculateCost();
    }
}
