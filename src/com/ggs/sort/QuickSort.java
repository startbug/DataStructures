package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/16 22:52
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 10, 8, -2, 0, 1, -4};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        System.out.println("=============================");
        int[] testArr = new int[20];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 1000000);
        }
        long start = System.currentTimeMillis();
        quickSort(testArr, 0, testArr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(testArr));

        System.out.println("共耗费" + (end - start) + "毫秒");

    }

    private static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right;  //右下标

        //pivot 中轴值
        int pivot = arr[(left + right) / 2];

        //while循环的目的是比pivot值小放到左边
        //比pivot值大的放右边
        while (l < r) {
            //从left开始找,找到在pivot左边比pivot大的数,直到找到才推出循环
            while (arr[l] < pivot) {
                l++;
            }
            //从right开始找,找到在pivot右边比pivot小的数,直到找到才推出循环
            while (arr[r] > pivot) {
                r--;
            }

            //如果l>=r说明pivot左右两边的数,已经达到要求(左边数都比pivot小,右边数都比pivot大)
            if (l >= r) {
                break;
            }

            //交换数字
            arr[l] = arr[l] ^ arr[r];
            arr[r] = arr[l] ^ arr[r];
            arr[l] = arr[l] ^ arr[r];

            //如果交换完后,发现arr[l] == pivot值相等,将r前移一位
            if (arr[l] == pivot) {
                r--;
            }
            //如果交换完后,发现arr[r] == pivot值相等,将r后移一位
            if (arr[r] == pivot) {
                l++;
            }
        }

        //排序过后
        //如果l==r,必须让l++,r--,否则出现栈溢出(死循环)
        if (l == r) {
            l++;
            r--;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
//        //向右递归
        if (l < right) {
            quickSort(arr, l, right);
        }
    }

}
