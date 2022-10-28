package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawingFrame extends JFrame {
    private JRadioButton redButton;
    private JRadioButton greenButton;
    private JRadioButton blueButton;

    private PanelHandler panel;

    public DrawingFrame() {
        super("Drawing Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1, 0, 0));
        setMinimumSize(new Dimension(600, 500));
        initColorButtons();

        panel = new PanelHandler();
        JScrollPane scrollPane = new JScrollPane(panel);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setBounds(50, 30, 300, 50);
//        JPanel contentPane = new JPanel(null);
//        contentPane.setPreferredSize(new Dimension(500, 400));
//        contentPane.add(scrollPane);
//        setContentPane(contentPane);
//        pack();
        add(scrollPane);
        setVisible(true);
    }

    private void initColorButtons() {
        JPanel panel = new JPanel(new FlowLayout());
        redButton = new JRadioButton("red");
        redButton.setSelected(true);
        greenButton = new JRadioButton("green");
        blueButton = new JRadioButton("blue");

        ButtonGroup group = new ButtonGroup();
        group.add(redButton);
        group.add(greenButton);
        group.add(blueButton);

        panel.add(redButton);
        panel.add(greenButton);
        panel.add(blueButton);
        add(panel);
    }

    private class PanelHandler extends JPanel {
        @Override
        public void paint(Graphics graphics) {
            super.paint(graphics);
        }

    }
}
