package lab8;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Application extends JFrame implements ActionListener {
    private JMenuItem menuItem;
    private JButton show;
    private JButton edit;
    private JButton add;
    private List list;
    private List sortedList;

    private ArrayList<Export> collection;

    public Application() {
        super("Lab 8");
        defaultSetInit();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        menuBarInit();
        listsInit();
        buttonsInit();
        setVisible(true);
    }

    private void defaultSetInit() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 400, dimension.height / 2 - 400, 800, 800);
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
        list = new List();
        sortedList = new List();
        list.setBackground(Color.BLACK);
        sortedList.setBackground(Color.BLACK);
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
        } else if (actionEvent.getSource().equals(menuItem)) {
            fileChooserInit();
        }
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
        ArrayList<String> lines = new ArrayList<>();
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(this, exception.getLocalizedMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return lines;
    }

    private void parseData(ArrayList<String> lines) {
        Scanner scanner;
        String name;
        String country;
        int quantity;
        for (String line : lines) {
            scanner = new Scanner(line);
            while (scanner.hasNext()) {
                try {
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
// TODO: выяснить, почему не работает открытие файла (кажется, collection == null)
// TODO: сделать задание 7 (в методе showDataFromCollection)
// TODO: дописать кнопки edit и add
    }
}
