package group.b3;

import java.util.ArrayList;
import java.util.Date;

public class System {
    private ArrayList<User> users;
    private FlightManager flightManager;

    public System(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser(String username, String password){

        User searchedUser = null;

        for (int i= 0; i < users.size() && searchedUser == null; i++){

            if (username == users.get(i).getName() && password == users.get(i).getPassword()){
                searchedUser = users.get(i);
            }

        }

        return searchedUser;
    }

    public void addFLight(Flight flight)
    {
        this.flightManager.addFlight(flight);
    }

    public void createTicet(String message, Customer customer)
    {

    }

    public ArrayList<Flight> sertchFlights(String destination, String origin, Date start, Date end, int nrOfSeats)
    {
        
    }


}
