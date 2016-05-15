package group.b3;


import javax.swing.*;

public class CustomerHomeUI extends UI
{
    private JPanel contentPanel;
    private JButton searchFlightsButton;
    private JButton logOutButton;
    private JButton checkBalanceButton;

    public CustomerHomeUI()
    {
        this.searchFlightsButton.addActionListener(e -> openSearchFlight());
        this.logOutButton.addActionListener(e -> logOut());
    }

    @Override
    JPanel getContentPanel() {
        return this.contentPanel;
    }

    private void openSearchFlight()
    {
        getSystem().setUI(new SearchFlightUI());
    }

    private void logOut()
    {
        getSystem().setActiveUser(null);
        getSystem().setUI(new LoginUI());
    }
}
