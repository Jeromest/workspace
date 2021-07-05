package com.example.model;

import com.example.util.Constant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * 棋盘的每一个格子
 */
public class Node {
    private int x;
    private int y;
    private int value;  //棋子的值
    private String path;    //棋子的图片路径
    private Position position;  //格子 | 棋子在二维数组中的位置

    public Node(int x, int y, Position position) {
        this.x = x;
        this.y = y;
        this.position = position;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * 画格子
     *
     * @param g
     */
    public void drawNode(Graphics g) {
        g.setColor(new Color(0, 0, 0));
        g.drawRect(this.x, this.y, Constant.NODE_W, Constant.NODE_W);
    }

    /**
     * 判断点击是否是当前格子应该落子的范围
     *
     * @return
     */
    public boolean clickNode(int x, int y) {
        int startX = this.x - Constant.R;
        int startY = this.y - Constant.R;
        int endX = this.x + Constant.R;
        int endY = this.y + Constant.R;
        if (x >= startX && x <= endX && y >= startY && y < endY) {
            return true;
        }
        return false;
    }

    /**
     * 将棋子落下
     *
     * @param g
     */
    public void playNode(Graphics g) {
        try {
            Image image = ImageIO.read(new File(this.path));
            g.drawImage(image,
                    this.x - Constant.PIECE_W / 2,
                    this.y - Constant.PIECE_W / 2,
                    Constant.PIECE_W,
                    Constant.PIECE_W, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
