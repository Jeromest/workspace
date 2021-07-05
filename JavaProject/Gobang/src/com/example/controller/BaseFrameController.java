package com.example.controller;

import com.example.model.CheckerBoard;
import com.example.model.Node;
import com.example.util.Constant;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 基本界面的处理
 * 绘制棋盘
 * 绘制图标
 */
public class BaseFrameController {
    /**
     * 绘制棋盘
     * 遍历棋盘，利用棋子自身的绘制功能将自己展示
     */
    public void paintCheckerBoard(Graphics g) {
        for (Node[] nodes : CheckerBoard.checkerBoard) {
            for (Node node : nodes) {
                node.drawNode(g);
            }
        }
    }

    /**
     * 画图标
     * 白子
     * 黑子
     * 重来
     *
     * @param g
     */
    public void paintIcon(Graphics g) {
        try {
            Image whiteImg = ImageIO.read(new File(Constant.WHITE_ICON));
            Image blackImg = ImageIO.read(new File(Constant.BLACK_ICON));
            Image restartImg = ImageIO.read(new File(Constant.RESTART_ICON));
            g.drawImage(whiteImg, Constant.WHITE_ICON_X, Constant.WHITE_ICON_Y, Constant.ICON_W, Constant.ICON_H, null);
            g.drawImage(blackImg, Constant.BLACK_ICON_X, Constant.BLACK_ICON_Y, Constant.ICON_W, Constant.ICON_H, null);
            g.drawImage(restartImg, Constant.RESTART_ICON_X, Constant.RESTART_ICON_Y, Constant.ICON_W, Constant.ICON_H, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
