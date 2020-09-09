package com.ggs.linkedlist;

/**
 * @Author Starbug
 * @Date 2020/9/9 14:00
 * 约瑟夫环: 单向环形链表
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.init(5);
        circleSingleLinkedList.show();
        System.out.println("--------------------------------------");
        circleSingleLinkedList.countDown(1, 2, 5);
    }

}

class CircleSingleLinkedList {

    private Girl first;

    //女生出圈操作,指定从谁开始(start),每次向前数多少个数(num),总共有多少个女生(count)
    public void countDown(int start, int num, int count) {

        if (start < 1 || start > count || first == null) {
            System.out.println("参数有误,请重新输入");
            return;
        }

        Girl helper = first;
        //将first节点定位到指定的开始位置(num)
        for (int i = 1; i < start; i++) {
            first = first.next;
            //helper为辅助节点,一直在first的后一个位置,为什么-3?画图就知道了
//            if (i == start - 3) {
//                helper = first;
//            }
//            if (i == start - 1) {
//                helper = first;
//            }
        }

        while (true) {
            if (helper.next == first) {
                break;
            }
            helper = helper.next;
        }

        while (true) {
            for (int i = 0; i < num-1; i++) {
                first = first.next;
                helper = helper.next;
            }
            System.out.println(first);
            first = first.next;
            helper.next = first;
            if (first == helper) {
                break;
            }
        }
        System.out.println("幸运儿是:" + first);
    }

    public void init(int num) {
        //对数据进行校验
        if (num < 1) {
            System.out.println("至少要创建一个节点");
            return;
        }
        //创建一个辅助指针
        Girl cur = null;
        //创建num个节点,并形成环形单链表
        for (int i = 1; i <= num; i++) {
            Girl girl = new Girl(i);
            if (i == 1) {
                //第一个节点,即为首届点
                first = girl;
                //因为只有一个节点, 又是环形链表,所以使自己指向自己
                first.next = first;
                //辅助指针指向第一个节点(first)
                cur = first;
            } else {
                //添加其他节点,辅助接点(cur)的next指向新的节点
                cur.next = girl;
                //将新节点girl赋值给辅助接点(cur)
                cur = girl;
                //辅助节点(cur)指向第一个节点(first)
                cur.next = first;
            }
        }
    }


    //遍历环形单链表
    public void show() {
        if (first == null) {
            System.out.println("链表为空!");
            return;
        }
        //因为first不能动,所以需要一个辅助接点进行遍历
        Girl temp = first;
        while (true) {
            System.out.println(temp);
            if (temp.next == first) {
                break;
            }
            temp = temp.next;
        }
    }


}

class Girl {

    public int no; //编号
    public Girl next; //指向下一个

    public Girl(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "no=" + no +
                '}';
    }
}
