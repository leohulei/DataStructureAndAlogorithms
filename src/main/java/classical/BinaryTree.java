package src.main.java.classical;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {


    //二叉树的前，中、后与层序遍历
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        System.out.println("------前序遍历------");
        preOrder(node1);
        System.out.println("------中序遍历------");
        midOrder(node1);
        System.out.println("------后序遍历------");
        behideOrder(node1);
        System.out.println("------层序遍历------");
        ArrayList<Integer> list = new ArrayList<>();
        levelOrder(node1,1,list);
        list.removeAll(Collections.singleton(null));//去除集合中的null元素
        System.out.println(list);
    }


    //前序遍历：根左右
    public static void preOrder(TreeNode root){
        if(root == null){//根节点为null 二叉树为空，直接出栈
            return;
        }
        System.out.println(root.val);//第一次成为栈顶的元素打印
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历：左根右
    public static void midOrder(TreeNode root){
        if(root == null){//根节点为null 二叉树为空，直接出栈
            return;
        }
        midOrder(root.left);
        System.out.println(root.val);//第二次成为栈顶的元素打印
        midOrder(root.right);
    }

    //后序遍历：左右根
    public static void behideOrder(TreeNode root){
        if(root == null){//根节点为null 二叉树为空，直接出栈
            return;
        }
        behideOrder(root.left);
        behideOrder(root.right);
        System.out.println(root.val);//第三次成为栈顶的元素打印
    }

    //层序遍历：上-->下  左-->右
    public static void levelOrder(TreeNode root, int i, List<Integer> list){
        if(root == null){//根节点为null 二叉树为空，直接出栈
            return;
        }
        int length = list.size();
        if(length <= i){//长度不够，避免下边越界
            for (int j = 0; j <= i-length; j++) {
                list.add(length+j,null);
            }
        }
        list.set(i,root.val);//add方法扩容会移位所以用set
        levelOrder(root.left,2*i,list);
        levelOrder(root.right,2*i+1,list);
        System.out.println(root.val);//第三次成为栈顶的元素打印
    }
}
