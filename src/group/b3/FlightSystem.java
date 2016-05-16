package group.b3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class FlightSystem {
    private User activeUser;
    private ArrayList<User> users;
    private FlightManager flightManager;
    private UIFrame uiFrame;

    FlightSystem()
    {
        users = new ArrayList<>();
        users.add(new Staff("staff", "test", 0));
        users.add(new Customer("customer", "test", 0));

        uiFrame = new UIFrame();
    }

    void setActiveUser(User activeUser)
    {
        this.activeUser = activeUser;
    }

    User getUser(String username, String password)
    {
        User searchedUser = null;

        for (int i= 0; i < users.size() && searchedUser == null; i++)
        {
            User user = users.get(i);

            if (username.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword()) )
            {
                searchedUser = user;
            }
        }

        return searchedUser;
    }

    public User getActiveUser(){
        return this.activeUser;
    }

    public void addFlight(Flight flight)
    {
        this.flightManager.addFlight(flight);
    }

    public void createTicket(String message, Customer customer)
    {

    }

    public Vector<Flight> searchFlights(String destination, String origin, Date start, Date end, int nrOfSeats)
    {
        return null;
    }

    void setUI(UI ui) {
        ui.setSystem(this);
        uiFrame.setUI(ui);
    }


}
