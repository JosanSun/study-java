package edu.seu.core.java.vol1.ch10.ex01;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author : josan
 * @Date : 2020/2/23 16:23
 * @Package : edu.seu.core.java.vol1.ch10.ex01
 * @ProjectName: pom-parent
 * @Description:
 */
public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SimpleFram simpleFram = new SimpleFram();
            // 关闭所有框架装饰
//            simpleFram.setUndecorated(true);
            // EXIT_ON_CLOSE 保证图片关闭的时候，程序也关闭  默认是不关闭的
            simpleFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            simpleFram.setVisible(true);
            simpleFram.setLocation(100, 200);
            simpleFram.setTitle("first frame");

//            Image image = new ImageIcon("D:\\code\\mycode\\java\\study-java\\book-study\\corejava\\src\\main\\resources\\images\\fileIcon.png").getImage();
            // 在根目录下面, 而不是资源路径下面
//            Image image = new ImageIcon("images/fileIcon.png").getImage();

            // 以后统一使用这个方法，进行书写
            URL fileURL = SimpleFrameTest.class.getResource("/images/fileIcon.png");
            Image image = new ImageIcon(fileURL).getImage();

            simpleFram.setIconImage(image);
            // 框架大小是否可变  默认是true
            simpleFram.setResizable(false);
        });
    }
}

class SimpleFram extends JFrame {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    public SimpleFram() throws HeadlessException {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
