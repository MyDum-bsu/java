package gui;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractApplication extends JFrame {
    private void defaultSetInit(int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - width)/ 2, (dimension.height - height) / 2, width, height);
        setMinimumSize(new Dimension(width, height));
        getContentPane().setBackground(Color.BLACK);
    }

    public AbstractApplication(int width, int height) {
        super();
        defaultSetInit(width, height);
    }

    public AbstractApplication(String s, int width, int height) {
        super(s);
        defaultSetInit(width, height);
    }
}
