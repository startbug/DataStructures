package com.ggs.queue;

import java.util.Scanner;

/**
 * @Author Starbug
 * @Date 2020/8/13 17:51
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("----------------------------------");
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
                    try {
                        System.out.println("输入一个数字");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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


//构建环形队列
class CircleArrayQueue {

    private int maxSize; //表示数组的最大容量
    //front 变量的含义做一个调整: front就指队列的第一个元素,也就是说arr[front]
    //front 的初始化值 = 0
    private int front; //队列头
    //rear 变量的含义做一个调整: rear指向队列的最后一个元素的后一个位置,因为希望空出一个空间作为约定
    //rear 的初始化值 = 0
    private int rear; //队列尾
    private int[] arr;

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    //1.是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //2.是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //3.展示所有
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有数据可以展示");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    //3.1有效数据个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    //4.添加
    public void addQueue(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满,无法添加");
        }
        //直接加入数据
        arr[rear] = num;
        //将rear后移,这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }


    //5.获取(出队列)
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }

        //front指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量中
        int value = arr[front];
        //2.将front后移
        front = (front + 1) % maxSize;
        //3.返回值
        return value;
    }

    //6.返回头元素(返回,但不出队列)
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }

        return arr[front];
    }


}
