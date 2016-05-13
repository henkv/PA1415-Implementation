package group.b3;

import javax.swing.*;

abstract class UI {
    private System system;

    private JPanel contentPane;


    public UI(System system) {
        this.system = system;
        this.contentPane = new JPanel();
    }

    JPanel getContentPane()
    {
        return this.contentPane;
    }


    public void show()
    {

    }

    public void hide()
    {

    }

    public void close()
    {

    }

}
