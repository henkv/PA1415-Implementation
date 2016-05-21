package group.b3;

import javax.swing.*;

/**
 * Created by henkv on 2016-05-21.
 */
public class ViewSupportTicketUI extends UI
{
    private JPanel contentPanel;
    private JTextArea textArea;
    private JButton backButton;
    private JButton solveButton;
    private JLabel created;
    private JLabel owner;
    private SupportTicket ticket;

    public ViewSupportTicketUI(SupportTicket ticket)
    {
        this.ticket = ticket;

        textArea.setText(ticket.getMessage());
        created.setText(ticket.getCreated().toString());
        owner.setText(ticket.getOwner().getName() + " (" + ticket.getOwner().getPassword() + ")");

        backButton.addActionListener(e -> backButtonClick());
        solveButton.addActionListener(e -> solveButtonClick());
    }

    private void solveButtonClick() {
        ticket.setSolved(true);
        backButtonClick();
    }

    private void backButtonClick() {
        getSystem().setUI(new StaffSupportTicketsUI());

    }

    @Override
    JPanel getContentPanel()
    {
        return contentPanel;
    }
}
