package com.ggs.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/9/20 12:43
 * 插值查找法,数组必须时有序的
 * <p>
 * 插值查找注意事项
 * 1)对于数据量较大,关键字分布比较均匀的查找表来说,采用插值查找,速度比较快
 * 2)关键字粉补不均匀的情况下,该方法不一定比折半查找要好
 */
public class InsertValueSearch {

    private static int num = 0;

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }

//        int[] arr = {1, 8, 10, 89, 99, 1000, 1000, 1000, 3432};
        List list = insertValueSearch(arr, 0, arr.length - 1, 99);

        System.out.println(list);
        System.out.println("执行次数:" + num);
    }

    //便那些插值查找算法
    //说明: 插值查找算法,要求数组有序

    /**
     * @param arr   数组
     * @param left  左边索引
     * @param right 右边索引
     * @param value 查找的值
     * @return 找到则返回对应的下标的集合, 否则返回空集合
     */
    private static List insertValueSearch(int[] arr, int left, int right, int value) {
        num++;
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return new ArrayList();
        }

        //求出mid
//        int mid = (left + right) / 2;
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);

        if (value > arr[mid]) {
            return insertValueSearch(arr, mid + 1, right, value);
        } else if (value < arr[mid]) {
            return insertValueSearch(arr, left, mid - 1, value);
        } else {

            List list = new ArrayList();
            list.add(mid);

            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp--);
            }
            temp = mid + 1;
            while (temp <= right && arr[temp] == value) {
                list.add(temp++);
            }
            return list;
        }
    }

}
