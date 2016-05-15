package group.b3;

import java.util.ArrayList;
import java.util.Date;

public class BookingManager {
    public ArrayList<Booking> bookings;

    public float getRevenue(Date from, Date to)
    {
        float revenue = 0;
        for (int i = 0; i < bookings.size(); i++)
        {
            Date testBooking = bookings.get(i).getCreated();

            if(from.before(testBooking))
            {
                revenue += bookings.get(i).getCost();
            }

        }
        return revenue;
    }

    public void createBooking(Customer customer, Flight flight, int cost, int nrOfSeats)
    {
        Booking newBooking = new Booking(customer, flight, cost, nrOfSeats);
        this.bookings.add(this.bookings.size(), newBooking);
    }
}
