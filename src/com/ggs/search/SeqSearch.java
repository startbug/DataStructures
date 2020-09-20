package com.ggs.search;

/**
 * @Author Starbug
 * @Date 2020/9/20 11:21
 * 线性查找法(一个个找),数组可有序可无序
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] arr = {1, 9, 11, -1, 34, 89};
        int index = seqSearch(arr, 34);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了,下标为:" + index);
        }
    }

    /**
     * 线性查找算法,遍历找,找到返回下标,找不到返回-1
     *
     * @param arr
     * @param value
     * @return
     */
    private static int seqSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
