package com.ggs.linkedlist;

import java.security.Principal;

/**
 * @Author Starbug
 * @Date 2020/8/19 22:58
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        LoverNode node1 = new LoverNode(1, "lucy", "100");
        LoverNode node2 = new LoverNode(2, "tom", "200");
        LoverNode node3 = new LoverNode(3, "cat", "300");
        LoverNode node4 = new LoverNode(4, "dog", "400");
        LoverNode node5 = new LoverNode(5, "water", "500");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.add(node2);
//        singleLinkedList.add(node4);
//        singleLinkedList.add(node3);
//        singleLinkedList.add(node1);

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node5);
//        singleLinkedList.addByOrder(node1);
        singleLinkedList.list();

        System.out.println("------------------------------------------------------");
        LoverNode nodedog = new LoverNode(4, "死狗", "666");
        singleLinkedList.update(nodedog);
        singleLinkedList.list();


        System.out.println("------------------------------------------------------");
//        System.out.println(singleLinkedList.length(singleLinkedList.getHead()));

        System.out.println(getLength(singleLinkedList.getHead()));

        System.out.println(getLastIndexNode(5, singleLinkedList.getHead()));
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(4);
//        singleLinkedList.delete(1);
//        singleLinkedList.delete(3);
//        singleLinkedList.list();

        System.out.println("------------------------------------------------------");
//        reverseLinkedList(singleLinkedList.getHead());
//        singleLinkedList.list();
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("------------------------------------------------------");
        System.out.println("-------------------------反转打印单链表-----------------------------");
        reversePrintLinkedList(singleLinkedList.getHead());

        System.out.println();
        System.out.println();
        System.out.println("----------------------------新--------------------------------");
        System.out.println("----------------------------新--------------------------------");
        System.out.println("----------------------------新--------------------------------");
        LoverNode loverNode1 = new LoverNode(1, "", "");
        LoverNode loverNode2 = new LoverNode(5, "", "");
        LoverNode loverNode66 = new LoverNode(6, "", "");
        LoverNode loverNode3 = new LoverNode(10, "", "");

        LoverNode loverNode4 = new LoverNode(0, "", "");
        LoverNode loverNode5 = new LoverNode(2, "", "");
        LoverNode loverNode6 = new LoverNode(7, "", "");
        LoverNode loverNode7 = new LoverNode(9, "", "");

        SingleLinkedList linkedList1 = new SingleLinkedList();
        SingleLinkedList linkedList2 = new SingleLinkedList();

        linkedList1.add(loverNode1).add(loverNode2).add(loverNode66).add(loverNode3);
        linkedList2.add(loverNode4).add(loverNode5).add(loverNode6).add(loverNode7);

        System.out.println("------------++-------------");
        linkedList1.list();
        System.out.println("------------++-------------");
        linkedList2.list();
        System.out.println("------------++-------------");

        SingleLinkedList mergeList = mergeLinkedList(linkedList1, linkedList2);

        mergeList.list();
    }

    //合并两个单链表,合并后还是有序(id有序)
    public static SingleLinkedList mergeLinkedList(SingleLinkedList linkedList1, SingleLinkedList linkedList2) {
        SingleLinkedList linkedList = new SingleLinkedList();

        while (linkedList1.getHead().next != null && linkedList2.getHead().next != null) {
            LoverNode minNodeHead = linkedList1.getHead().next.id < linkedList2.getHead().next.id ? linkedList1.getHead() : linkedList2.getHead();
            LoverNode temp = minNodeHead.next;
            minNodeHead.next = minNodeHead.next.next;
            temp.next=null;
            linkedList.add(temp);
        }

        return linkedList;
    }

    //查找单链表中倒数第k个节点
    public static LoverNode getLastIndexNode(int k, LoverNode head) {
        if (head.next == null) {
            System.out.println("链表为空");
            return null;
        }

        int nodeLength = getLength(head);
        if (k < 1 || k > nodeLength) {
            System.out.println("超出范围,请重新选择");
            return null;
        }

        LoverNode temp = head.next;
        for (int i = 0; i < nodeLength - k; i++) {
            temp = temp.next;
        }
        return temp;
    }


    //统计节点的个数,注意:要排除head节点
    public static int getLength(LoverNode head) {
        if (head.next == null) {
            return 0;
        }

        int length = 0;
        LoverNode temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    //将单链表反转
    public static void reverseLinkedList(LoverNode head) {
//        SingleLinkedList reverseSingleLinkedList = new SingleLinkedList();
        //当链表为空,或只有一个节点,无需反转,直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助的指针(变量),帮助我们遍历原来的链表
        LoverNode reverseHead = new LoverNode(0, "", "");

        LoverNode cur = head.next;
        LoverNode next = null; //指向当前节点(cur)的下一个节点

        //遍历原来的链表,每遍历一个节点,就将其去除, 放到新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next; //暂时保存当前节点的下一个节点,因为当前节点将被移动到新的链表中,不保存会丢失其后面的数据
            cur.next = reverseHead.next; //将cur的下一个节点指向新链表的最前端
            reverseHead.next = cur; //
            cur = next;
        }
        head.next = reverseHead.next;
    }

    //逆序打印单链表
    public static void reversePrintLinkedList(LoverNode node) {
//        if (node.next == null) {
//            System.out.println("单链表为空!");
//        }
        if (node.next != null) {
            reversePrintLinkedList(node.next);
            System.out.println(node.next);
        }
//        LoverNode temp = node.next;
//        printNode(temp);


    }

}

//定义singlelinkedlist管理爱人节点
class SingleLinkedList {
    //先初始化一个头节点,头节点不动,不存放具体的数据
    private LoverNode head = new LoverNode(0, "", "");

    public LoverNode getHead() {
        return head;
    }

    public void setHead(LoverNode loverNode) {
        this.head = loverNode;
    }

    //根据id删除
    public void delete(int id) {
        if (head.next == null) {
            System.out.println("li");
        }
        boolean flag = false;
        LoverNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == id) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            LoverNode deleteNode = temp.next;
            temp.next = temp.next.next;
            deleteNode.next = null;
        } else {
            System.out.println("没有找到对应id的节点");
        }
    }

    //根据id修改
    public void update(LoverNode loverNode) {
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }
        boolean flag = false;//表示是否查找到节点
        LoverNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id == loverNode.id) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next.name = loverNode.name;
            temp.next.score = loverNode.score;
        } else {
            System.out.println("没有找到对应的节点,无法修改");
        }

    }

    //根据id排序插入
    public void addByOrder(LoverNode loverNode) {

        LoverNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.id > loverNode.id) { //找到位置,在temp后插入
                break;
            } else if (temp.next.id == loverNode.id) {
                flag = true; //编号存在
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //已经存在,无法添加
            System.out.printf("插入的数据的编号%d已经存在,无法插入\n", loverNode.id);
        } else {
            //插入到链表中,temp的后面
            loverNode.next = temp.next;
            temp.next = loverNode;
        }

    }

    public SingleLinkedList add(LoverNode loverNode) {
        //因为head节点不能动,所以我们需要一个辅助遍历temp
        LoverNode temp = head;
        // 遍历链表,找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后,将temp后移
            temp = temp.next;
        }
        //当推出while循环时,temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next = loverNode;
        return this;
    }

    //显示链表(遍历)
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        LoverNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }

    //获取单链表节点的个数
    public int length(LoverNode head) {
        if (head.next == null) {
            return 0;
        }

        int length = 0;
        LoverNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}

class LoverNode {
    public int id;
    public String name;
    public String score;
    public LoverNode next;


    public LoverNode(int id, String name, String score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "LoverNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

}

