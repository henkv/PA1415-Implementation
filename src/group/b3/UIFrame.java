package group.b3;

import javax.swing.*;
import java.awt.*;


class UIFrame extends JFrame
{
    private UI activeUI;

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
