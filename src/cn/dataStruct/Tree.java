package cn.dataStruct;

import org.junit.jupiter.api.Test;

//二叉树
public class Tree {
    TreeNode root;
    public Tree()
    {
        root = null;
    }
    @Test
    public void insert(int data)
    {
        TreeNode newNode = new TreeNode(data);
        if(root == null)
        {
            this.root = newNode;
        }
        else
        {
            TreeNode current;
            TreeNode parent;
            current = root;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    //parent = current;
                    if(current == null)
                    {
                        parent.left = newNode;
                        return;
                    }
                }
                else
                {
                    current = current.right;
                    if(current == null)
                    {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    //构建
    public void build(int[]datas)
    {
        for (int data:datas
             ) {
            this.insert(data);
        }
    }
    //中序遍历
    public void inOrder(TreeNode root){
        if(root!=null)
        {
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    //前序遍历
    public void preOrder(TreeNode root)
    {
        if(root!= null)
        {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    //后序遍历
    public void postOrder(TreeNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    @Override
    public String toString() {
        return "";
    }

    public static void main(String[] args)
    {
        int[] testTreeData = {1,20,13,45,58,46,17,28,9,10};
        Tree testTree = new Tree();
        testTree.build(testTreeData);
        testTree.inOrder(testTree.root);
    }
}
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}