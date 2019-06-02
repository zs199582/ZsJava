package pers.jzoffer;
import pers.utils.TreeNode;
public class Question26 {
    public static void main(String[] args)
    {

    }
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return false;
        boolean target;
        if(root1 == root2)  return true;
        else
        {
            target = HasSubtree(root1.left,root2);
            if(target == true) return true;
            else
            {
                target = HasSubtree(root1.right,root2);
                if(target == true) return true;
                else return false;
            }
        }
    }
}
