package cn.leetCode;
import java.util.*;
import pers.utils.TreeNode;
import pers.utils.TreeUtils;

public class Question257 {
    public static void main(String[] args)
    {
        Question257 question257 = new Question257();
        int[] nums = {1,2,3,4};
        List<String> s = question257.binaryTreePaths(TreeUtils.createTreeByLevel(nums));

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<String>();
        StringBuffer sbf = new StringBuffer();
        if(root==null) return path;
        sbf.append(root.val);
        if(root.left==null&&root.right==null)
        {
            path.add(String.valueOf(root.val));
        }
        else if(root.left!=null&&root.right!=null)
        {
            StringBuffer copy = new StringBuffer(sbf.toString());
            getPaths(root.left,path,sbf);
            getPaths(root.right,path,copy);
        }
        else if(root.left!=null) getPaths(root.left,path,sbf);
        else getPaths(root.right,path,sbf);
        return path;
    }
    public void getPaths(TreeNode node,List<String>list,StringBuffer pathNow)
    {
//        if(node == null)
//        {
//            list.add(pathNow.toString());
//            return;
//        }
        pathNow.append("->").append(node.val);
        StringBuffer copyPath;
        if(node.left!=null&&node.right!=null)
        {
            copyPath = new StringBuffer(pathNow.toString());
            getPaths(node.left,list,pathNow);
            getPaths(node.right,list,copyPath);
        }
        else if(node.left!=null)
            getPaths(node.left,list,pathNow);
        else if(node.right!=null)
            getPaths(node.right,list,pathNow);
        else list.add(pathNow.toString());
        return;
    }
}
