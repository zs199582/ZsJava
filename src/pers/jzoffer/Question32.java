package pers.jzoffer;

        import pers.utils.TreeNode;
        import pers.utils.TreeUtils;

        import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Stack;

public class Question32 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7,8,9,10};
        TreeNode root = TreeUtils.createTreeByLevel(nums);
        zShapeLevelTraverse(root);
    }
    /**
     * 题目一：从上到下打印二叉树
     * 按层进行打印二叉树
     * 考的就是层序遍历
     */
    public static void levelTraverse(TreeNode root){
        if(root == null) return;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
    }

    /**
     * 题目二：分行从上到下打印二叉树
     * 输出的时候，一层就是一行
     */
    public static void lineLevelTraverse(TreeNode root){
        if(root ==null) return;
        root.level=0;
        int currentLevel = 0;
        //在向队列中添加节点时，把子节点的level等于父节点level+1
        //从队列中取节点时，如果level值不等于当前level，说明已经进入下一层了
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            if(node.level!=currentLevel){
                System.out.print("\n");
                currentLevel = node.level;
            }
            System.out.print(node.val+" ");
            if(node.left!=null){
                node.left.level=node.level+1;
                queue.add(node.left);
            }
            if(node.right!=null){
                node.right.level=node.level+1;
                queue.add(node.right);
            }
        }
    }
    /**
     * 题目三 之字形打印二叉树
     * 按照之字形打印二叉树
     */
    //思路1 使用两个栈来实现左右次序的调换
    public static void zShapeLevelTraverse1(TreeNode treeNode){
        //         1
        //    2          3
        //  4   5     6     7
        //8 9 10 11 12 13 14 15
        //打印顺序1 3 2 4 5 6 7 15 14 13
        if (treeNode == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(treeNode);
        while (stack1.size() != 0 || stack2.size() != 0) {
            if (stack1.size() == 0) {
                while (stack2.size() != 0) {
                    TreeNode node2 = stack2.pop();
                    System.out.println(node2.val);
                    //先右后左
                    if (node2.right != null)
                        stack1.push(node2.right);
                    if (node2.left != null)
                        stack1.push(node2.left);
                }
            }
            if (stack2.size() == 0) {
                while (stack1.size() != 0) {
                    TreeNode node1 = stack1.pop();
                    System.out.println(node1.val);
                    //先左后右
                    if (node1.left != null)
                        stack2.push(node1.left);
                    if (node1.right != null)
                        stack2.push(node1.right);
                }
            }
        }
    }
    //思路2 判断层号，调换顺序
    public static void zShapeLevelTraverse(TreeNode root){
        if(root == null) return;
        root.level=0;
        int currentLevel = 0;
        boolean flag = true;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()!=0){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.level!=currentLevel){
                flag = !flag;
                currentLevel = node.level;
            }
            if(flag) {
                if (node.left != null) {
                    node.left.level = node.level + 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.level = node.level + 1;
                    queue.add(node.right);
                }
            }
            else{
                if (node.right != null) {
                    node.right.level = node.level + 1;
                    queue.add(node.right);
                }
                if (node.left != null) {
                    node.left.level = node.level + 1;
                    queue.add(node.left);

                }
            }
        }
    }

}
