package com.ggs.linkedlist;

/**
 * @Author Starbug
 * @Date 2020/9/8 22:14
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "lucy", "fucker");
        HeroNode node2 = new HeroNode(2, "tom", "fucker");
        HeroNode node3 = new HeroNode(3, "pp", "fucker");
        HeroNode node4 = new HeroNode(4, "canno", "fucker");

        DoubleLinedList doubleLinedList = new DoubleLinedList();
        doubleLinedList.add(node1).add(node2).add(node3).add(node4);

        doubleLinedList.list();

        System.out.println("----------------------------------------");
        doubleLinedList.update(new HeroNode(2, "中文名", "碧池"));
        doubleLinedList.list();

        System.out.println("----------------------------------------");
        doubleLinedList.delete(1);
        doubleLinedList.list();
    }

}


//创建一个双向链表的类
class DoubleLinedList {

    private HeroNode head = new HeroNode(0, "", "");

    public void list() {
        if (head.next == null) {
            System.out.println("双向链表为空");
        }

        HeroNode temp = head.next;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public DoubleLinedList add(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
        return this;
    }

    public void update(HeroNode heroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空~");
            return;
        }

        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == heroNode.no) {
                heroNode.next = temp.next;
                heroNode.pre = temp.pre;

                temp.next.pre = heroNode;
                temp.pre.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
        }

        HeroNode temp = head.next;

        while (temp != null) {
            if (temp.no == no) {
                temp.pre.next = temp.next;
                //如果是最后一个节点,那么节点的next则为空,需要进行判断
                if (temp.next == null) {
                    break;
                }
                temp.next.pre = temp.pre;
            }
            temp = temp.next;
        }


    }

}

//定义LoverNode, 每一个LoverNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    public HeroNode pre;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

