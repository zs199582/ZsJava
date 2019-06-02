package pers.utils;
import pers.utils.TreeNode;

import java.util.*;

public class TreeUtils {
    public static void main(String[]args)
    {
        int[] nums = {1,2,3,4,5,6,7};
        TreeNode tree = TreeUtils.createTreeByLevel(nums);
        TreeUtils.levelTraverseExercise(tree);
        StringBuffer sbf = new StringBuffer();
        sbf.append("sss");
        System.out.println(sbf.toString());
    }

    //从前序遍历得到一棵树
//    public static TreeNode getATreeFromPreOrder()
//    {
//        List<List<Integer>> target = new ArrayList<List<Integer>>();
//        List<Integer> path = new ArrayList<>();
//        ArrayList copyPath =  (ArrayList<Integer>) ((ArrayList<Integer>) path).clone();
//        ((ArrayList<List<Integer>>) target).clone();
//    }
    //region 递归实现前序遍历
    public static int[] preOrderTraverse(TreeNode treeNode)
    {
        if(treeNode == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList();
        while(treeNode!=null)
        {
            list.add(treeNode.val);
            preOrderTraverse(treeNode.left);
            preOrderTraverse(treeNode.right);
        }
        //将list转成数组输出
        int[] preOrder = new int[list.size()];
        for(int index = 0;index<list.size();index++)
        {
            preOrder[index] = list.get(index);
        }
        return preOrder;
    }
    //endregion
    //region 非递归实现前序遍历
    public static void nonRecursivePreOrderTraverse(TreeNode root)
    {
        //使用栈存储 为了访问右节点
        List<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty())
        {
            if(root != null)
            {
                System.out.println(root.val);
                ((LinkedList<TreeNode>) stack).push(root);
                root = root.left;
            }
            else
            {
                root = ((LinkedList<TreeNode>) stack).pop();
                root = root.right;
            }
        }
    }
    //endregion
    //region 递归实现中序遍历
    public static int[] midOrderTraverse(TreeNode treeNode)
    {
        if(treeNode == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList();
        while(treeNode!=null)
        {
            midOrderTraverse(treeNode.left);
            list.add(treeNode.val);
            midOrderTraverse(treeNode.right);
        }
        //将list转成数组输出
        int[] midOrder = new int[list.size()];
        for(int index = 0;index<list.size();index++)
        {
            midOrder[index] = list.get(index);
        }
        return midOrder;
    }
    //endregion
    //region 非递归实现中序遍历
    public static void nonRecursiveMidOrderTraverse(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null||!stack.isEmpty())
        {
            if(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            else
            {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }
    //endregion
    //region 遍历实现后序遍历
    public static int[] postOrderTraverse(TreeNode treeNode)
    {
        if(treeNode == null) return new int[]{};
        ArrayList<Integer> list = new ArrayList();
        while(treeNode!=null)
        {
            postOrderTraverse(treeNode.left);
            postOrderTraverse(treeNode.right);
            list.add(treeNode.val);
        }
        //将list转成数组输出
        int[] postOrder = new int[list.size()];
        for(int index = 0;index<list.size();index++)
        {
            postOrder[index] = list.get(index);
        }
        return postOrder;
    }
    //endregion
    //region 非遍历实现后序遍历(左右根)
    public static void nonRecursivePostTraverse(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null||!stack.isEmpty())
        {
            if(root!=null)
            {
                stack.push(root);
                root = root.right;
            }
            else
            {
                root = stack.pop();
                root = root.right;
                if(root!=null)
                System.out.println(root.val);
            }
        }
    }
    //endregion
    //region 层序遍历(递归)
    public static void levelTraverse(TreeNode treeNode)
    {
        if(treeNode == null) return;
        int depth = depth(treeNode);
        for(int i = 1;i<depth;i++)
        {
            levelTraverse(treeNode,i);
        }
    }
    private static void levelTraverse(TreeNode Node, int level) {
        if (Node == null || level < 1) {
            return;
        }

        if (level == 1) {
            System.out.print(Node.val + "  ");
            return;
        }

        // 左子树
        levelTraverse(Node.left, level - 1);

        // 右子树
        levelTraverse(Node.right, level - 1);
    }

    private static int depth(TreeNode treeNode) {
        if(treeNode==null) return 0;
        int leftDepth = depth(treeNode.left);
        int rightDepth = depth(treeNode.right);
        return leftDepth>rightDepth?leftDepth+1:rightDepth+1;
    }
    //endregion
    //region 层序遍历(非递归 队列)
    public static void levelTraverse2(TreeNode treeNode)
    {
        if(treeNode==null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }
    //endregion
    //region 层序遍历 通过数组的形式返回每一层的数据
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> target = new ArrayList();
        List<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            levelList = new ArrayList<Integer>();
            while(size!=0)
            {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                size--;
            }
            target.add(levelList);
        }
        return target;
    }
    //endregion
    //region 根据层序遍历生成二叉树
    public static TreeNode createTreeByLevel(int[] str) {
        if (str.length == 0) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        int stop = 2;
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < str.length; i++)
        {
            if (i == stop - 1)
            {
                list.add(li);
                li = new ArrayList<>();
                stop = stop * 2;
            }
            li.add(str[i]);
        }
        list.add(li);
        return createTreeByLevel(list, 0);

    }

    private static TreeNode createTreeByLevel(List<List<Integer>> list, int level) {
        if (level >= list.size() || list.get(level).isEmpty()) {
            return null;
        }
        Integer val = list.get(level).remove(0);
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = createTreeByLevel(list, level + 1);
        node.right = createTreeByLevel(list, level + 1);
        return node;
    }
    //endregion
    //region 层序遍历练习(遍历)
    public static void levelTraverseExercise(TreeNode root)
    {
        //遍历法
        if(root == null) return;
        int depth = depth(root);
        for(int i=1;i<=depth;i++)
        {
            levelTraverseExercise(root,i);
        }
    }
    public static void levelTraverseExercise(TreeNode node,int depth)
    {
        if(node == null) return;
        if(depth == 0) return;
        if(depth==1)
            System.out.println(node.val);
        else
        {
            levelTraverseExercise(node.left,depth-1);
            levelTraverseExercise(node.right,depth-1);
        }
    }
    //endregion
    //region 层序遍历练习(非遍历)
    public static void nonRecurLevelTraverseExc(TreeNode root)
    {
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }
    //endregion

}
