package com.ggs.sort;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/17 14:09
 * 基数排序(桶排序),不支持负数排序(如果要排序负数,就需要有19个桶,消耗内存极大,不划算)
 * 经典的空间换时间的排序算法
 */
public class RadixSort {

    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214, 100, 20, 134, 245, 612, 52, 11};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));


        int[] testArr = new int[50000000];
        for (int i = 0; i < testArr.length; i++) {
            testArr[i] = (int) (Math.random() * 50000000); //5000w
        }

        long start = System.currentTimeMillis();
        radixSort(testArr);
        long end = System.currentTimeMillis();

//        System.out.println(Arrays.toString(testArr));

        System.out.println("共耗费" + (end - start) + "毫秒"); //1000w条数据,排序耗费0.8秒左右 5000w条数据,耗费4s

    }

    public static void radixSort(int[] arr) {

        int[][] bucket = new int[10][arr.length]; //创建二维数组,一维长度为10,表示10位个数,二维长度为arr.length
        int[] bucketElementCounts = new int[10]; //存储每一个桶存储元素的个数

        int max = 0;
        //获取最大的值,得到最大的数的位数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        for (int p = 0,n=1; p < maxLength; p++,n*=10) {
            //遍历数组,获取每个数的个位数,作为一维的桶的下标,放入其中
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[i];
            }
            //全部放入后,根据桶的顺序和元素放入先后顺序,一个个放回到原来的数组中
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucketElementCounts[i] != 0) {
                    for (int j = 0; j < bucketElementCounts[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementCounts[i] = 0;
            }
        }


/*        //第一次排序
        //遍历数组,获取每个数的个位数,作为一维的桶的下标,放入其中
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[i];
        }
        //全部放入后,根据桶的顺序和元素放入先后顺序,一个个放回到原来的数组中
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }

        //第二次排序
        //遍历数组,获取每个数的个位数,作为一维的桶的下标,放入其中
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 10 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[i];
        }
        //全部放入后,根据桶的顺序和元素放入先后顺序,一个个放回到原来的数组中
        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }

        //第三次排序
        //遍历数组,获取每个数的个位数,作为一维的桶的下标,放入其中
        for (int i = 0; i < arr.length; i++) {
            int digitOfElement = arr[i] / 100 % 10;
            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = arr[i];
        }
        //全部放入后,根据桶的顺序和元素放入先后顺序,一个个放回到原来的数组中
        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucketElementCounts[i] != 0) {
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
            bucketElementCounts[i] = 0;
        }*/



    }


}
