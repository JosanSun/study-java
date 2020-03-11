package edu.seu.core.java.vol1.ch10.other;

import java.awt.*;

/**
 * @Author : josan
 * @Date : 2020/2/23 18:56
 * @Package : edu.seu.core.java.vol1.ch10.other
 * @ProjectName: pom-parent
 * @Description:
 */
public class ListFonts {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAvailableFontFamilyNames();
        for (String fontName : fontNames) {
            System.out.println(fontName);
        }

        System.out.println();
    }
}
