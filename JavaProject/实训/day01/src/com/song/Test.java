package com.song;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Test1();
//        Test2();
        Test3();

    }

    public static void Test1() {
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                count += i;
            }
        }
        System.out.println("和为：" + count);
    }

    public static void Test2() {
        float score;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入分数：");
            score = scanner.nextInt();
            if (score >= 90) {
                System.out.println("买电脑");
            } else if (score >= 80) {
                System.out.println("买手机");
            } else if (score >= 60) {
                System.out.println("吃大餐");
            } else {
                System.out.println("买锤子");
            }
        }
    }

    public static void Test3() {
        int x, y, z;
        for (x = 0; x < 20; x++) {
            for (y = 0; y < 33; y++) {
                for (z = 0; z < 300; z++) {
                    if (5 * x + 3 * y + z / 3 == 100 && x + y + z == 100) {
                        System.out.println("x=" + x + "    " + "y=" + y + "    " + "z=" + z);
                    }
                }
            }
        }
    }

}
