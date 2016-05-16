package group.b3;

import javax.swing.*;

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

    public SearchFlightUI()
    {
        backButton.addActionListener(e -> back());
    }

    private void back() {
        getSystem().setUI(new CustomerHomeUI());
    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}
