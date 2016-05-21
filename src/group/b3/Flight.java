package group.b3;

import java.util.Date;
import java.util.concurrent.Exchanger;

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

    public Flight(String origin, String destination, float baseCost, int totalSeats, Date departure, Date arrival) throws Exception {

        Date now = new Date();

        if (departure.before(now) || arrival.before(departure))
            throw new Exception("Dates are wrong.");

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

    public void reserveSeats(int nrOfSeats) {
        this.reservedSeats += nrOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (Float.compare(flight.baseCost, baseCost) != 0) return false;
        if (totalSeats != flight.totalSeats) return false;
        if (origin != null ? !origin.equals(flight.origin) : flight.origin != null) return false;
        if (destination != null ? !destination.equals(flight.destination) : flight.destination != null) return false;
        if (departure != null ? !departure.equals(flight.departure) : flight.departure != null) return false;
        return arrival != null ? arrival.equals(flight.arrival) : flight.arrival == null;
    }

    @Override
    public int hashCode() {
        int result = origin != null ? origin.hashCode() : 0;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (baseCost != +0.0f ? Float.floatToIntBits(baseCost) : 0);
        result = 31 * result + totalSeats;
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        return result;
    }
}
