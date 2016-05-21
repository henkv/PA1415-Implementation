package group.b3;

import javax.swing.*;

public class StaffHomeUI extends UI
{
    private JButton addFlightButton;
    private JButton checkRevenueButton;
    private JButton logOutButton;
    private JPanel contentPanel;
    private JButton viewSupportTicketsButton;

    public StaffHomeUI()
    {
        addFlightButton.addActionListener(e -> openAddFlightUI());
        logOutButton.addActionListener(e -> logOut());
        checkRevenueButton.addActionListener(e -> checkRevenue());
         viewSupportTicketsButton.addActionListener(e -> viewSupportTicketsButtonClick());
    }

    @Override
    JPanel getContentPanel()
    {
        return this.contentPanel;
    }

    private void checkRevenue(){

    }

    public void openAddFlightUI()
    {
        getSystem().setUI(new AddFlightUI());
    }


    void logOut()
    {
        getSystem().setActiveUser(null);
        getSystem().setUI(new LoginUI());
    }
    void viewSupportTicketsButtonClick()
    {
        getSystem().setUI(new StaffSupportTicketsUI());
    }
}
