package group.b3;

import javax.swing.*;


public class SupportTicketUI extends UI{

    private JPanel contentPanel;
    private JButton backButton;
    private JButton submitButton;
    private JFormattedTextField ticket;

    public SupportTicketUI()

    {
        String save = "HEJEJEJ";
        submitButton.addActionListener(e -> confirm());
        backButton.addActionListener(e -> back());
        ticket.setText(save);
    }

    public void back()
    {

    }

    public void confirm()
    {

    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}

