package pers.jzoffer;

import org.junit.Test;
import pers.utils.TreeNode;
import pers.utils.TreeUtils;

/**
 * 有点问题
 */
public class Question7 {
    //重建二叉树
    //输入二叉树的前序遍历和中序遍历的结果，重建该二叉树
    //假设输入的前序遍历和中序遍历的结果都不包含重复的数字
    //前序{1,2,4,7,3,5,6,8} 中序{4,7,2,1,5,3,8,6}
    public TreeNode recreateTree(int[] preOrder,int[] midOrder){
        if(preOrder==null||midOrder == null||preOrder.length!=midOrder.length) return null;
        TreeNode root = getTree(preOrder,0,preOrder.length-1,midOrder,0,midOrder.length-1);
        return root;
    }

    private TreeNode getTree(int[] preOrder, int preStart, int preEnd, int[] midOrder, int midStart, int midEnd) {
        if(preEnd==preStart) return new TreeNode(preOrder[preStart]);
        TreeNode root = new TreeNode(preOrder[preStart]);
        int index = getIndex(midOrder,root.val);
        int leftLength = index-midStart;
        int rightLength = midEnd-index;
        root.left = getTree(preOrder,preStart+1,preStart+leftLength,midOrder,midStart,index-1);
        root.right = getTree(preOrder,preStart+leftLength+1,preEnd,midOrder,index+1,index+rightLength);
        return root;
    }
    private int getIndex(int[] num,int target){
        for(int i = 0;i<num.length;i++){
            if(num[i] == target)
                return i;
        }
        return -1;
    }
    @Test
    public void test(){
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] midOrder = {4,7,2,1,5,3,8,6};
      TreeNode root = recreateTree(preOrder,midOrder);
        TreeUtils.levelTraverse(root);
    }
}
