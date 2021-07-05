package com.song;

import java.util.Scanner;

public class Wuziqi {
    //用什么样式的数据来表示棋盘
    public static String[][] board = new String[15][15];
    //偶数黑棋，奇数白棋
    public static int player = 0;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        //1.初始化棋盘
        initBoard();
        //2.打印棋盘
        printBoard();
        //3.开始游戏
        startGame();


    }

    private static void startGame() {
        while (!isGameOver()) {
            if (player % 2 == 0) {
                System.out.println(">>黑方下");
                playChess("O");
            } else {
                System.out.println(">>白方下");
                playChess("X");

            }
            player++;
        }
        System.out.println(">>游戏结束！");
        if ((player - 1) % 2 == 0) {
            System.out.println("黑方胜！");
        } else {
            System.out.println("白方胜！");
        }
    }

    private static boolean isGameOver() {

        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                if (board[x][y].equals("+")) {
                    continue;
                }

                //向右
                if (y < 11) {
                    if (board[x][y].equals(board[x][y + 1])
                            && board[x][y].equals(board[x][y + 2])
                            && board[x][y].equals(board[x][y + 3])
                            && board[x][y].equals(board[x][y + 4])) {
                        return true;
                    }
                }

                //向下
                if (x < 11) {
                    if (board[x][y].equals(board[x + 1][y])
                            && board[x][y].equals(board[x + 2][y])
                            && board[x][y].equals(board[x + 3][y])
                            && board[x][y].equals(board[x + 4][y])) {
                        return true;
                    }
                }

                //右下
                if (x < 11 && y < 11) {
                    if (board[x][y].equals(board[x + 1][y + 1])
                            && board[x][y].equals(board[x + 2][y + 2])
                            && board[x][y].equals(board[x + 3][y + 3])
                            && board[x][y].equals(board[x + 4][y + 4])) {
                        return true;
                    }
                }

                //右上
                if (x > 4 && y < 11) {
                    if (board[x][y].equals(board[x - 1][y + 1])
                            && board[x][y].equals(board[x - 2][y + 2])
                            && board[x][y].equals(board[x - 3][y + 3])
                            && board[x][y].equals(board[x - 4][y + 4])) {
                        return true;
                    }
                }
            }

        }

        return false;
    }

    private static void playChess(String chess) {
        //获取行和列标
        System.out.print(">>请输入x坐标：");
        int x = input.nextInt() - 1;
        System.out.print(">>请输入y坐标：");
        int y = input.nextInt() - 1;
        //判断当前位置能否下棋
        if (board[x][y].equals("+")) {
            board[x][y] = chess;

        } else {
            System.out.println(">>此处已经有棋子了，请重新下！");
            player--;
        }
        printBoard();

    }

    //初始化棋盘
    public static void initBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = "+";
            }
        }
    }

    //打印棋盘
    public static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < 15; i++) {
            System.out.printf("%-3d", i + 1);
        }
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.printf("%-2d", i + 1);
            for (int j = 0; j < 15; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

}
