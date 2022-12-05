package control_work.template.kr1.first;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(String title) {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        JPanel personPanel = getPersonPanel();
        JPanel doublePanel = getDoublesPanel();
        layout.setVerticalGroup(layout.createParallelGroup().addComponent(personPanel).addComponent(doublePanel));
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(personPanel)
                        .addComponent(doublePanel)
        );
        setSize(500, 500);
        setLocation(100, 100);
        setVisible(true);
    }

    private static JPanel getPersonPanel() {
        JPanel panel = getNamedPanel("People");
        panel.add(new PersonPanel());
        return panel;
    }

    private static JPanel getDoublesPanel() {
        JPanel panel = getNamedPanel("Doubles");
        panel.add(new DoublePanel());
        return panel;
    }

    private static JPanel getNamedPanel(String title) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(title);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.NORTH);
        return panel;
    }
}