package group.b3;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            e.printStackTrace();
        }

        FlightSystem system = new FlightSystem();
        UIFrame uiFrame = new UIFrame();
        LoginUI loginUI = new LoginUI();
        AddFlightUI addFlightUI = new AddFlightUI();

        uiFrame.setUI(loginUI);
        sleep(1000);
        uiFrame.setUI(addFlightUI);
    }
}
