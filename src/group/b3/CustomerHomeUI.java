package group.b3;


import javax.swing.*;

public class CustomerHomeUI extends UI
{
    private FlightSystem flightSystem;
    private JPanel contentPanel;
    private JButton searchFlightsButton;
    private JButton logOutButton;
    private JButton checkBalanceButton;
    private JButton supportTicket;

    CustomerHomeUI()
    {
        this.searchFlightsButton.addActionListener(e -> openSearchFlight());
        this.logOutButton.addActionListener(e -> logOut());
        this.checkBalanceButton.addActionListener(e -> checkBalance());

        this.supportTicket.addActionListener(e -> openSupportTicket());
    }

    @Override
    public JPanel getContentPanel() {
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

    private void checkBalance(){
        JOptionPane.showMessageDialog(contentPanel, "Balance: " + ((Customer)flightSystem.getActiveUser()).getBalance()  + " kr");
    }
}
