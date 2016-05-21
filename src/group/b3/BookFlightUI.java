package group.b3;

import javax.swing.*;

/**
 * Created by henkv on 2016-05-19.
 */
public class BookFlightUI extends UI {
    private JPanel contentPanel;
    private JLabel origin;
    private JLabel destination;
    private JLabel arrival;
    private JLabel departure;
    private JLabel numberOfSeats;
    private JLabel cost;
    private JButton cancelButton;
    private JButton bookButton;
    private float ticketCost;
    private Flight flight;

    public BookFlightUI(Flight flight, int nrOfSeats)
    {
        this.flight = flight;
        ticketCost = nrOfSeats * flight.calculateCost();
        origin.setText(flight.getOrigin());
        destination.setText(flight.getDestination());
        arrival.setText(flight.getArrival().toString());
        departure.setText(flight.getDeparture().toString());
        numberOfSeats.setText("" + nrOfSeats);
        cost.setText("" + ticketCost);

        cancelButton.addActionListener(e -> back());
        bookButton.addActionListener(e -> bookFlight());
    }


    @Override
    JPanel getContentPanel() {
        return contentPanel;
    }

    private void back()
    {
        getSystem().setUI(new SearchFlightUI());

    }

    private void bookFlight()
    {
        getSystem().activeUserBookFlight(flight, ticketCost, )
    }
}
