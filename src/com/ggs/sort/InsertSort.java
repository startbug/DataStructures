package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/16 19:15
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {2, 10, 8, -2, 0, 1, -4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));


        int[] testArr = new int[100000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 100000);
        }

        long start = System.currentTimeMillis();
        insertSort(testArr);
        long end = System.currentTimeMillis();

        System.out.println("共耗费" + (end - start) + "毫秒"); //1.7秒左右


    }

    private static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int sortVal = arr[i];
            int sortIndex = i - 1;
            while (sortIndex >= 0 && arr[sortIndex] > sortVal) {
                //判断要排序的位置的前一个数是否比当前值大,如果是,则将前一个数向后移动一位,然后再比较前前一位,一直比较到sortIndex等于0之后结束
                arr[sortIndex + 1] = arr[sortIndex];
                sortIndex--;
            }
            arr[sortIndex + 1] = sortVal;
        }

    }


}
