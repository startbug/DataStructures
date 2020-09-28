package com.ggs.tree;

/**
 * @Author Starbug
 * @Date 2020/9/27 22:50
 * 二叉树
 * <p>
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


        System.out.println("查找");
        //前序遍历
        System.out.println("-------------前序查找---------------");
        System.out.println(binaryTree.preOrderSearch(3));

        //中序遍历
        System.out.println("-------------中序查找---------------");
        System.out.println(binaryTree.infixOrderSearch(3));

        //后序遍历
        System.out.println("-------------后序查找---------------");
        System.out.println(binaryTree.postOrderSearch(3));

        //删除节点
        System.out.println("--------------删除前----------------");
        binaryTree.preOrder();
        System.out.println("-------------删除节点---------------");
        binaryTree.delNode(3);
        System.out.println("--------------删除后----------------");
        binaryTree.preOrder();
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

    //前序查找
    public LoverNode preOrderSearch(int id) {
        if (this.root != null) {
            return this.root.preOrderSearch(id);
        } else {
            return null;
        }
    }

    //中序查找
    public LoverNode infixOrderSearch(int id) {
        if (this.root != null) {
            return this.root.infixOrderSearch(id);
        } else {
            return null;
        }
    }

    //后序查找
    public LoverNode postOrderSearch(int id) {
        if (this.root != null) {
            return this.root.postOrderSearch(id);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int id){
        if(this.root!=null){
            if(this.root.getId()==id){
                this.root=null;
            }else {
                this.root.delNode(id);
            }
        }else{
            System.out.println("根节点为空,无法删除");
        }
    }

    //后序查找
//    public LoverNode postOrderSearch(int id) {
//        if (this.root != null) {
//            LoverNode.setNum(0);
//            LoverNode loverNode = this.root.postOrderSearch(id);
//            System.out.println("方法调用次数: " + LoverNode.getNum());
//            return loverNode;
//        } else {
//            System.out.println("二叉树为空");
//            return null;
//        }
//    }
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

    private static int num;

    public static int getNum() {
        return num;
    }

    public static void setNum(int num) {
        LoverNode.num = num;
    }

    /**
     * 前序查找
     *
     * @param id 查找id
     * @return 如果找到就返回该Node, 如果没有找到则返回null
     */
    public LoverNode preOrderSearch(int id) {
        num++;

        System.out.println("前序查找");
        //如果相等,直接返回当前节点
        if (this.id == id) {
            return this;
        }

        //如果左子节点不为空,继续想左递归查询
        if (this.left != null) {
            LoverNode loverNode = this.left.preOrderSearch(id);
            if (loverNode != null) {
                return loverNode;
            }
        }

        //如果在左边没找到,继续向右递归查询
        if (this.right != null) {
            return this.right.preOrderSearch(id);
        }
        return null;
    }


    /**
     * 中序查找
     */
    public LoverNode infixOrderSearch(int id) {
        num++;
        if (this.left != null) {
            LoverNode loverNode = this.left.infixOrderSearch(id);
            if (loverNode != null) {
                return loverNode;
            }
        }

        System.out.println("中序查找");
        if (this.id == id) {
            return this;
        }

        if (this.right != null) {
            return this.right.infixOrderSearch(id);
        }
        return null;
    }

    /**
     * 后续查找
     */
    public LoverNode postOrderSearch(int id) {
        num++;
        if (this.left != null) {
            LoverNode loverNode = this.left.postOrderSearch(id);
            if (loverNode != null) {
                return loverNode;
            }
        }

        if (this.right != null) {
            LoverNode loverNode = this.right.postOrderSearch(id);
            if (loverNode != null) {
                return loverNode;
            }
        }
        System.out.println("后续查找");
        if (this.id == id) {
            return this;
        }
        return null;
    }

    /**
     * 删除节点
     * 如果删除的节点有子节点,也直接全部删除
     * 1.因为我们的二叉树是单向的,所以我们是判断当前节点的子节点是否需要删除节点,而不能去判断当前这个节点是不是需要删除节点
     * 2.如果当前节点的左子节点不为空,并且左子节点就是需要删除的节点,就将this.left = null,然后返回(结束递归删除)
     * 3.如果当前节点的右子节点不为空,并且右子节点就是需要删除的节点,就将this.right = null,然后返回(结束递归)
     * 4.如果123步骤没有找到需要删除的节点,则判断左子节节点是否为空,不为空,则继续递归删除
     * 5.如果向左递归没有找到需要删除的节点,则向右继续递归删除
     *
     * @param id 删除节点的id
     */
    public void delNode(int id) {
        //左子节点不为空,并且就是要删除的节点
        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }

        //右子节点不为空,并且就是要删除的节点
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }

        //没有找到需要删除的节点
        //如果左子节点不为空,想左进行递归删除
        if (this.left != null) {
            this.left.delNode(id);
        }

        //向右进行递归删除
        if (this.right != null) {
            this.right.delNode(id);
        }
    }
}
