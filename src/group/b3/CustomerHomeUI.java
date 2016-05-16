package group.b3;


import javax.swing.*;

public class CustomerHomeUI extends UI
{
    private JPanel contentPanel;
    private JButton searchFlightsButton;
    private JButton logOutButton;
    private JButton checkBalanceButton;
    private JButton supportTicket;

    public CustomerHomeUI()
    {
        this.searchFlightsButton.addActionListener(e -> openSearchFlight());
        this.logOutButton.addActionListener(e -> logOut());

        this.supportTicket.addActionListener(e -> openSupportTicket());
    }
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

    private void openSupportTicket()
    {
        getSystem().setUI(new SupportTicketUI());
    }
}
