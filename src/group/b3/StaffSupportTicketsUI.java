package group.b3;

import javax.swing.*;
import javax.swing.text.html.ObjectView;

/**
 * Created by henkv on 2016-05-21.
 */
public class StaffSupportTicketsUI extends UI{
    private JList list1;
    private JButton backButton;
    private JButton openButton;
    private JPanel contentPanel;

    public StaffSupportTicketsUI()
    {
        backButton.addActionListener(e -> backButtonClick());
        openButton.addActionListener(e -> openButtonClick());
    }

    private void openButtonClick() {
        Object o = list1.getSelectedValue();

        if (o != null)
        {
            getSystem().setUI(new ViewSupportTicketUI((SupportTicket)o));
        }
    }

    private void backButtonClick() {
        getSystem().setUI(new StaffHomeUI());
    }

    @Override
    JPanel getContentPanel() {
        return contentPanel;
    }

    @Override
    void postSystem()
    {
        list1.setListData(getSystem().getUnsolvedTickets());
    }
}
