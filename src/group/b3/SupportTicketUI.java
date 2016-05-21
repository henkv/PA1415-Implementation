package group.b3;

import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

import javax.swing.*;


public class SupportTicketUI extends UI{

    private JPanel contentPanel;
    private JButton backButton;
    private JButton submitButton;
    private JTextArea textArea;

    public SupportTicketUI()

    {
        submitButton.addActionListener(e -> confirm());
        backButton.addActionListener(e -> back());


    }

    public void back()
    {
        getSystem().setUI(new CustomerHomeUI());
    }

    public void confirm()
    {
        getSystem().addTicket(textArea.getText());
        back();
    }

    @Override
    public JPanel getContentPanel() {
        return contentPanel;
    }
}

