package com.example.controller;

import com.example.model.CheckerBoard;
import com.example.model.Node;
import com.example.model.Position;
import com.example.model.Stamp;
import com.example.util.Constant;

import java.awt.*;

/**
 * 主界面操作的处理
 */
public class MainFrameController {

    /**
     * 选先手：开始游戏
     * 根据坐标判断点击的是哪一个图标（黑、白）
     * 修改状态开始游戏
     *
     * @param point
     */
    public void chooseStart(Point point) {
        //选择了白棋
        if (Constant.WHITE_ICON_X <= point.x && point.x <= Constant.WHITE_ICON_X + Constant.ICON_H
                && Constant.WHITE_ICON_Y <= point.y && point.y <= Constant.WHITE_ICON_Y + Constant.ICON_H) {
            Stamp.setGameStart(true);
            Stamp.setWhich(1);
            return;
        }
        //选择了黑棋
        if (Constant.BLACK_ICON_X <= point.x && point.x <= Constant.BLACK_ICON_X + Constant.ICON_H
                && Constant.BLACK_ICON_Y <= point.y && point.y <= Constant.BLACK_ICON_Y + Constant.ICON_H) {
            Stamp.setGameStart(true);
            Stamp.setWhich(-1);
            return;
        }
    }

    /**
     * 落子操作
     * 1、能否落子
     * 2、更改状态
     *
     * @param point
     * @return
     */
    public boolean placing(Point point) {
        Node node = findNode(point);
        //如果有合适的地方，更改状态
        if (node != null) {
            node.setValue(Stamp.getWhich());
            if (node.getValue() == Constant.WHITE) {
                node.setPath(Constant.WHITE_PATH);
            } else if (node.getValue() == Constant.BLACK) {
                node.setPath(Constant.BLACK_PATH);
            }
            Stamp.setCurrentNode(node);
            //落子结束后
            //判断是否胜利了
            if (isWin()) {
                Stamp.setWin(true);  //设置赢了的标记
            } else {
                Stamp.setWhich(Stamp.getWhich() * -1);
            }
            return true;
        }
        return false;
    }

    /**
     * 判断是否胜利
     * 水平、垂直、左上右下、左下右上
     *
     * @return
     */
    private boolean isWin() {
        if (horizon() || vertical() || lurd() || ldru()) {
            System.out.println("胜利了");
            return true;
        }
        return false;
    }

