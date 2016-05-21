package group.b3;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class BookingManager {
    private ArrayList<Booking> bookings;

    public BookingManager() {
        this.bookings = new ArrayList<>();
    }

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
        flight.reserveSeats(nrOfSeats);
        this.bookings.add(newBooking);

        bookings.add(newBooking);
    }


    public void saveToFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("bookings.data");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(bookings);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile()
    {
        try {
            FileInputStream fin = new FileInputStream("bookings.data");
            ObjectInputStream ois = new ObjectInputStream(fin);
            bookings = (ArrayList<Booking>) ois.readObject();
            fin.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
