package control_work.template.kr2;

import control_work.template.kr2.mvc.Controller;
import control_work.template.kr2.mvc.Stack;
import control_work.template.kr2.mvc.View;
import control_work.template.kr2.strategy.IteratorStrategy;
import control_work.template.kr2.strategy.Strategy;
import control_work.template.kr2.strategy.VisitorStrategy;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    public static void main(String[] args) {
        new App();
    }

    private Stack<String> model;
    private View<String> view;
    private Controller<String> controller;
    private JButton pop;
    private JButton push;

    private JLabel poppedText;
    private JTextField textToPush;
    private Strategy iteratorStrategy;
    private Strategy visitorStrategy;
    private JLabel sizeLabel;
    private final Font font = new Font("Courier", Font.PLAIN, 90);

    App() {
        defaultSetInit(1000, 500);
        setLayout(new GridLayout(0, 1));
        initMVC();
        initList();
        initButtons();
        initLabels();
        addAction();
        addStrategy();
        setVisible(true);
    }

    private void addStrategy() {
        iteratorStrategy = new IteratorStrategy();
        visitorStrategy = new VisitorStrategy();
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        sizeLabel = new JLabel("size: ");
        sizeLabel.setForeground(Color.ORANGE);
        sizeLabel.setFont(font);
        panel.add(sizeLabel);
        add(panel);
    }

    private void initLabels() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        textToPush = new JTextField(15);
        textToPush.setBackground(Color.BLACK);
        textToPush.setForeground(Color.CYAN);
        textToPush.setFont(new Font("Courier", Font.PLAIN, 45));

        poppedText = new JLabel();
        poppedText.setBackground(Color.BLACK);
        poppedText.setForeground(Color.GREEN);
        poppedText.setFont(new Font("Courier", Font.PLAIN, 45));
        addLabel("push: ", panel);
        panel.add(textToPush);
        addLabel("pop: ", panel);
        panel.add(poppedText);
        add(panel);
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
        model = Stack.create();
        view = new View<>(model);
        controller = new Controller<>(model, view);
    }

    private void addAction() {
        pop.addActionListener(actionEvent -> {
            try {
                String text = controller.pop();
                setTextToLabel(poppedText, text);
                setTextToLabel(sizeLabel, "size: " + iteratorStrategy.countSize(model) + " -- " + visitorStrategy.countSize(model));
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        });
        push.addActionListener(actionEvent -> {
            if (!textToPush.getText().isEmpty()) {
                controller.push(textToPush.getText());
                setTextToLabel(sizeLabel, "size: " + iteratorStrategy.countSize(model) + " -- " + visitorStrategy.countSize(model));
            }
        });
    }

    private void setTextToLabel(JLabel sizeLabel, String text) {
        sizeLabel.setText(text);
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
