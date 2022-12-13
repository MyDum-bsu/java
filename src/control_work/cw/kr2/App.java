package control_work.cw.kr2;
import control_work.cw.kr2.mvc.View;
import control_work.cw.kr2.mvc.Controller;
import control_work.cw.kr2.mvc.Set;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class App extends JFrame {

    private View view;
    private Controller controller;
    private JButton save;
    private JButton push;

    private JTextField textToPush;

    public static App create() {
        return new App();
    }

    private App() {
        defaultSetInit(1000, 500);
        setLayout(new GridLayout(0, 1));
        initMVC();
        initList();
        initButtons();
        initLabels();
        addAction();
        setVisible(true);
    }

    private void initMVC() {
        Set model = Set.create();
        view = new View(model);
        controller = new Controller(model, view);
    }

    private void initLabels() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        textToPush = new JTextField(15);
        textToPush.setBackground(Color.BLACK);
        textToPush.setForeground(Color.CYAN);
        textToPush.setFont(new Font("Courier", Font.PLAIN, 45));

        JLabel sizeLabel = view.getCardinalityLabel();
        addLabel("push: ", panel);
        panel.add(textToPush);
        addLabel("set: ", panel);
        JLabel invertedSetLabel = view.getInvertedSetLabel();
        panel.add(invertedSetLabel);
        panel.add(sizeLabel);
        add(panel);
    }

    private void addLabel(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Courier", Font.PLAIN, 45));
        label.setForeground(Color.WHITE);
        panel.add(label);
    }

    private void initList() {
        JList<Integer> list = new JList<>(view.getListModel());
        list.setBackground(Color.BLACK);
        list.setForeground(Color.GREEN);
        list.setFont(new Font("Courier", Font.PLAIN, 25));
        add(new JScrollPane(list));
    }


    private void addAction() {
        save.addActionListener(actionEvent -> {
            try {
                JFileChooser fileChooser = initFileChooser();
                if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                    controller.save(fileChooser.getSelectedFile());
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "wrong!", "WRONG", JOptionPane.ERROR_MESSAGE);
            }
        });
        push.addActionListener(actionEvent -> {
            if (!textToPush.getText().isEmpty()) {
                try {
                    controller.add(Integer.parseInt(textToPush.getText()));
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, e.getLocalizedMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private JFileChooser initFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        File workingDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setCurrentDirectory(workingDirectory);
        return fileChooser;
    }

    private void initButtons() {
        save = new JButton("save");
        push = new JButton("push");
        buttonStyle(save);
        buttonStyle(push);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(save);
        panel.add(push);
        add(panel);
    }

    private void buttonStyle(JButton button) {
        button.setFont(new Font("Courier", Font.PLAIN, 30));
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
    }

    private void defaultSetInit(int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        setMinimumSize(new Dimension(width, height));
        getContentPane().setBackground(Color.BLACK);
    }
}
