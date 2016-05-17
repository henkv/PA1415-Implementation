package group.b3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class FlightManager {
    public ArrayList<Flight> flights;

    public FlightManager()
    {
        flights = new ArrayList<>();

        this.flights.add(new Flight("Karlskrona","Kebnekaise", 100, 50, new Date(2016, 01, 01), new Date(2016, 01, 02)));
        this.flights.add(new Flight("Stockholm","Göteborg", 100, 50, new Date(2016, 02, 01), new Date(2016, 02, 02)));
        this.flights.add(new Flight("Ronneby","Kiruna", 100, 50, new Date(2016, 01, 01), new Date(2016, 02, 02)));

    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public Vector<Flight> searchFlights(String destination, String origin, Date from, Date to, int nrOfSeats){
        Vector<Flight> availableFlights = new Vector<>();

        for (Flight flight : flights)
        {
            if     (flight.getDestination().equals(destination) &&
                    flight.getOrigin().equals(origin) &&
                    flight.nrOfemptySeats() >= nrOfSeats &&
                    flight.getDeparture().after(from) &&
                    flight.getDeparture().before(to))
            {
                availableFlights.add(flight);
            }
        }

        return availableFlights;
    }


}
