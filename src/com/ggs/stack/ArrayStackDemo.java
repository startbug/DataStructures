package com.ggs.stack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Starbug
 * @Date 2020/9/10 13:20
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);

        String key = "";

        Scanner scanner = new Scanner(System.in);
        int value;
        boolean flag = false;
        while (true) {
            System.out.println("1.入栈");
            System.out.println("2.出栈");
            System.out.println("3.遍历");
            System.out.println("0.退出");
            System.out.println("------------------------------");
            System.out.print("请选择: ");
            key = scanner.next();
            try {
                switch (key) {
                    case "1":
                        System.out.print("请输入一个数字: ");
                        value = scanner.nextInt();
                        arrayStack.push(value);
                        break;
                    case "2":
                        value = arrayStack.pop();
                        System.out.println("value = " + value);
                        break;
                    case "3":
                        arrayStack.list();
                        break;
                    case "0":
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("按Enter键继续...");
            String wait=scanner.nextLine();
            System.out.println(wait);
            if (flag) {
                break;
            }
        }


        scanner.close();
//        arrayStack.push(1);
//        arrayStack.push(5);
//        arrayStack.push(3);
//        arrayStack.push(4);
//
//        int pop = arrayStack.pop();
//        System.out.println("pop = " + pop);
//        arrayStack.list();
    }
}

class ArrayStack {

    private int maxSize; //数组的大小
    private int[] stack; //数组,模拟栈
    private int top = -1; //top表示栈顶,初始化为-1


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //是否满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public ArrayStack push(int num) {
        if (isFull()) {
            throw new RuntimeException("栈满,无法添加");
        }
        //指针上移
        top++;
        //添加数据
        stack[top] = num;
        return this;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历
    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无数据");
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }


}

