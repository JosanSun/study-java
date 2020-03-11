package edu.seu.core.java.vol1.ch11.other;

import javax.swing.*;
import java.awt.*;

/**
 * @Author : josan
 * @Date : 2020/2/23 20:02
 * @Package : edu.seu.core.java.vol1.ch11.ex01
 * @ProjectName: pom-parent
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BrowseFrame();

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            frame.setSize(screenWidth / 2, screenHeight / 2);
            frame.setLocation(screenWidth / 4, screenHeight / 4);
            

            frame.setTitle("browseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
