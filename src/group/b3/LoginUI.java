package group.b3;

import javax.swing.*;

/**
 * Created by henkv on 2016-05-15.
 */
public class LoginUI extends UI {
    private JPanel contentPanel;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    LoginUI() {
        loginButton.addActionListener(e -> logIn());
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    private void logIn()
    {
        User user = getSystem().getUser(nameField.getText(), passwordField.getText());

        if (user != null)
        {
            if (user instanceof Staff)
            {
                getSystem().setActiveUser(user);
                getSystem().setUI(new AddFlightUI());
            }
        }
    }

}
