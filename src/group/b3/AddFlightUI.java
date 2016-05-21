package group.b3;

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
        float baseCost = (float) totalSeatsSpinner.getValue();
        Date departure = (Date) departureSpinner.getValue();
        Date arrival = (Date) arrivalSpinner.getValue();

        getSystem().addFlight(origin, destination, totalSeats,baseCost, departure, arrival);
    }

    public void back()
    {
        getSystem().setUI(new StaffHomeUI());
    }
}
