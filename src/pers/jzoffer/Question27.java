package pers.jzoffer;

import org.junit.Test;
import pers.utils.TreeNode;
import pers.utils.TreeUtils;

public class Question27 {
    //二叉树的镜像
    //输入一棵二叉树，输出它的镜像
    public void mirrorBinaryTree(TreeNode root){
        //参数检查
        if(root == null) return;
        TreeNode temp;
        if(root.left==null&&root.right==null) return;
        else{
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorBinaryTree(root.left);
            mirrorBinaryTree(root.right);
        }
    }
    @Test
    public void test(){
        TreeNode root = TreeUtils.createTreeByLevel(new int[]{1,2,3,4,5,6,7});
        mirrorBinaryTree(root);
        TreeUtils.levelTraverse2(root);
    }
}
