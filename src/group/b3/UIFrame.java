package group.b3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by henkv on 2016-05-13.
 */

class UIFrame
{
    private JFrame frame;
    private UI activeUI;

    UIFrame()
    {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public void setUI(UI ui)
    {
        frame.getContentPane().removeAll();
        frame.add(ui.getContentPanel(), BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

}
