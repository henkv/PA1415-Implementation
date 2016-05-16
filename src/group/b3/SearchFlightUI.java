package group.b3;

import javax.print.attribute.standard.Destination;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

public class SearchFlightUI extends UI{
    private JTextField originField;
    private JTextField destinationField;
    private JSpinner earliestYear;
    private JSpinner earliestMonth;
    private JSpinner earliestDay;
    private JSpinner latestYear;
    private JSpinner latestMonth;
    private JSpinner latestDay;
    private JSpinner seatSpinner;
    private JButton backButton;
    private JButton searchButton;
    private JPanel contentPanel;
    private JButton bookSelectedButton;
    private JList flightList;
    private ListModel<Flight> flightListModel;

    public SearchFlightUI()
    {
        searchButton.addActionListener(e -> searchFlights());
        backButton.addActionListener(e -> back());
    }

    private void searchFlights()
    {
        String destination = destinationField.getText();
        String origin = originField.getText();
        Date from = new Date((int) earliestYear.getValue(), (int)earliestMonth.getValue(), (int)earliestDay.getValue());
        Date to = new Date((int)latestYear.getValue(), (int)latestMonth.getValue(), (int)latestDay.getValue());
        int nrOfSeats = (int) seatSpinner.getValue();

        Vector<Flight> flights = getSystem().searchFlights(destination,origin, from, to, nrOfSeats);
        flightList.setListData(flights);

    }

    private void back() {
        getSystem().setUI(new CustomerHomeUI());
    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}
