package edu.seu.core.java.vol1.ch11.other;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.rmi.server.ExportException;

/**
 * @Author : josan
 * @Date : 2020/2/23 20:14
 * @Package : edu.seu.core.java.vol1.ch11.other
 * @ProjectName: pom-parent
 * @Description:
 */
public class BrowseFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public BrowseFrame() {
//        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // create buttons
        JButton baiduButton = new JButton("baidu");
        JButton taobaoButton = new JButton("taobao");
        JButton qqButton = new JButton("qq");

        buttonPanel = new JPanel();
        // add buttons to panel
        buttonPanel.add(baiduButton);
        buttonPanel.add(taobaoButton);
        buttonPanel.add(qqButton);

        // add panel to frame
        add(buttonPanel);

        // create button actions
        WebAction baiduAction = new WebAction("baidu");
        WebAction taobaoAction = new WebAction("taobao");
        WebAction qqAction = new WebAction("qq");

        // associate actions with buttons
        baiduButton.addActionListener(baiduAction);
        taobaoButton.addActionListener(taobaoAction);
        qqButton.addActionListener(qqAction);
    }

    private class WebAction implements ActionListener {
        private String name;

        public WebAction(String name) {
            this.name = name;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Desktop desktop = Desktop.getDesktop();

            try {
                switch (name) {
                    case "taobao":
                        desktop.browse(new URI("www.taobao.com"));
                        break;
                    case "baidu":
                        desktop.browse(new URI("www.baidu.com"));
                        break;
                    case "qq":
                        desktop.browse(new URI("www.qq.com"));
                        break;
                    default:
                        System.out.println("Not a defined action");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        return new Dimension(screenWidth / 2, screenHeight / 2);
    }
}

