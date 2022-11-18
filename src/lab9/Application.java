package lab9;

import lab8.AddExportDialog;
import lab8.Export;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Application extends lab8.Application {
    private Set<Export> set;
    private Set<Export> filteredSet;

    JList<Export> list;
    DefaultListModel<Export> listModel;
    JList<Export> filteredList;
    DefaultListModel<Export> filteredListModel;

    public Application() {
        super("Lab 9");
    }

    @Override
    protected void listsInit() {
        set = new Set<>();
        filteredSet = new Set<>();
        listModel = new DefaultListModel<>();
        filteredListModel = new DefaultListModel<>();
        list = new JList<>(set.getListModel());
        filteredList = new JList<>(filteredSet.getListModel());
        Box box = new Box(2);
        box.add(list);
        box.add(filteredList);
        add(box);
    }

    private Set<Export> sortByName() {
        filteredSet.clear();
        String name = nameFilter.getText();
        AtomicInteger total = new AtomicInteger();
        ArrayList<Export> sorted = (ArrayList<Export>) set.toArrayList().stream().filter(export -> export.getName().equals(name)).peek(export -> total.addAndGet(export.getQuantity())).collect(Collectors.toList());
        Set<Export> set = new Set<>();
        set.addAll(sorted);
        totalQuantity.setText(String.valueOf(total));
        return set;
    }

    private void showDataFromSet(JList<Export> list, Set<Export> set) {
        if (set != null) {
            list.removeAll();
            listModel = set.getListModel();
            while (set.hasNext()) {
                Export export = set.next();
                listModel.addElement(export);
            }
            list.setModel(listModel);
        } else {
            JOptionPane.showMessageDialog(this, "No elements", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(show)) {
            showDataFromSet(list, set);
            showDataFromSet(filteredList, sortByName());
        } else if (actionEvent.getSource().equals(menuItem)) {
            fileChooserInit();
        } else if (actionEvent.getSource().equals(add)) {
            Export export = new Export();
            new AddExportDialog(this, export);
            if (!export.equals(new Export())) {
                set.add(export);
            }
            showDataFromSet(list, set);
        } else if (actionEvent.getSource().equals(edit)) {
            int index = list.getSelectedIndex();
            if (index != -1) {
                new AddExportDialog(this, set.toArrayList().get(index));
                showDataFromSet(list, set);
                showDataFromSet(filteredList, sortByName());
            }
        }
    }

    @Override
    protected void parseData(ArrayList<String> lines) {
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
                set.add(new Export(name, country, quantity));
            } catch (InputMismatchException exception) {
                JOptionPane.showMessageDialog(this, "wrong data", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
