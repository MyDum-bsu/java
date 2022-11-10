package lab7;

import javax.swing.*;
import java.awt.*;

public class FirstCard extends JPanel {
    final String[] leftData = {"Manjaro", "Linux Mint", "Debian", "Ubuntu", "Clear Linux", "MX Linux", "Zorin OS", "Lubuntu", "Linux Lite", "Fedora"};
    final String[] rightData = {"Petuxon", "JavaStriptizer", "Jaba", "C", "C++", "Go"};
    private JButton rightButton;
    private JButton leftButton;

    private DefaultListModel<String> leftListModel = new DefaultListModel<>();
    private DefaultListModel<String> rightListModel = new DefaultListModel<>();
    private JList<String> leftList;
    private JList<String> rightList;

    FirstCard() {
        setLayout(new BorderLayout());
        initButtons();
        initData();
        addActionListener();
    }

    private void initButtons() {
        rightButton = new JButton(new ImageIcon("src/lab7/img/right.png"));
        leftButton = new JButton(new ImageIcon("src/lab7/img/left.png"));
        JPanel center = new JPanel(new BorderLayout());
        center.add(rightButton, BorderLayout.NORTH);
        center.add(leftButton, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
    }

    private void initData() {
        leftListModel = new DefaultListModel<>();
        rightListModel = new DefaultListModel<>();
        for (String data : leftData) {
            leftListModel.addElement(data);
        }
        for (String data : rightData) {
            rightListModel.addElement(data);
        }
        leftList = new JList<>(leftListModel);
        rightList = new JList<>(rightListModel);
        add(leftList, BorderLayout.WEST);
        add(rightList, BorderLayout.EAST);
    }

    private void addActionListener() {
        rightButton.addActionListener(actionEvent -> {
            for (String s : leftList.getSelectedValuesList()) {
                rightListModel.addElement(s);
                leftListModel.removeElement(s);
            }
        });
        leftButton.addActionListener(actionEvent -> {
            for (String s : rightList.getSelectedValuesList()) {
                leftListModel.addElement(s);
                rightListModel.removeElement(s);
            }
        });
    }
}
