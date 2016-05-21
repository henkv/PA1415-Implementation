package group.b3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class FlightSystem {
    private User activeUser;
    private ArrayList<User> users;
    private FlightManager flightManager;
    private BookingManager bookingManager;
    private UIFrame uiFrame;
    private SupportTicketManager supportTickets;

    FlightSystem()
    {
        users = new ArrayList<>();
        users.add(new Staff("staff", "test", 0));
        users.add(new Customer("customer", "test", 1000));

        flightManager = new FlightManager();
        flightManager.loadFromFile();

        bookingManager = new BookingManager();
        bookingManager.loadFromFile();

        supportTickets = new SupportTicketManager();
        supportTickets.loadFromFile();

        uiFrame = new UIFrame();
        uiFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                flightManager.saveToFile();
                bookingManager.saveToFile();
                supportTickets.saveToFile();
            }
        });
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

            if (username.equalsIgnoreCase(user.getName()) && password.equals(user.getPassword()))
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

    public Vector<Flight> searchFlights(String destination, Date start, Date end, int nrOfSeats)
    {
        return flightManager.searchFlights(destination, start, end, nrOfSeats);
    }

    void setUI(UI ui) {
        ui.setSystem(this);
        uiFrame.setUI(ui);
    }

    boolean activeUserBookFlight(Flight flight, float cost, int nrOfSeats) throws Exception
    {
        if (!(activeUser instanceof Customer))
            throw new Exception("Active user is not a customer.");

        Customer customer = (Customer) activeUser;
        Boolean booked = false;

        if (cost <= customer.getBalance())
        {
            bookingManager.createBooking(customer, flight, cost, nrOfSeats);
            customer.removeMoney(cost);
            booked = true;
        }

        return booked;
    }

    public void addFlight(String origin, String destination, int totalSeats, float baseCost, Date departure, Date arrival) throws Exception {
        flightManager.addFlight(origin, destination, totalSeats, baseCost, departure, arrival);
    }

    public ArrayList<String> getDestinations()
    {
        return flightManager.getDestinations();
    }

    public void addTicket(String text) {
        supportTickets.addTicket(text, (Customer) activeUser);
    }

    public Vector<SupportTicket> getUnsolvedTickets()
    {
        return supportTickets.getUnsolvedTickets();
    }
}
