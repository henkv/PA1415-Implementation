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

        FlightSystem flightSystem = new FlightSystem();
        flightSystem.setUI(new LoginUI());
    }
}
