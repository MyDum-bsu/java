package control_work.cw.kr1.src;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {
    Application() {
        JPanel seller = new SellerPanel();
        JPanel security = new SecurityPanel();
        initDefaultSet();
        add(security, BorderLayout.WEST);
        add(seller, BorderLayout.EAST);
        setVisible(true);
    }

    private void initDefaultSet() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(dimension.width / 2 - 500, dimension.height / 2 - 300, 1000, 600);
        setMinimumSize(new Dimension(1000, 600));
        setBackground(Color.BLACK);
    }
}
