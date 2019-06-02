package cn.leetCode;
import pers.utils.*;

import java.util.ArrayList;
import java.util.List;
public class Question102 {
    List<List<Integer>> target = new ArrayList();
    List<Integer> levelList = new ArrayList<Integer>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return target;
        int depth = depth(root);
        for(int i = 1;i<depth;i++)
        {
            eachLevelOrder(root,i);
        }
        return target;
    }
    public void eachLevelOrder(TreeNode node,int depth)
    {
        if(depth == 0) return;
        if(depth == 1)
            levelList.add(node.val);
        else
        {
            eachLevelOrder(node.left,depth-1);
            eachLevelOrder(node.right,depth-1);
            target.add(levelList);
            levelList = new ArrayList<Integer>();
        }
    }
    public int depth(TreeNode root)
    {
        if(root == null) return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
}
