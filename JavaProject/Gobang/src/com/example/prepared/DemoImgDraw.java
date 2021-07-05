package com.example.prepared;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class DemoImgDraw extends JFrame {
    private boolean flag = false;   //  是否要显示图片

    public DemoImgDraw() {
        super.setLocation(100, 100);
        super.setSize(600, 600);
        super.setTitle("Hello");
        super.setBackground(new Color(80, 191, 217));
        super.setResizable(false);  //窗体不能改变大小

        //添加事件监听
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //点击关闭按钮退出程序
                System.exit(0);
            }
        });

        //鼠标单击事件
        super.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                flag = true;
                //手动重绘窗体
                repaint();
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
        if (flag) {
            drawImg(g);
        }
    }

    private void drawImg(Graphics g) {
        try {
            //1、先读取图片
            Image image = ImageIO.read(new File("images/test.png"));
            //2、将图片画到窗体上
            g.drawImage(image, 0, 0, null);
//            g.drawImage(image, 0, 0, 300, 300, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DemoImgDraw();
    }
}
