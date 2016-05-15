package group.b3;
import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    public ArrayList<Flight> flights;

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public ArrayList<Flight> serachFlights(String destination, String origin){
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
