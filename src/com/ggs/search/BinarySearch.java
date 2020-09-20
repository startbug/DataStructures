package com.ggs.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Starbug
 * @Date 2020/9/20 11:39
 * 二分查找法,查找的数组首先要是有序的
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {1, 8, 10, 89, 99, 1000,1000,1000, 3432};
        int[] arr = {1, 8, 10, 89, 99, 3432};

        int index = binarySearch(arr, 0, arr.length-1, 1000);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了,下标为:" + index);
        }

        System.out.println("--------------------------------------------------------------");
        List list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }


    //二分查找法,如果有多个值相等,可以返回多个值的下标
    private static List binarySearch2(int[] arr, int left, int right, int value) {
        //获取中间值下标
        int mid = (left + right) / 2;
        //如果最终没有找到,则会返回-1
        if (left > right) {
            return new ArrayList();
        }
        //如果查找的值比中间值大,向右递归;比中间值小,向左递归;和中间值相等,则返回
        if (arr[mid] > value) {
            return binarySearch2(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch2(arr, mid + 1, right, value);
        } else {
            /**
             * 思路分析
             * 1.在找到mid索引值,不要马上返回
             * 2.向mid索引值的左边扫描,将所有与查找值相等的元素的下标,加入到集合中
             * 3.向mid索引值的右边扫描,将所有与查找值相等的元素的下标,加入到集合中
             * 4.返回集合
             */
            List list = new ArrayList();
            //首先将当前的值放入集合中
            list.add(mid);

            //向右查找
            int temp = mid + 1;
            //如果下标小于等于最右下标并且当前temp下标的值与查找值相等,就将其放入集合中
            while (temp <= right && arr[temp] == value) {
                list.add(temp++);
            }

            //向左查找
            temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp--);
            }
            return list;
        }
    }

    private static int binarySearch(int[] arr, int left, int right, int value) {
        //获取中间值下标
        int mid = (left + right) / 2;
        //如果最终没有找到,则会返回-1
        if (left > right) {
            return -1;
        }
        //如果查找的值比中间值大,向右递归;比中间值小,向左递归;和中间值相等,则返回
        if (arr[mid] > value) {
            return binarySearch(arr, left, mid - 1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid + 1, right, value);
        } else {
            return mid;
        }
    }
}
