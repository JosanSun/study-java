package edu.seu.core.java.vol1.ch11.ex01;

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
            JFrame frame = new ButtonFrame();
            frame.setTitle("buttonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
