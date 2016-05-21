package group.b3;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class SearchFlightUI extends UI{
    private JTextField originField;
    private JTextField destinationField;
    private JSpinner earliestSpinner;
    private JSpinner latestSpinner;
    private JSpinner seatSpinner;
    private JButton backButton;
    private JButton searchButton;
    private JPanel contentPanel;
    private JButton bookSelectedButton;
    private JList flightList;

    public SearchFlightUI()
    {
        Calendar now = Calendar.getInstance();
        earliestSpinner.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
        now.add(Calendar.DAY_OF_MONTH, 14);
        latestSpinner.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
        seatSpinner.setModel(new SpinnerNumberModel(1, 1, 10, 1));

        bookSelectedButton.addActionListener(e -> bookFlight());
        searchButton.addActionListener(e -> searchFlights());
        backButton.addActionListener(e -> back());
    }

    private void searchFlights()
    {
        String destination = destinationField.getText();
        String origin = originField.getText();

        System.out.println((Date) earliestSpinner.getValue());


        Date from = (Date) earliestSpinner.getValue();
        Date to = (Date) latestSpinner.getValue();
        int nrOfSeats = (int) seatSpinner.getValue();

        Vector<Flight> flights = getSystem().searchFlights(destination,origin, from, to, nrOfSeats);
        flights.forEach(System.out::println);
        flightList.setListData(flights);

    }

    private void back()
    {
        getSystem().setUI(new CustomerHomeUI());
    }

    private void bookFlight()
    {
        getSystem().setUI(new BookFlightUI((Flight) flightList.getSelectedValue(), (int) seatSpinner.getValue()));
    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}
