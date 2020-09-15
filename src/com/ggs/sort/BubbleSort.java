package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/15 10:52
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int arr[] = {3, 9, -1, 10, 20};
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));

        //十万条数据进行测试
        int[] testArr = new int[100000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 100000);
        }
        long start = System.currentTimeMillis();
        bubbleSort(testArr);
        long end = System.currentTimeMillis();
        System.out.println("共耗费了" + (end - start) + "毫秒"); //20秒左右

//        System.out.println(Arrays.toString(testArr));
    }

    private static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - k - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    arr[i] = arr[i] ^ arr[i + 1];
                    arr[i + 1] = arr[i] ^ arr[i + 1];
                    arr[i] = arr[i] ^ arr[i + 1];
                }
            }
//            System.out.println("-----------------------------------");
//            System.out.println("第" + (k + 1) + "次排序后的数组");
            if (flag) {  //如果本轮排序中有数字被调换,则重置flag
                flag = false;
            } else { //如果在这轮排序中,没有数据被进行交换,则表示该数组已经有序
                break;
            }
        }

    }

}
