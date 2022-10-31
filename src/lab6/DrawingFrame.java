package lab6;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class DrawingFrame extends JFrame {
    DrawingPanel contentPanel;

    JPanel toolkitPanel;

    public DrawingFrame() {
        super("Drawing Frame");
        initDefaultSet();
        contentPanel = new DrawingPanel(Color.ORANGE);
        contentPanel.setBorder(LineBorder.createGrayLineBorder());
        toolkitPanel = new JPanel();
        toolkitPanel.setBackground(Color.BLACK);
        initColorButtons();
        initSaving();
        initScrollPane();
        setVisible(true);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 4 - 300, dimension.height / 2 - 150, 600, 300);
        setMinimumSize(new Dimension(600, 300));
        setBackground(Color.BLACK);
    }

    private void initColorButtons() {
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButton redButton = initColorButton("red", Color.RED);
        JRadioButton greenButton = initColorButton("green", Color.GREEN);
        JRadioButton blueButton = initColorButton("blue", Color.BLUE);

        buttonGroup.add(redButton);
        buttonGroup.add(greenButton);
        buttonGroup.add(blueButton);

        toolkitPanel.add(redButton);
        toolkitPanel.add(greenButton);
        toolkitPanel.add(blueButton);

        add(toolkitPanel, BorderLayout.NORTH);
    }

    private JRadioButton initColorButton(String name, Color color) {
        JRadioButton colorButton = new JRadioButton(name);
        colorButton.addActionListener(actionEvent -> contentPanel.setColor(color));
        return colorButton;
    }

    private void initSaving() {
        JButton saveButton = new JButton("save");
        toolkitPanel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    savePanelContentAsImage();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(DrawingFrame.this, e.getLocalizedMessage(), "Error!", JOptionPane.PLAIN_MESSAGE);
                }
            }

            private void savePanelContentAsImage() throws IOException {
                BufferedImage img = new BufferedImage(contentPanel.getWidth(), contentPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                contentPanel.paint(img.getGraphics());
                ImageIO.write(img, "png", Objects.requireNonNull(GetFile()));
            }
        });
    }

    private File GetFile() {
        JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
        chooser.setCurrentDirectory(workingDirectory);
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            return chooser.getSelectedFile();
        else
            return null;
    }

    private void initScrollPane() {
        JScrollPane scrollPane = new JScrollPane(contentPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.createVerticalScrollBar();
        scrollPane.createHorizontalScrollBar();
        scrollPane.setVisible(true);
        add(scrollPane);
    }



}
