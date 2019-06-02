package pers.jzoffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pers.utils.TreeNode;
public class Question {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    if(pRoot == null) return new ArrayList<>();
    ArrayList<ArrayList<Integer> > target= new ArrayList<ArrayList<Integer>>();
    int depth = depth(pRoot);
    for(int i = 1;i<=depth;i++) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        levelTraverse(pRoot, i, list);
        target.add(list);
    }
    return target;
}
    public void levelTraverse(TreeNode node,int depth,List<Integer>list)
    {
        if(depth == 0) return;
        if(depth == 1) list.add(node.val);
        levelTraverse(node.left,depth-1,list);
        levelTraverse(node.right,depth-1,list);
    }
    public int depth(TreeNode node)
    {
        if(node == null) return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return (left>right?left:right)+1;
    }
    public void test(String str)
    {
        int[][] array = new int[2][3];

    }
}
