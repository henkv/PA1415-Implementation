package group.b3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class UIFrame extends JFrame
{
    UIFrame()
    {
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       this.setLayout(new BorderLayout());
       this.setSize(500,500);
       this.setVisible(true);
    }

    void setUI(UI ui)
    {
        this.getContentPane().removeAll();
        this.add(ui.getContentPanel(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }
}
