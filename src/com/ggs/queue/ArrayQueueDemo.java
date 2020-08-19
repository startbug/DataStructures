package com.ggs.queue;

import java.lang.reflect.Member;
import java.util.Scanner;

/**
 * @Author Starbug
 * @Date 2020/8/7 21:34
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列头的数据");
            System.out.println("----------------------------------");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    try {
                        queue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println(res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }

}

//使用数组模拟队列-编写一个Array Queue类
class ArrayQueue {

    private int maxSize; //表示数组最大容量
    private int front; //队列头
    private int rear; //队列尾
    private int[] arr; //该数组用于存放数据,模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满,无法添加");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列的数据,,出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }


    //显示队列的头数据,注意不是出队列
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }
        return arr[front + 1];
    }

}
