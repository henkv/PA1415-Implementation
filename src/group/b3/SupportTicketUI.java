package group.b3;

import javax.swing.*;


public class SupportTicketUI extends UI{

    private JPanel contentPanel;
    private JButton backButton;
    private JButton submitButton;
    private JFormattedTextField ticket;
    private String ticketBox;

    public SupportTicketUI()

    {
        ticketBox = "Test ticket, plz respond"; //ladda från fil
        submitButton.addActionListener(e -> confirm());
        backButton.addActionListener(e -> back());
        ticket.setText(ticketBox);
    }

    public void back()
    {
        getSystem().setUI(new CustomerHomeUI());
    }

    public void confirm()
    {
        ticketBox = ticket.getText();
        //save text in string save
        getSystem().setUI(new CustomerHomeUI());
    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}

