package group.b3;
import java.io.*;
import java.util.*;

public class FlightManager {
    private ArrayList<Flight> flights;

    public FlightManager()
    {
        flights = new ArrayList<>();

        /*Calendar cal = Calendar.getInstance();
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
        }*/
    }



    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public Vector<Flight> searchFlights(String destination, Date from, Date to, int nrOfSeats){
        Vector<Flight> availableFlights = new Vector<>();

        for (Flight flight : flights)
        {
            if     (flight.getDestination().equals(destination) &&
                    flight.nrOfemptySeats() >= nrOfSeats &&
                    flight.getDeparture().after(from) &&
                    flight.getDeparture().before(to))
            {
                availableFlights.add(flight);
            }
        }

        return availableFlights;
    }

    public ArrayList<String> getDestinations()
    {
        ArrayList<String> destinations = new ArrayList<>();

        flights.forEach(f ->
        {
            if (!destinations.contains(f.getDestination()))
                destinations.add(f.getDestination());
        });

        return destinations;
    }

    public void addFlight(String origin,
                          String destination,
                          int totalSeats,
                          float baseCost,
                          Date departure,
                          Date arrival) throws Exception
    {
        Flight newFlight = new Flight(origin, destination,baseCost, totalSeats,departure, arrival);

        if (flights.contains(newFlight))
            throw new Exception("Flight already exists");

        flights.add(newFlight);
    }


    public void saveToFile()
    {
        try {
            FileOutputStream fout = new FileOutputStream("flights.data");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(flights);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile()
    {
        try {
            FileInputStream fin = new FileInputStream("flights.data");
            ObjectInputStream ois = new ObjectInputStream(fin);
            flights = (ArrayList<Flight>) ois.readObject();
            fin.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
