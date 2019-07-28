package pers.jzoffer;
import org.junit.Test;
import pers.utils.TreeNode;
import pers.utils.TreeUtils;

public class Question26 {
    //树的子结构
    //输入两颗二叉树结构A和B 判断B是不是A的子结构
    public static void main(String[] args)
    {

    }
    @Test
    public void test(){
        TreeNode tree = TreeUtils.createTreeByLevel(new int[]{1,2,3,4,5,6,7,8,9});
        TreeNode subTree = tree.left.left.right;
        System.out.println(judgeSubTree(tree,subTree));
    }
    public boolean judgeSubTree(TreeNode rootA,TreeNode rootB){
        if(rootA == null||rootB == null) return false;
        if(rootA == rootB) return true;
        if(rootA.left == rootB ||rootA.right == rootB) return true;
        else
            return judgeSubTree(rootA.left,rootB)||judgeSubTree(rootA.right,rootB);
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
