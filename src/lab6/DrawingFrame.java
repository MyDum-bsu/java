package lab6;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.AWTEventListener;

public class DrawingFrame extends JFrame {
    DrawingPanel panel;

    JPanel colorPanel;

    public DrawingFrame() {
        super("Drawing Frame");
        initDefaultSet();
        panel = new DrawingPanel(Color.ORANGE);
        panel.setBorder(LineBorder.createGrayLineBorder());
        initColorButtons();
        initScrollPane();

        //add(panel);
        setVisible(true);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 150, 600, 300);
        setMinimumSize(new Dimension(600, 300));
        setBackground(Color.BLACK);
    }

    private void initColorButtons() {
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton redButton = initColorButton("red", Color.RED);
        JRadioButton greenButton = initColorButton("green", Color.GREEN);
        JRadioButton blueButton = initColorButton("blue", Color.BLUE);

        colorPanel = new JPanel(new FlowLayout());
        colorPanel.setBackground(Color.BLACK);

        buttonGroup.add(redButton);
        buttonGroup.add(greenButton);
        buttonGroup.add(blueButton);

        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(blueButton);

        add(colorPanel, BorderLayout.NORTH);
    }

    private JRadioButton initColorButton(String name, Color color) {
        JRadioButton colorButton = new JRadioButton(name);
        colorButton.addActionListener(actionEvent -> panel.setColor(color));
        return colorButton;
    }

    private void initScrollPane() {
        JScrollPane scrollPane = new JScrollPane(panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.createVerticalScrollBar();
        scrollPane.createHorizontalScrollBar();
        scrollPane.setVisible(true);
        add(scrollPane);
    }
}
