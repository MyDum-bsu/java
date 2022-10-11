package lab4;

import javax.swing.*;
import java.awt.*;

public class Application {
    private JFrame jFrame;
    private Toolkit toolkit;
    private Dimension dimension;

    public Application(int width, int height) {
        jFrame = new JFrame();
        toolkit = Toolkit.getDefaultToolkit();
        dimension = toolkit.getScreenSize();

        jFrame.setBounds(dimension.width / 2 - width / 2, dimension.height / 2 - height / 2, width, height);
        jFrame.getContentPane().setBackground(Color.BLACK);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
