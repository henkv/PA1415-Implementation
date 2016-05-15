package group.b3;

import javax.swing.*;

abstract class UI
{
    FlightSystem system;

    public void setSystem(FlightSystem system)
    {
        this.system = system;
    }

    FlightSystem getSystem()
    {
        return system;
    }

    abstract JPanel getContentPanel();
}
