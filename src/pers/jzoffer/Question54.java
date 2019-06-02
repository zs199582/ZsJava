package pers.jzoffer;
import pers.utils.TreeNode;
public class Question54 {
    public static void main(String[]args)
    {
        int[] nums = {8,6,10,5,7,9,11};
        pers.utils.TreeNode root = pers.utils.TreeUtils.createTreeByLevel(nums);
        TreeNode node = KthNode(root,2);
    }
    public static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot==null ||k<=0) return null;
        //中序遍历
        return findKth(pRoot,k);

    }
    static int index = 1;
    public static TreeNode findKth(TreeNode node, int k)
    {
        TreeNode target = null;
        if(node.left!=null)
        target = findKth(node.left,k);
        if(target==null)
        {
            if(k==1)
                target = node;
            k--;
        }
        if(target==null&&node.right!=null)
        target = findKth(node.right,k);
        return target;
    }
}
