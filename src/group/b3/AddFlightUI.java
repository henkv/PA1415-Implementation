package group.b3;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by henkv on 2016-05-15.
 */
public class AddFlightUI extends UI{

    private JPanel contentPanel;
    private JTextField originField;
    private JTextField destinationField;
    private JSpinner arrivalSpinner;
    private JButton addFlightButton;
    private JButton backButton;
    private JSpinner totalSeatsSpinner;
    private JSpinner departureSpinner;
    private JSpinner costSpinner;

    public AddFlightUI()
    {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR, 4);
        departureSpinner.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
        now.add(Calendar.HOUR, 4);
        arrivalSpinner.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
        totalSeatsSpinner.setModel(new SpinnerNumberModel(50, 10, 200, 1));
        costSpinner.setModel(new SpinnerNumberModel(100, 1, null, 1));

        backButton.addActionListener(e -> back());
        addFlightButton.addActionListener(e -> addFlight());
    }

    @Override
    public JPanel getContentPanel()
    {
        return contentPanel;
    }

    public void addFlight()
    {
        String origin = originField.getText();
        String destination = destinationField.getText();
        int totalSeats = (int) totalSeatsSpinner.getValue();
        float baseCost = ((int) totalSeatsSpinner.getValue() / 1.0f) ;
        Date departure = (Date) departureSpinner.getValue();
        Date arrival = (Date) arrivalSpinner.getValue();

        try {
            getSystem().addFlight(origin, destination, totalSeats,baseCost, departure, arrival);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contentPanel, e.getMessage());
        }
    }

    public void back()
    {
        getSystem().setUI(new StaffHomeUI());
    }
}
