package com.example.view;


import com.example.controller.BaseFrameController;
import com.example.util.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 基本的窗体
 * 显示初始的内容
 * 设置：位置、大小、标题、背景
 */
public class BaseFrame extends JFrame {
    BaseFrameController baseFrameController = new BaseFrameController();

    public BaseFrame() {
        super.setLocation(Constant.WINDOW_X, Constant.WINDOW_Y);
        super.setSize(Constant.WINDOW_W, Constant.WINDOW_H);
        super.setTitle("五子棋");
        super.setBackground(new Color(61, 168, 220));
        super.setResizable(false);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); //退出程序
            }
        });

        super.setVisible(true);
    }

    /**
     * 绘制窗体内容
     * 棋盘
     * 图标
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        baseFrameController.paintCheckerBoard(g);
        baseFrameController.paintIcon(g);
    }
}
