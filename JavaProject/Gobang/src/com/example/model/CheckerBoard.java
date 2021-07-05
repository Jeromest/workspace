package com.example.model;

import com.example.util.Constant;

/**
 * 棋盘：可以落子的所有区域  由小格子组成
 */
public class CheckerBoard {
    public static Node[][] checkerBoard = new Node[20][20];

    static {
        for (int i = 0; i < checkerBoard.length; i++) {
            for (int j = 0; j < checkerBoard[i].length; j++) {
                checkerBoard[i][j] =
                        new Node((j + 1) * Constant.NODE_W, (i + 1) * Constant.NODE_W, new Position(i, j));
            }
        }
    }


}
