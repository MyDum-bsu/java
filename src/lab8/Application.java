package lab8;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Application extends JFrame implements ActionListener {
    private JMenuItem menuItem;
    private JButton show;
    private JButton edit;
    private JButton add;
    private List list;
    private List sortedList;

    private JTextField nameFilter;
    private JLabel totalQuantity;

    private ArrayList<Export> collection;

    public Application() {
        super("Lab 8");
        defaultSetInit();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        menuBarInit();
        countryFilterInit();
        listsInit();
        buttonsInit();
        setVisible(true);
    }

    private void countryFilterInit() {
        Box box = new Box(2);
        JLabel label = new JLabel("Name:");
        label.setForeground(Color.RED);
        nameFilter = new JTextField();
        nameFilter.setBackground(Color.BLACK);
        nameFilter.setForeground(Color.GREEN);
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setForeground(Color.RED);
        totalQuantity = new JLabel("0");
        totalQuantity.setForeground(Color.YELLOW);
        box.add(label);
        box.add(nameFilter);
        box.add(totalLabel);
        box.add(totalQuantity);
        add(box);
        pack();
    }

    private void defaultSetInit() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 100, 600, 200);
        setMinimumSize(new Dimension(600, 200));
        getContentPane().setBackground(Color.BLACK);
    }

    private void menuBarInit() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuItem = new JMenuItem("Open");

        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void listsInit() {
        collection = new ArrayList<>();
        list = new List();
        sortedList = new List();
        list.setBackground(Color.BLACK);
        sortedList.setBackground(Color.BLACK);
        list.setForeground(Color.WHITE);
        sortedList.setForeground(Color.WHITE);
        Box box = new Box(2);
        box.add(list);
        box.add(sortedList);
        add(box);
    }

    private void buttonsInit() {
        show = new JButton("Show");
        edit = new JButton("Edit");
        add = new JButton("Add");
        Box box = new Box(2);
        addButtonToBox(show, box);
        addButtonToBox(edit, box);
        addButtonToBox(add, box);
        add(box);
        pack();
    }

    private void addButtonToBox(JButton button, Box box) {
        button.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(button);
        box.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(show)) {
            showDataFromCollection(list, collection);
            showDataFromCollection(sortedList, sortByName());
        } else if (actionEvent.getSource().equals(menuItem)) {
            fileChooserInit();
        } else if (actionEvent.getSource().equals(add)) {
            Export export = new Export();
            new AddExportDialog(this, export);
            if (!export.equals(new Export())) {
                collection.add(export);
            }
            showDataFromCollection(list, collection);
        } else if (actionEvent.getSource().equals(edit)) {
            int index = list.getSelectedIndex();
            if (index != -1) {
                new AddExportDialog(this, collection.get(index));
                showDataFromCollection(list, collection);
                showDataFromCollection(sortedList, sortByName());
            }
        }
    }

    private ArrayList<Export> sortByName() {
        sortedList.removeAll();
        String name = nameFilter.getText();
        AtomicInteger total = new AtomicInteger();
        ArrayList<Export> sorted = (ArrayList<Export>) collection.stream().filter(export -> export.getName().equals(name)).peek(export -> total.addAndGet(export.getQuantity())).collect(Collectors.toList());
        totalQuantity.setText(String.valueOf(total));
        return sorted;
    }

    private void fileChooserInit() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Path path = fileChooser.getSelectedFile().toPath();
            parseData(readDataFromFile(path));
        }
    }

    private void showDataFromCollection(List list, ArrayList<Export> collection) {
        if (collection != null) {
            list.removeAll();
            for (Export export : collection) {
                list.add(export.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "No elements", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<String> readDataFromFile(Path path) {
        try {
            return (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this, exception.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return new ArrayList<>();
    }

    private void parseData(ArrayList<String> lines) {
        String name;
        String country;
        int quantity;
        for (String line : lines) {
            try (Scanner scanner = new Scanner(line)) {
                name = scanner.next();
                country = scanner.next();
                quantity = scanner.nextInt();
                if (scanner.hasNext()) {
                    JOptionPane.showMessageDialog(this, "wrong data", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                collection.add(new Export(name, country, quantity));
            } catch (InputMismatchException exception) {
                JOptionPane.showMessageDialog(this, "wrong data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
