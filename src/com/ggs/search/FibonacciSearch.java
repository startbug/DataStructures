package com.ggs.search;

import java.util.Arrays;

/**
 * @Author Starbug
 * @Date 2020/9/20 13:40
 * 斐波那契(黄金分割法)查找法 (给ye整蒙了)
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] fib = fib();
        System.out.println(Arrays.toString(fib));
        int[] arr = {1, 8, 10, 89, 99, 3432};

        int index = fibSearch(arr, 1);

        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到了,下标为:" + index);
        }
    }

    //因为后面mid=low+F(k-1)-1,需要使用到斐波那契数列,因此需要先获得一个斐波那契数列
    //非递归方式获得一个斐波那契数列
    public static int[] fib() {
        int[] arr = new int[maxSize];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }


    //编写斐波那契查找算法
    //使用非递归的方式编写算法
    public static int fibSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;// 存放mid值
        int[] fib = fib();//获取到斐波那契数列

        //获取到斐波那契分割数值的下标
        while (high > fib[k] - 1) {
            k++;
        }

        //如果黄金分割长度比数组长度大,则将数组扩展到黄金分割的长度
        int[] temp = Arrays.copyOf(arr, fib[k]);

        //将多余出的位置填充上arr的最后一个数
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        //使用while来循环,寻找要查找的数(value)
        while (low <= high) {//满足条件,则继续查找
            mid = low + fib[k - 1] - 1;
            if (value < temp[mid]) { //比中间值小,向左查找
                high = mid - 1;
                //为什么是k--
                //说明
                //1. 全部元素 = mid前的元素 + mid后的元素
                //2. f[k] = f[k-1] + f[k-2]
                //当向左查找时,需要将最高值设置在mid-1的位置,通过f[k]得到下一个mid的位置
                k--;
            } else if (value > temp[mid]) {//向右查找
                low = mid + 1; //将最低值设置为mid+1
                k -= 2; // k减2后, 通过f[k]得到的mid将会提前一些位置
            } else { //找到
                //需要确定,返回的是哪一个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high; //此时mid已经越界,所以需要返回high
                }
            }

        }
        //查找不到,返回-1
        return -1;
    }


}
