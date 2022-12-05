package control_work.template.kr1.first;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;

public abstract class Panel<T extends Comparable<T>> extends JPanel {
    private final JButton readFromFileButton = new JButton("Open file");
    private final JButton processDataButton = new JButton("Process data");
    private final JTextArea textArea = new JTextArea("Your data will be there");
    private ComparableContainer<T> container = null;

    public Panel() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.add(readFromFileButton);
        panel.add(processDataButton);
        this.add(panel, BorderLayout.NORTH);
        textArea.setEditable(false);
        this.add(new JScrollPane(textArea));
        //DragAndDropAdapter adapter = new DragAndDropAdapter(this);
        //new DropTarget(textArea, adapter);
        setupReadButton();
        setupProcessDataButton();
    }

    private void setupReadButton() {
        readFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                File workingDirectory = new File(System.getProperty("user.dir"));
                fileChooser.setCurrentDirectory(workingDirectory);
                int value = fileChooser.showDialog(Panel.this, "Select");
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    readDataFrom(selectedFile);
                }
            }
        });
    }

    private void displayData() {
        StringBuilder sb = new StringBuilder();
        for (T d : container) {
            sb.append(d).append('\n');
        }
        if (!(sb.length() == 0)) {
            sb.setLength(sb.length() - 1);
        }
        textArea.setText(sb.length() == 0 ? "No data" : sb.toString());
    }
    public void readDataFrom(File file) {
        String ERROR_TITLE = "Error";
        try {
            container = readFromFile(file);
            displayData();
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(Panel.this,
                    "There was an error while opening the file! File wasn't read.",
                    ERROR_TITLE, JOptionPane.WARNING_MESSAGE);
        } catch (InputMismatchException exception) {
            JOptionPane.showMessageDialog(Panel.this, "Wrong file format.",
                    ERROR_TITLE, JOptionPane.WARNING_MESSAGE);
        }
    }
    private void setupProcessDataButton() {
        processDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    T min = container.min();
                    T max = container.max();
                    JOptionPane.showMessageDialog(null, "min: " + min + "\nmax: " + max, "Process data", JOptionPane.INFORMATION_MESSAGE);
                }
                catch (EmptyCollectionException | NullPointerException exception) {
                    JOptionPane.showMessageDialog(Panel.this, "No data to process.", "Info", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    protected abstract ComparableContainer<T> readFromFile(File file) throws IOException;
}
