package com.ggs.linkedlist;

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

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node4);
        singleLinkedList.add(node3);

        singleLinkedList.list();
    }

}

//定义singlelinkedlist管理爱人节点
class SingleLinkedList {
    //先初始化一个头节点,头节点不动,不存放具体的数据
    public LoverNode head = new LoverNode(0, "", "");

    public void add(LoverNode loverNode) {
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

}

class LoverNode {

    private int age;
    private String name;
    private String score;
    public LoverNode next;


    public LoverNode(int age, String name, String score) {
        this.age = age;
        this.name = name;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "LoverNode{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

}

