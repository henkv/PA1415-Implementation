package group.b3;

import javax.swing.*;

public class StaffHomeUI extends UI
{
    private JButton addFlightButton;
    private JButton checkRevenueButton;
    private JButton logOutButton;
    private JPanel contentPanel;

    public StaffHomeUI()
    {
        addFlightButton.addActionListener(e -> openAddFlightUI());
        logOutButton.addActionListener(e -> logOut());
        checkRevenueButton.addActionListener(e -> checkRevenue());
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
}
