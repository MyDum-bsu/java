package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;

public class MovingButtonApplication extends JFrame {
    private JPanel jPanel;
    public MovingButtonApplication() {
        super();
        initDefaultSet();
        JLabel jLabel = new JLabel("Радует ли вас размер стипендии?");
        jLabel.setForeground(Color.RED);
        add(jLabel, BorderLayout.NORTH);
        initPanel();
        initButtons();
        setVisible(true);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 300, dimension.height / 2 - 150, 600,300);
        setMinimumSize(new Dimension(600, 300));
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
    }

    private void initPanel() {
        jPanel = new JPanel(null);
        jPanel.setBackground(Color.BLACK);
        add(jPanel);
    }

    private void initButtons() {
        JButton answerButton = new JButton("НЕТ");
        answerButton.setSize(answerButton.getPreferredSize());
        answerButton.setLocation(getWidth()/20, getHeight()/20);
        JButton movingButton = new JButton("ДА");
        movingButton.setSize(movingButton.getPreferredSize());
        jPanel.add(answerButton) ;
        jPanel.add(movingButton);
        answerButton.addActionListener(actionEvent -> JOptionPane.showMessageDialog(this, "Ну больше она не станет", "Успокойся", JOptionPane.INFORMATION_MESSAGE ));
        movingButton.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                double dist = mouseEvent.getPoint().distance(mouseEvent.getPoint());
                if (dist  < 20) {
                    moveButton(dist);
                }
            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                mouseMoved(mouseEvent);
            }

            private void moveButton(double dist) {
                movingButton.setLocation(new Random().nextInt(600), new Random().nextInt(300));
            }
        });
        movingButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JOptionPane.showMessageDialog(MovingButtonApplication.this, "YOU ARE CHEATER!", "HOW!?", JOptionPane.ERROR_MESSAGE );
            }
        });
    }
}
