package lab4;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Paths;

public class SeriesApplication extends JFrame {
    Dimension dimension;
    private Series series;
    private JTextField nTextField;
    private JTextField fTextField;
    private JTextField dTextField;
    private JTextField path;
    private JRadioButton linear;
    private JRadioButton exponential;
    JButton start;
    JButton save;

    JTextArea text;

    public SeriesApplication(int width, int height) {
        setDefaultParameters(width, height);
        createParameterTextFields();
        addParameterTextFields();

        createTypeButton();
        addTypeButton();
        createAndAddStartButton();
        createAndAddSaveButton();
        createAndAddSeriesText();
        setLocation();
    }

    private void setDefaultParameters(int width, int height) {
        setTitle("Series");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        setLayout(new FlowLayout());
        setVisible(true);
    }

    private void createParameterTextFields() {
        nTextField = new JTextField("n");
        fTextField = new JTextField("f");
        dTextField = new JTextField("d");
        path = new JTextField("path");
    }

    private void addParameterTextFields() {
        add(nTextField);
        add(fTextField);
        add(dTextField);
        add(path);
    }

    private void createTypeButton() {
        linear = new JRadioButton();
        linear.setSelected(true);
        exponential = new JRadioButton();
    }

    private void addTypeButton() {
        ButtonGroup group = new ButtonGroup();
        group.add(linear);
        group.add(exponential);
        add(linear);
        add(exponential);
    }

    private void createAndAddStartButton() {
        start = new JButton("start");
        add(start);
        start.addActionListener(actionEvent -> {
            try {
                createSeries();
                text.setText(series.toString());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(SeriesApplication.this, "Wrong parameters type!", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    private void createSeries() {
        int n = Integer.parseInt(nTextField.getText());
        double f = Double.parseDouble(fTextField.getText());
        double d = Double.parseDouble(dTextField.getText());
        if (linear.isSelected()) {
            series = new Liner(n, f, d);
        } else {
            series = new Exponential(n, f, d);
        }
    }

    private void createAndAddSaveButton() {
        save = new JButton("save to file");
        add(save);
        save.addActionListener(actionEvent -> {
            try {
                series.saveToFile(Paths.get(path.getText()));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(SeriesApplication.this, e.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private void setLocation() {
    }

    private void createAndAddSeriesText() {
        text = new JTextArea();
        add(text);
    }
}
