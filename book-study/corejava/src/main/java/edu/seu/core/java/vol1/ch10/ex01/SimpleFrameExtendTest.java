package edu.seu.core.java.vol1.ch10.ex01;

import javax.swing.*;
import java.awt.*;

/**
 * @Author : josan
 * @Date : 2020/2/23 16:23
 * @Package : edu.seu.core.java.vol1.ch10.ex01
 * @ProjectName: pom-parent
 * @Description:
 */
public class SimpleFrameExtendTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFram simpleFram = new SimpleFram();

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

            simpleFram.setSize(screenWidth / 2, screenHeight / 2);
            simpleFram.setLocation(screenWidth / 4, screenHeight / 4);
            simpleFram.setTitle("first frame");

            simpleFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFram.setVisible(true);
        });
    }
}