package group.b3;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public ArrayList<Flight> searchFlights(String destination, String origin){
        ArrayList<Flight> availableFlights = new ArrayList<Flight>();

        for (int i = 0; i < flights.size(); i++){

            Flight testFlight = flights.get(i);

            if(testFlight.getDestination() == destination && testFlight.getOrigin() == origin){
                availableFlights.add(testFlight);
            }
        }


        return availableFlights;

    }


}
