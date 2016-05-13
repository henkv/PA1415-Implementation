package group.b3;


import javax.swing.*;

public class LoginUI extends UI{
    private JPanel contentPane;

    public LoginUI(System system) {
        super(system);
        this.contentPane = super.getContentPane();

        JTextField username = new JTextField();
        JTextField password = new JTextField();

        this.contentPane.add(username);
        this.contentPane.add(password);
    }

    public void logIn()
    {

    }
}
