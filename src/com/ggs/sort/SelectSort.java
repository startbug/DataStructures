package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/15 11:38
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {88, 10, 30, -10, 44, 22, 9, 0,};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] testArr = new int[100000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 100000);
        }

        long start = System.currentTimeMillis();
        selectSort(testArr);
        long end = System.currentTimeMillis();

        System.out.println("共耗费" + (end - start) + "毫秒"); //6秒左右


    }

    //选择排序
    private static void selectSort(int[] arr) {
        //选择排序的时间复杂度是O(n^2)
        for (int k = 0; k < arr.length - 1; k++) {
            int index = k;
            int min = arr[k];
            for (int i = k + 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    index = i;
                }
            }
            if (index != k) {
//                arr[index] = arr[index] ^ arr[k];
//                arr[k] = arr[index] ^ arr[k];
//                arr[index] = arr[index] ^ arr[k];
                arr[index] = arr[k];
                arr[k] = min;
            }
        }
    }


}
