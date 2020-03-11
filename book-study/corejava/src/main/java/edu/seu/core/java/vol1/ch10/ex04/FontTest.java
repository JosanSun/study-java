package edu.seu.core.java.vol1.ch10.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * @Author : josan
 * @Date : 2020/2/23 19:01
 * @Package : edu.seu.core.java.vol1.ch10.ex04
 * @ProjectName: pom-parent
 * @Description:
 */
public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class FontFrame extends JFrame {
    public FontFrame() throws HeadlessException {
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        String message = "Hello, World";

        Font f = new Font("Serif", Font.BOLD, 80);
        g2.setFont(f);

        // measure the size of the message
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message, context);

        // set (x, y) = top left corner of text
        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;

        // add ascent to y to reach the baseline
        double ascent = -bounds.getY();
        double baseY = y + ascent;

        // draw the message
        g2.drawString(message, (int)x, (int)baseY);
        g2.setPaint(Color.RED);

        // draw the baseline
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));

        // draw the enclosing rectangle
        Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
