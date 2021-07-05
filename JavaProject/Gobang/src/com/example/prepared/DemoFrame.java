package com.example.prepared;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 窗体类
 */
public class DemoFrame extends JFrame {

    /**
     * 对窗体进行一些必要的设置
     */
    public DemoFrame() {
        super.setLocation(100, 100);
        super.setSize(300, 300);
        super.setTitle("Hello");
        super.setBackground(new Color(8, 9, 134));
        super.setResizable(false);  //窗体不能改变大小

        //添加事件监听
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //点击关闭按钮退出程序
                System.exit(0);
            }
        });

        super.setVisible(true); //设置窗体可见
    }

    /**
     * 绘制窗体内容
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 100, 200, 200);
        g.drawRect(200, 200, 50, 50);
//        g.fillRect(200, 200, 50, 50);

    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}
