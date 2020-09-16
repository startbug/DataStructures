package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/16 19:38
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

        int[] testArr = new int[1000000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 1000000);
        }

        long start = System.currentTimeMillis();
        shellSort2(testArr);
        long end = System.currentTimeMillis();
//        System.out.println(Arrays.toString(testArr));

        System.out.println("共耗费" + (end - start) + "毫秒"); //100w条数据,250毫秒左右

    }


    //优化后:使用移动法(插入),排序100w条数据,0.5秒以下 好快,多一个数量级∑( 口 ||
    private static void shellSort2(int[] arr) {
        int step = arr.length;
        while (step > 1) {
            //步长,初始为数组长度的一半,之后是1/4,1/8....逐步缩小
            step /= 2;
            //从与步长等长的位置开始循环
            for (int i = step; i < arr.length; i++) {
                int sortValue = arr[i]; //当前位置的值
                int sortIndex = i;  //记录当前位置的索引
                if (arr[i] < arr[i - step]) { //判断当前位置是否比前一个步长位置的值小
                    //寻找当前值sortValue的位置,找到第一个比sortValue小的数位置
                    while (sortIndex >= step && sortValue < arr[sortIndex - step]) {
                        arr[sortIndex] = arr[sortIndex - step];
                        sortIndex -= step;
                    }
                    //找到位置后,进行赋值
                    arr[sortIndex] = sortValue;
                }

            }
        }
    }


    //优化前:使用的是交换法 排序10w条数据需要10秒
    private static void shellSort1(int[] arr) {
        int step = arr.length;
        while (step > 1) {
            for (int i = (step /= 2); i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        arr[j] = arr[j] ^ arr[j + step];
                        arr[j + step] = arr[j] ^ arr[j + step];
                        arr[j] = arr[j] ^ arr[j + step];
                    }
                }
            }
        }

        //第一次步长为5
//        int step = arr.length / 2;
//        for (int i = step; i < arr.length; i++) {
//            for (int j = i - step; j >= 0; j -= step) {
//                if (arr[j] > arr[j + step]) {
//                    arr[j] = arr[j] ^ arr[j + step];
//                    arr[j + step] = arr[j] ^ arr[j + step];
//                    arr[j] = arr[j] ^ arr[j + step];
//                }
//            }
//        }
//        System.out.println("第一次排序后:" + Arrays.toString(arr));
//
//          第二次步长为2
//        step = arr.length / 2 / 2;
//        for (int i = step; i < arr.length; i++) {
//            for (int j = i - step; j >= 0; j -= step) {
//                if (arr[j] > arr[j + step]) {
//                    arr[j] = arr[j] ^ arr[j + step];
//                    arr[j + step] = arr[j] ^ arr[j + step];
//                    arr[j] = arr[j] ^ arr[j + step];
//                }
//            }
//        }
//        System.out.println("第二次排序后:" + Arrays.toString(arr));
//
//          最后一次步长为1
//        step = arr.length / 2 / 2 / 2;
//        for (int i = step; i < arr.length; i++) {
//            for (int j = i - step; j >= 0; j -= step) {
//                if (arr[j] > arr[j + step]) {
//                    arr[j] = arr[j] ^ arr[j + step];
//                    arr[j + step] = arr[j] ^ arr[j + step];
//                    arr[j] = arr[j] ^ arr[j + step];
//                }
//            }
//        }
//        System.out.println("第三次排序后:" + Arrays.toString(arr));
    }

}
