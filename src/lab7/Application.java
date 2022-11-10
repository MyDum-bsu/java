package lab7;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    public Application() {
        initDefaultSet();
        //add(new FirstCard(), BorderLayout.CENTER);
        //add(new SecondCard(), BorderLayout.CENTER);
        //add(new ThirdCard(), BorderLayout.CENTER);
        initTabbedPane();
        setVisible(true);
    }

    private void initTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("tab 1", new FirstCard());
        tabbedPane.addTab("tab 2", new SecondCard());
        tabbedPane.addTab("tab 3", new ThirdCard());
        add(tabbedPane);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 400, 800, 800);
        setMinimumSize(new Dimension(800, 800));
        getContentPane().setBackground(Color.BLACK);
    }
}