    /**
     * 水平方向判断
     * 起始位置
     * 终止位置
     * 遍历区间，查看是否胜利
     *
     * @return
     */
    private boolean horizon() {
        Node node = Stamp.getCurrentNode();
        //当前点的位置信息
        Position position = Stamp.getCurrentNode().getPosition();
        int fd = frontDis(position.getCol());
        int bk = backDis(position.getCol());

        //起始列
        int start = position.getCol() - fd;
        //终止列
        int end = position.getCol() + bk;

        //同一行
        int row = position.getRow();
        int star = 0;
        for (int i = start; i <= end; i++) {
            if (node.getValue() != CheckerBoard.checkerBoard[row][i].getValue()) {
                star = 0;
            } else {
                star++;
                //如果已经有5颗连续的棋子相同了，就赢了
                if (star == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 垂直方向判断
     *
     * @return
     */
    private boolean vertical() {
        Node node = Stamp.getCurrentNode();
        //当前点的位置信息
        Position position = Stamp.getCurrentNode().getPosition();

        int fd = frontDis(position.getRow());
        int bk = backDis(position.getRow());

        //起始行
        int start = position.getRow() - fd;
        //终止行
        int end = position.getRow() + bk;
        //相同的列
        int col = position.getCol();
        int star = 0;
        for (int i = start; i <= end; i++) {
            if (node.getValue() != CheckerBoard.checkerBoard[i][col].getValue()) {
                star = 0;
            } else {
                star++;
                if (star == 5) {
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * 左上右下的胜利判断
     * 1、前面的距离【行 小，列，小】 取小距离
     * 2、后面的距离【行 大，列 大】 取小距离
     *
     * @return
     */
    private boolean lurd() {
        Node node = Stamp.getCurrentNode();
        //当前点的位置信息
        Position position = Stamp.getCurrentNode().getPosition();

        //行的前面距离
        int fdRow = frontDis(position.getRow());
        //行的后面距离
        int bkRow = backDis(position.getRow());
        //列的前后距离
        int fdCol = frontDis(position.getCol());
        int bkCol = backDis(position.getCol());

        //取前面小值
        int fd = Math.min(fdRow, fdCol);
        int bk = Math.min(bkRow, bkCol);

        //行的起始位置
        int startRow = position.getRow() - fd;
        //行的结束位置
        int endRow = position.getRow() + bk;
        //列的起始位置
        int startCol = position.getCol() - fd;
        //列的结束位置
        int endCol = position.getCol() + bk;

        int star = 0;
        for (int row = startRow, col = startCol; row <= endRow && col <= endCol; row++, col++) {
            if (node.getValue() != CheckerBoard.checkerBoard[row][col].getValue()) {
                star = 0;
            } else {
                star++;
                if (star == 5) {
                    return true;
                }
            }
        }
        return false;

    }

    /**
     * 左下右上胜利的判断
     *
     * @return
     */
    private boolean ldru() {
        Node node = Stamp.getCurrentNode();
        //当前点的位置信息
        Position position = Stamp.getCurrentNode().getPosition();

        //行前面的距离
        int fdRow = frontDis(position.getRow());
        //行后面的距离
        int bkRow = backDis(position.getRow());
        //列前面的距离
        int fdCol = frontDis(position.getCol());
        //列后面的距离
        int bkCol = backDis(position.getCol());

        //以行作为标准
        //行向前 列向后
        int fd = Math.min(fdRow, bkCol);
        //行向后 列向前
        int bk = Math.min(bkRow, fdCol);

        //起始行
        int startRow = position.getRow() - fd;
        //终止行
        int endRow = position.getRow() + bk;

        //起始列
        int startCol = position.getCol() + fd;
        //终止列
        int endCol = position.getCol() - bk;

        int star = 0;
        for (int row = startRow, col = startCol; row <= endRow && col >= endCol; row++, col--) {
            if (node.getValue() != CheckerBoard.checkerBoard[row][col].getValue()) {
                star = 0;
            } else {
                star++;
                if (star == 5) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 通过中间值去找起始的距离
     *
     * @param mid
     * @return
     */
    private int frontDis(int mid) {
        return mid > 4 ? 4 : mid;
    }

    private int backDis(int mid) {
        int len = CheckerBoard.checkerBoard.length;
        return mid + 4 < len ? 4 : len - mid - 1;
    }

    /**
     * 找合适落子的位置
     * 遍历整个棋盘
     *
     * @param point
     * @return
     */
    private Node findNode(Point point) {
        for (Node[] nodes : CheckerBoard.checkerBoard) {
            for (Node node : nodes) {
                if (node.clickNode(point.x, point.y) && node.getValue() == Constant.NONE) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * 将所有的标记重置
     * 没有谁该先下，没有开始，没有图标路径，没有值
     */
    public void init() {
        Stamp.setWhich(Constant.NONE);
        Stamp.setGameStart(false);
        Stamp.setCurrentNode(null);
        for (Node[] nodes : CheckerBoard.checkerBoard) {
            for (Node node : nodes) {
                node.setPath(null);
                node.setValue(0);
            }
        }

    }

    public boolean replay(Point point) {
        if (Constant.RESTART_ICON_X <= point.x && point.x <= Constant.RESTART_ICON_X + Constant.ICON_W
                && Constant.RESTART_ICON_Y <= point.y && point.y <= Constant.RESTART_ICON_Y + Constant.ICON_H) {
            Stamp.setWin(false);
            return true;
        }
        return false;
    }

    /**
     * 给出提示
     *
     * @param g
     */
    public void msg(Graphics g) {
        String str = null;
        if (Stamp.getWhich() == Constant.WHITE) {
            str = "白棋赢了！";
        } else if (Stamp.getWhich() == Constant.BLACK) {
            str = "黑棋赢了！";
        }

        g.setFont(new Font("微软雅黑", Font.BOLD, 45));
        g.drawString(str, 250, 320);
    }
}
