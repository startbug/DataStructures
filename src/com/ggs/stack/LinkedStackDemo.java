package com.ggs.stack;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Starbug
 * @Date 2020/9/10 15:26
 */
public class LinkedStackDemo {

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();

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
                        linkedStack.push(new LinkedNode(value));
                        break;
                    case "2":
                        LinkedNode node = linkedStack.pop();
                        System.out.println("node = " + node);
                        break;
                    case "3":
                        linkedStack.list();
                        break;
                    case "0":
                        flag = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("按Enter键继续...");
            String wait = scanner.nextLine();
            System.out.println(wait);
            if (flag) {
                break;
            }
        }


        scanner.close();
    }
}


class LinkedStack {

    private LinkedNode top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(LinkedNode node) {
        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public LinkedNode pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法获取数据");
        }
        LinkedNode popNode = top;
        top = top.next;
        return popNode;
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,无法获取数据");
        }
        LinkedNode temp = top;
        while (true) {
            System.out.println("temp = " + temp);
            temp = temp.next;
            if (temp == null) {
                break;
            }
        }
    }

}

class LinkedNode {

    public int value;
    public LinkedNode next;

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value=" + value +
                '}';
    }

    public LinkedNode(int value) {
        this.value = value;
    }
}
