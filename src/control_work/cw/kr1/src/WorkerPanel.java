package control_work.cw.kr1.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public abstract class WorkerPanel extends JPanel {
    private JButton openFileButton;
    private JButton calculateDataButton;
    private JTextArea jTextArea;

    ArrayList<Worker> container;

    public WorkerPanel() {
        container = new ArrayList<>();
        setLayout(new BorderLayout());
        initButtons();
    }

    public void initButtons() {
        openFileButton = new JButton("open File");
        openFileButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            File currentDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(currentDirectory);
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    container = readFromFile(file);
                    displayData();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "File wasn't read", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        calculateDataButton = new JButton("calculate data");
        calculateDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    double average = Container.averageSalary(container);
                    ArrayList<Worker> beginsWithB = Container.beginsWithB(container);
                    ArrayList<Worker> inDescendingOrder = Container.inDescendingOrder(container);
                    ArrayList<Worker> salaryPositionOrder = Container.inSalaryPositionOrder(container);
                    JOptionPane.showMessageDialog(null, "average: " + average + "\n");
            }
        });
        JPanel panel = new JPanel();
        panel.add(openFileButton);
        panel.add(calculateDataButton);
        add(panel, BorderLayout.NORTH);

    }

    private void displayData() {
        StringBuilder s = new StringBuilder();
        for (Worker worker : container) {
            s.append(worker).append("\n");
        }
        jTextArea.setText(s.toString());
    }

    protected abstract ArrayList<Worker> readFromFile(File file) throws IOException;

}

