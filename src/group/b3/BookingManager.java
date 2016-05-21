package group.b3;

import java.util.ArrayList;
import java.util.Date;

public class BookingManager {
    private ArrayList<Booking> bookings;

    public float getRevenue(Date from, Date to)
    {
        float revenue = 0;
        for (Booking booking : bookings) {
            Date testBooking = booking.getCreated();

            if (from.before(testBooking)) {
                revenue += booking.getCost();
            }

        }
        return revenue;
    }

    public void createBooking(Customer customer, Flight flight, float cost, int nrOfSeats)
    {
        Booking newBooking = new Booking(customer, flight, cost, nrOfSeats);
        this.bookings.add(newBooking);
    }
}
