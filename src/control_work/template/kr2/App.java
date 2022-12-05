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

    Stack<String> model;
    View<String> view;
    Controller<String> controller;

    JButton pop;
    JButton push;

    JLabel poppedText;
    JTextField textToPush;

    JList<String> list;

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
        textToPush = new JTextField(15);
        textToPush.setBackground(Color.BLACK);
        textToPush.setForeground(Color.CYAN);

        poppedText = new JLabel();
        poppedText.setBackground(Color.BLACK);
        poppedText.setForeground(Color.GREEN);

        panel.add(new JLabel("push: "));

        panel.add(textToPush);

        panel.add(new JLabel("pop: "));

        panel.add(poppedText);
        add(panel);
    }

    private void initList() {
        list = new JList<>(view.getListModel());
        add(new JScrollPane(list));
    }

    private void initMVC() {
        model = Stack.create();
        view = new View<>(model);
        controller = new Controller<>(model, view);
    }

    private void addAction() {
        pop.addActionListener(actionEvent -> {
            try {
                String text = controller.pop();
                poppedText.setText(text);
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
        JPanel panel = new JPanel();
        panel.add(pop);
        panel.add(push);
        add(panel);
    }

    private void defaultSetInit(int width, int height) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((dimension.width - width) / 2, (dimension.height - height) / 2, width, height);
        setMinimumSize(new Dimension(width, height));
        getContentPane().setBackground(Color.BLACK);
    }
}
