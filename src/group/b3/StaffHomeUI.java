package group.b3;

import javax.swing.*;

/**
 * Created by henkv on 2016-05-15.
 */
public class StaffHomeUI extends UI
{
    private JButton addFlightButton;
    private JButton checkRevenueButton;
    private JButton logOutButton;
    private JPanel contentPanel;

    public StaffHomeUI()
    {

    }

    @Override
    JPanel getContentPanel()
    {
        return this.contentPanel;
    }
}
