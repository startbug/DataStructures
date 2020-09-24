package com.ggs.hash;

import java.util.Scanner;

/**
 * @Author Starbug
 * @Date 2020/9/24 11:05
 */
public class HashTableDemo {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab(8);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------");
            System.out.println(" ---- 1.添加员工 ---- ");
            System.out.println(" ---- 2.遍历员工 ---- ");
            System.out.println(" ---- 3.查找员工 ---- ");
            System.out.println("---------------------");

            System.out.print("请选择操作:");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("输入id: ");
                    int id = scanner.nextInt();
                    System.out.print("输入姓名: ");
                    String name = scanner.next();
                    hashTab.add(new Emp(id, name));
                    break;
                case 2:
                    System.out.println("遍历员工信息");
                    hashTab.list();
                    break;
                case 3:
                    System.out.print("输入id: ");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
            }

        }

    }

}

class HashTab {
    public EmpLinkedList[] empLinkedListArr; //链表数组
    public int size;    //链表数组长度

    //构造器
    public HashTab(int size) {
        this.size = size;
        //初始化数组
        empLinkedListArr = new EmpLinkedList[size];
        //初始化数组中的对象
        for (int i = 0; i < empLinkedListArr.length; i++) {
            empLinkedListArr[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public HashTab add(Emp emp) {
        //根据员工的id,得到该员工应当添加到那条链表
        int position = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArr[position].add(emp);
        return this;
    }

    //遍历所有的链表,遍历HashTab
    public void list() {
        for (int i = 0; i < empLinkedListArr.length; i++) {
            empLinkedListArr[i].list(i + 1);
        }
    }

    //根据id查找员工
    public void findById(int id) {
        int position = hashFun(id);
        Emp emp = empLinkedListArr[position].findById(id);
        if (emp == null) {
            System.out.println("哈希表中没有找到该员工的信息!");
        } else {
            System.out.println("在第" + (position + 1) + "条链表中找到该员工信息,信息为: id = " + emp.id + " name = " + emp.name);
        }
    }

    public int hashFun(int id) {
        return id % size;
    }


}

class EmpLinkedList {
    public Emp head; //链表的存放着emp头节点

    public EmpLinkedList add(Emp emp) {
        //头节点为空,直接放入头节点中
        if (head == null) {
            head = emp;
            return null;
        }
        //否则,一直找到链表尾,再添加
        Emp currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = emp;
        return this;
    }

    //根据id查找员工
    public Emp findById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }

        //查找链表中id相同的节点返回
        Emp currentNode = head;
        while (currentNode != null) {
            //找到则返回
            if (currentNode.id == id) {
                return currentNode;
            }
            //后移
            currentNode = currentNode.next;
        }
        //查找不到,返回null
        return null;
    }

    //遍历
    public void list(int num) {
        if (head == null) {
            System.out.println("第" + num + "条链表为空");
            return;
        }
        System.out.print("第" + num + "条链表的数据:");
        Emp currentNode = head;
        while (currentNode != null) {
            System.out.printf(" => id=%d name=%s ", currentNode.id, currentNode.name);
            currentNode = currentNode.next;
        }
        System.out.println();
    }

}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}






