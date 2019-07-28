package pers.jzoffer;

import org.junit.Test;
import pers.utils.TreeNode;
import pers.utils.TreeUtils;

public class Question28 {
    //对称的二叉树
    //给一个二叉树，判断其是否是镜像的
    public boolean isMirror(TreeNode root){
        //参数检查
        if(root == null) return true;
        //
        return isMirrorCore(root.left,root.right);
    }
    public boolean isMirrorCore(TreeNode left,TreeNode right){
        if(left == null&& right ==null) return true;
        if(left == null&& right !=null) return false;
        if(left != null&& right ==null) return false;
        //left和right都不是null
        if(left.val == right.val)
        {
            return isMirrorCore(left.left,right.right)&&isMirrorCore(left.right,right.left);
        }
        else return false;
    }
    //第二种解法 终极笨比解法，招商银行一面算法题，用层序遍历，输出每一层的值，判断每一层是否是正反相等的。
    @Test
    public void test(){
        TreeNode node = TreeUtils.createTreeByLevel(new int[]{8,6,6,5,7,7,5});
        System.out.println(isMirror(node));
    }
}
