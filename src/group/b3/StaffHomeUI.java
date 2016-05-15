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
        logOutButton.addActionListener(e -> logOut());
    }

    @Override
    JPanel getContentPanel()
    {
        return this.contentPanel;
    }

    public void openAddFlightUI()
    {

    }


    void logOut()
    {
        getSystem().setActiveUser(null);
        getSystem().setUI(new LoginUI());
    }
}
