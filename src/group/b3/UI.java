package group.b3;

import javax.swing.*;

abstract class UI
{
    FlightSystem system;

    public void setSystem(FlightSystem system)
    {
        this.system = system;
        postSystem();
    }

    FlightSystem getSystem()
    {
        return system;
    }

    void postSystem() {};

    abstract JPanel getContentPanel();
}
