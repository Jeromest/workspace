package com.example.view;

import com.example.controller.MainFrameController;
import com.example.model.Stamp;
import com.example.util.Constant;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 主界面
 * 1、监听用户的鼠标单击事件
 */
public class MainFrame extends BaseFrame {
    //创建处理器
    MainFrameController mainFrameController = new MainFrameController();

    public MainFrame() {
        //添加鼠标监听事件
        super.addMouseListener(new MouseAdapter() {
            //单击事件的处理
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标当前点击的位置
                Point point = e.getPoint();
                if (!Stamp.isGameStart()) {
                    if (!Stamp.isWin()) {
                        //选先手，开始游戏
                        mainFrameController.chooseStart(point);
                    } else {
                        if (mainFrameController.replay(point)) {
                            repaint();
                        }
                    }
                } else {
                    //游戏开始了，进行落子操作
                    if (mainFrameController.placing(point)) {
                        //重新绘制窗体
                        repaint();
                    }

                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (!Stamp.isGameStart()) {
            //清空窗体内容
            g.clipRect(0, 0, Constant.WINDOW_W, Constant.WINDOW_H);
            super.paint(g);
        }
        if (Stamp.isGameStart() && Stamp.getCurrentNode() != null) {
            //绘制当前的落子
            Stamp.getCurrentNode().playNode(g);
            if (Stamp.isWin()) {
                mainFrameController.msg(g);
                //所有的状态回到最初，除了赢了的标记
                mainFrameController.init();
            }
        }
    }
}
