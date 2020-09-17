package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/17 11:45
 */
public class MergeSort {

    public static void main(String[] args) {

//        int[] arr = {2, 10, 8, -2, 0, 1, -4};
//        int[] temp = new int[arr.length];
//
//        mergeSort(arr, 0, arr.length - 1, temp);
//        System.out.println(Arrays.toString(arr));
//

        int[] testArr = new int[10000000];
        int[] temp = new int[testArr.length];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 10000000);
        }

        long start = System.currentTimeMillis();
        mergeSort(testArr, 0, testArr.length - 1, temp);
        long end = System.currentTimeMillis();

//        System.out.println(Arrays.toString(testArr));

        System.out.println("共耗费" + (end - start) + "毫秒"); //1000w条数据,排序耗费2.2秒左右
    }

    //分区,合并
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2; //中间索引
            mergeSort(arr, left, mid, temp);    //向左递归
            mergeSort(arr, mid + 1, right, temp);   //向右递归
            merge(arr, left, mid, right, temp); //合并
        }
    }

    /**
     * @param arr   原始数组
     * @param left  当前分区的最左索引
     * @param mid   中间节点的索引
     * @param right 当前分区的最右索引
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {

        int i = left;
        int j = mid + 1;
        int t = 0;

        //左分区和右分区的数据从左至右进行比较,小的数放入temp临时数组中,然后下标后移
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            } else {
                temp[t++] = arr[i++];
            }
        }

        //判断左分区和右分区中是否还有剩余的数据(只有其中一个分区有)
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        //将临时数组(temp)中的数据放入到原数组中(arr)
        //注意:并不是每次都拷贝所有(只有最后一次才拷贝所有)
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }


}
