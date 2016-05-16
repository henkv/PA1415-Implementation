package group.b3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class FlightManager {
    public ArrayList<Flight> flights;

    public FlightManager(ArrayList<Flight> flights) {
        this.flights = flights;
        this.flights.add(new Flight("Karlskrona","Kebnekaise", 100, 50, new Date(2016, 01, 01), new Date(2016, 01, 02)));
        this.flights.add(new Flight("Stockholm","Göteborg", 100, 50, new Date(2016, 02, 01), new Date(2016, 02, 02)));
        this.flights.add(new Flight("Ronneby","Kiruna", 100, 50, new Date(2016, 01, 01), new Date(2016, 02, 02)));
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public Vector<Flight> searchFlights(String destination, String origin, Date from, Date to, int nrOfSeats){
        Vector<Flight> availableFlights = new Vector<Flight>();

        for (Flight testFlight : flights)
        {
            if (testFlight.getDestination().equals(destination) &&
                    testFlight.getOrigin().equals(origin) &&
                    testFlight.nrOfemptySeats() >= nrOfSeats &&
                    testFlight.getDeparture().after(from) &&
                    testFlight.getDeparture().before(to))
            {
                availableFlights.add(testFlight);
            }
        }

        return availableFlights;
    }


}
