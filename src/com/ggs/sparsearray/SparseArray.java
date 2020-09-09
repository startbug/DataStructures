package com.ggs.sparsearray;

import java.io.*;

/**
 * @Author Starbug
 * @Date 2020/8/7 16:03
 */
public class SparseArray {

    public static void main(String[] args) throws IOException {

        //创建一个原始的二维数组11*11
        //0:表示没有棋子, 1表示黑子 2表示蓝子
        System.out.println("二维数组转稀疏数组");
        int[][] chessArr = new int[11][11];

        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[6][8] = 1;
        //输出原始的二维数组
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.printf("%d\t", chessArr[i][j]);
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");

        //将二维数组 转 稀疏数组的思路
        //1.先遍历二维数组 得到非0数据的个数
        int num = 0;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    num++;
                }
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[num + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = num;

        //3.记录非0数据的坐标和数值
        int count = 0; //用于记录是第几个非0数据
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        storeData(sparseArr);

        System.out.println("---------------------------------------");
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.printf("%d\t", sparseArr[i][j]);
            }
            System.out.println();
        }

        System.out.println("---------------------------------------");
        System.out.println("稀疏数组转二维数组");

        int[][] sparseArr1 = readData();

        //将稀疏数组 恢复成 原始的二维数组
        //1.先读取稀疏数组的第一行,根据第一行的信息创建一个新的二维数组
        int[][] chessArr2 = new int[sparseArr1[0][0]][sparseArr1[0][1]];

        //2.根据稀疏数组的其他数据,填充新的二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr1[i][0]][sparseArr1[i][1]] = sparseArr1[i][2];
        }
        for (int i = 0; i < chessArr2.length; i++) {
            for (int j = 0; j < chessArr2[i].length; j++) {
                System.out.printf("%d\t", chessArr2[i][j]);
            }
            System.out.println();
        }
    }

    public static void storeData(int[][] arr) {
        ObjectOutputStream oos = null;
        try {
            File file = new File("map.data");
            if (!file.exists()) {
                file.createNewFile();
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int[][] readData() {
        ObjectInputStream ois = null;
        int[][] sparseArr = null;
        try {
            File file = new File("map.data");
            if (!file.exists()) {
                file.createNewFile();
            }
            ois = new ObjectInputStream(new FileInputStream(file));
            sparseArr = (int[][]) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sparseArr;
    }

}
