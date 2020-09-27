package com.ggs.tree;

/**
 * @Author Starbug
 * @Date 2020/9/27 22:50
 * 二叉树
 *
 * 树的常用术语
 * 1)节点
 * 2)根节点
 * 3)父节点
 * 4)子节点
 * 5)叶子节点(没有子节点的节点)
 * 6)节点的权(节点值,自定义,例如id值)
 * 7)路径(从root节点找到该节点的路线)
 * 8)层
 * 9)子树
 * 10)树的高度(最大层数)
 * 11)森林:多颗子树构成森林
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {
        LoverNode root = new LoverNode(1, "宋江");
        LoverNode node2 = new LoverNode(2, "吴用");
        LoverNode node3 = new LoverNode(3, "卢俊义");
        LoverNode node4 = new LoverNode(4, "林冲");
        LoverNode node5 = new LoverNode(5, "关胜");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.setRoot(root);

        //前序遍历
        System.out.println("-------------前序遍历---------------");
        binaryTree.preOrder(); //1 2 3 5 4

        //中序遍历
        System.out.println("-------------中序遍历---------------");
        binaryTree.infixOrder(); //2 1 5 3 4

        //后序遍历
        System.out.println("-------------后序遍历---------------");
        binaryTree.postOrder(); //2 5 4 3 1
    }


}

class BinaryTree {
    private LoverNode root;

    public void setRoot(LoverNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
}

class LoverNode {
    private int id;
    private String name;
    private LoverNode left;
    private LoverNode right;

    public LoverNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoverNode getLeft() {
        return left;
    }

    public void setLeft(LoverNode left) {
        this.left = left;
    }

    public LoverNode getRight() {
        return right;
    }

    public void setRight(LoverNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "LoverNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    //前序遍历== 父节点->左子节点->右子节点
    //如果子节点还有子节点,则继续递归遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }


    //中序遍历== 左子节点->父节点->右子节点
    //如果子节点还有子节点,则继续递归遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历 == 左子节点->右子节点->父节点
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


}
