package com.example.model;

/**
 * 状态类
 * 游戏是否开始
 * 该谁落子
 * 落子在何处
 * 是否赢了
 */
public class Stamp {
    private static boolean gameStart = false;   //初始状态游戏并没有开始
    private static int which;   //当前该谁下 -1黑 1白 0没人选
    private static Node currentNode;    //当前落子
    private static boolean win = false;   //初始状态是没有人赢过

    public static boolean isGameStart() {
        return gameStart;
    }

    public static void setGameStart(boolean gameStart) {
        Stamp.gameStart = gameStart;
    }

    public static int getWhich() {
        return which;
    }

    public static void setWhich(int which) {
        Stamp.which = which;
    }

    public static Node getCurrentNode() {
        return currentNode;
    }

    public static void setCurrentNode(Node currentNode) {
        Stamp.currentNode = currentNode;
    }

    public static boolean isWin() {
        return win;
    }

    public static void setWin(boolean win) {
        Stamp.win = win;
    }
}
