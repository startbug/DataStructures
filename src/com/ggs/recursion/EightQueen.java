package com.ggs.recursion;

/**
 * @Author Starbug
 * @Date 2020/9/13 19:54
 */
public class EightQueen {
    //定义max,表示一共有多少个皇后
    private static final int max = 8;
    //定义数组array,保存皇后防止后的位置的结果;下标表示行数,值表示列数
    private static int[] array = new int[max];

    private static int count = 0;

    public static void main(String[] args) {
        check(0);
        System.out.println("一共有" + count + "种解法");
    }

    //从第0行开始计算
    public static void check(int row) {
        if (row == max) {
            print();
            return;
        }
        //放入皇后
        for (int i = 0; i < max; i++) {
            //先把当前行的皇后放入第一列
            array[row] = i;
            //判断行放置皇后的列是否冲突,不冲突则继续放置下一行
            if (judge(row)) {//不冲突
                //接着放row+1行的皇后
                check(row + 1);
            }
            //如果冲突,则将皇后放入下一列,直至找出不冲突的位置
        }
    }

    //传入行数
    public static boolean judge(int row) {
        for (int i = 0; i < row; i++) {
            //说明
            //1.array[i]==array[row] 表示判断 第row个皇后是否和前面的row-1个皇后在同一列
            //2.row - i == Math.abs(array[i] - array[row]判断第row个皇后,是否和第i个皇后在同一斜线
            //3.不需要判断是否在同一行,因为只要成功,就会切换到下一行
            if (array[i] == array[row] || row - i == Math.abs(array[i] - array[row])) {
                return false;
            }
        }
        return true;
    }

    public static void print() {
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
