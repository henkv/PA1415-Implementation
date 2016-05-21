package group.b3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class FlightSystem {
    private User activeUser;
    private ArrayList<User> users;
    private FlightManager flightManager;
    private BookingManager bookingManager;
    private UIFrame uiFrame;
    private BookingManager bookingManager;

    public BookingManager getBookingManager() {
        return bookingManager;
    }

    public void setBookingManager(BookingManager bookingManager) {
        this.bookingManager = bookingManager;
    }

    FlightSystem()
    {
        users = new ArrayList<>();
        users.add(new Staff("staff", "test", 0));
        users.add(new Customer("customer", "test", 100));

        flightManager = new FlightManager();
        bookingManager = new BookingManager();

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
        return flightManager.searchFlights(destination, origin, start, end, nrOfSeats);
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
}
