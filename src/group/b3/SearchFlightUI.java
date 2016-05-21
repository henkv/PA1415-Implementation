package group.b3;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class SearchFlightUI extends UI{
    private JSpinner earliestSpinner;
    private JSpinner latestSpinner;
    private JSpinner seatSpinner;
    private JButton backButton;
    private JButton searchButton;
    private JPanel contentPanel;
    private JButton bookSelectedButton;
    private JList flightList;
    private JComboBox destinationBox;

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
        String destination = (String)destinationBox.getSelectedItem();

        System.out.println((Date) earliestSpinner.getValue());

        Date from = (Date) earliestSpinner.getValue();
        Date to = (Date) latestSpinner.getValue();
        int nrOfSeats = (int) seatSpinner.getValue();

        Vector<Flight> flights = getSystem().searchFlights(destination, from, to, nrOfSeats);
        flights.forEach(System.out::println);
        flightList.setListData(flights);

    }

    @Override
    void postSystem() {

        getSystem().getDestinations().forEach(destinationBox::addItem);

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
