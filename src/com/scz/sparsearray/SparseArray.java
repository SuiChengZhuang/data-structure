package com.scz.sparsearray;

import sun.text.resources.cldr.ti.FormatData_ti;

/**
 * @description: 稀疏数组
 * @author: sui.chengZhuang
 * @create: 2020-05-22 21:49
 **/
public class SparseArray {

    public static void main(String[] args) {
        //创建一个二维数组模拟棋盘
        int row = 11;
        int column = 11;
        int[][] chess = new int[row][column];

        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[4][3] = 2;


        System.out.println("初始化棋盘~~~~");
        for (int[] rows : chess) {
            for (int c : rows) {
                System.out.printf("%d\t", c);
            }
            System.out.println();
        }

        int sum = 0;
        for (int[] rows : chess) {
            for (int c : rows) {
                if (c != 0) {
                    sum++;
                }
            }
        }

        // 棋盘压缩成稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = sum;

        int r = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (chess[i][j] != 0) {
                    sparseArray[r][0] = i;
                    sparseArray[r][1] = j;
                    sparseArray[r][2] = chess[i][j];
                    r++;
                }
            }
        }
        System.out.println("稀疏数组~~~~");
        for (int[] rows : sparseArray) {
            System.out.printf("%d\t%d\t%d" ,  rows[0], rows[1] , rows[2]);
            System.out.println();
        }

        System.out.println("稀疏数组->二维数组 ~~~");
        int[][]chess2 =  new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1 ; i < sparseArray.length; i++) {
            for (int j = 0 ; j < sparseArray[0].length; j++) {
                chess2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][j];
            }
        }

        for (int[] ints : chess2) {
            for (int anInt : ints) {
                System.out.printf("%d\t" , anInt);
            }
            System.out.println();
        }
        System.out.println("测试代码同步");
    }
}
