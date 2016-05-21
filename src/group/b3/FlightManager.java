package group.b3;
import java.util.*;

public class FlightManager {
    public ArrayList<Flight> flights;

    public FlightManager()
    {
        flights = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR, 1);
        Date departure = cal.getTime();
        cal.add(Calendar.HOUR, 4);
        Date arrival = cal.getTime();

        System.out.println(departure);
        System.out.println(arrival);

        try
        {
            this.flights.add(new Flight("Karlskrona", "Kebnekaise", 100, 50, departure, arrival));
            this.flights.add(new Flight("Stockholm", "Göteborg", 100, 50, departure, arrival));
            this.flights.add(new Flight("Ronneby", "Kiruna", 100, 50, departure, arrival));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
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
