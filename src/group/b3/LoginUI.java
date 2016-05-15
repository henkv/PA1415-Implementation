package group.b3;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

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
        String username = nameField.getText();
        String password = new String(passwordField.getPassword());
        User user = getSystem().getUser(username, password);
        System.out.println(username + " " + password + " " + user);

        if (user != null)
        {
            if (user instanceof Staff)
            {
                getSystem().setActiveUser(user);
                getSystem().setUI(new StaffHomeUI());
            }
            else
            {
                getSystem().setActiveUser(user);
                getSystem().setUI(new CustomerHomeUI());
            }
        }
    }

}
