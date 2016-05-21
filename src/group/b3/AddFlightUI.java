package group.b3;

import javax.swing.*;
import java.util.Calendar;

/**
 * Created by henkv on 2016-05-15.
 */
public class AddFlightUI extends UI{

    private JPanel contentPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JSpinner spinnerDeparture;
    private JSpinner spinnerArrival;

    public AddFlightUI()
    {
        Calendar now = Calendar.getInstance();
        spinnerDeparture.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
        now.add(Calendar.DAY_OF_MONTH, 14);
        spinnerArrival.setModel(new SpinnerDateModel(now.getTime(), null, null, Calendar.YEAR));
    }

    @Override
    public JPanel getContentPanel()
    {
        return contentPanel;
    }
}
