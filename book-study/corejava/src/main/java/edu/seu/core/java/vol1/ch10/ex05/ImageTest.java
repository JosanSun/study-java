package edu.seu.core.java.vol1.ch10.ex05;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author : josan
 * @Date : 2020/2/23 19:15
 * @Package : edu.seu.core.java.vol1.ch10.ex05
 * @ProjectName: pom-parent
 * @Description:
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private Image image;

    public ImageComponent() {
        URL fileURL = ImageComponent.class.getResource("/images/fileIcon.png");
        image = new ImageIcon(fileURL).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (image == null) {
            return ;
        }

        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // draw the image in the upper-left corner
        g.drawImage(image, 0, 0, null);

        // tile the image across the component
//        for (int i = 0; i * imageWidth <= getWidth(); i++) {
//            for (int j = 0; j * imageHeight <= getHeight(); j++) {
//                if (i + j > 0) {
//                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
//                }
//            }
//        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}