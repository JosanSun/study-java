package edu.seu.core.java.vol1.ch10.ex02;

import javax.swing.*;
import java.awt.*;

/**
 * @Author : josan
 * @Date : 2020/2/23 18:02
 * @Package : edu.seu.core.java.vol1.ch10.ex02
 * @ProjectName: pom-parent
 * @Description:
 */
public class NotHelloWorld {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWorldFrame();
            frame.setTitle("NotHelloWorld");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class NotHelloWorldFrame extends JFrame {
    public NotHelloWorldFrame() {
        add(new NotHelloWorldComponent());
        // 调整窗口的大小
        pack();
    }
}

class NotHelloWorldComponent extends JComponent {
    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 400;


    @Override
    public void paintComponent(Graphics g) {
        Font sansBold14 = new Font("SansSerif", Font.BOLD, 28);

        Font origin = g.getFont();
        g.setFont(sansBold14);
        g.drawString("Not a hello, World program", MESSAGE_X, MESSAGE_Y);
        g.setFont(origin);
    }

    @Override
    public Dimension getPreferredSize() {
        // 这个是设计的是组件的大小，不是字体的大小
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
