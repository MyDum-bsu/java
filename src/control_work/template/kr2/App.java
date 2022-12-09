package control_work.template.kr2;

import control_work.template.kr2.mvc.Controller;
import control_work.template.kr2.mvc.Stack;
import control_work.template.kr2.mvc.View;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public static void main(String[] args) {
        new App();
    }

    private View<String> view;
    private Controller controller;
    private JButton pop;
    private JButton push;

    private JTextField textToPush;

    App() {
        defaultSetInit(1000, 500);
        setLayout(new GridLayout(0, 1));
        initMVC();
        initList();
        initButtons();
        initLabels();
        addAction();
        setVisible(true);
    }

    private void initLabels() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        textToPush = new JTextField(15);
        textToPush.setBackground(Color.BLACK);
        textToPush.setForeground(Color.CYAN);
        textToPush.setFont(new Font("Courier", Font.PLAIN, 45));

        JLabel poppedText = view.getPoppedTextLabel();
        JLabel sizeLabel = view.getSizeLabel();
        addLabel("push: ", panel);
        panel.add(textToPush);
        addLabel("pop: ", panel);
        panel.add(poppedText);
        JPanel jPanel = new JPanel();
        jPanel.setBackground(Color.BLACK);
        jPanel.add(sizeLabel);
        add(panel);
        add(jPanel);
    }

    private void addLabel(String text, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Courier", Font.PLAIN, 45));
        label.setForeground(Color.WHITE);
        panel.add(label);
    }

    private void initList() {
        JList<String> list = new JList<>(view.getListModel());
        list.setBackground(Color.BLACK);
        list.setForeground(Color.GREEN);
        list.setFont(new Font("Courier", Font.PLAIN, 25));
        add(new JScrollPane(list));
    }

    private void initMVC() {
        Stack<String> model = Stack.create();
        view = new View<>(model);
        controller = new Controller(model, view);
    }

    private void addAction() {
        pop.addActionListener(actionEvent -> {
            try {
                controller.pop();
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        });
        push.addActionListener(actionEvent -> {
            if (!textToPush.getText().isEmpty()) {
                controller.push(textToPush.getText());
            }
        });
    }

    private void initButtons() {
        pop = new JButton("pop");
        push = new JButton("push");
        buttonStyle(pop);
        buttonStyle(push);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.add(pop);
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
