package pers.jzoffer;
import java.util.ArrayList;
import java.util.Stack;
import pers.utils.TreeNode;
public class Solution1 {
    public static void main(String[] args)
    {
        Solution1 solution1 = new Solution1();
        solution1.push(1);
        solution1.push(2);
        solution1.push(3);
        solution1.push(4);
        System.out.println(solution1.pop());
        System.out.println(solution1.pop());
        System.out.println(solution1.pop());
        System.out.println(solution1.pop());
        System.out.println(Math.pow(2,2));
    }
    //region 从尾到头打印链表
    /**
     * 从尾到头打印链表
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) return new ArrayList<>();
        //倒序插入
        ListNode temp ;
        ListNode newHead = listNode;
        while(listNode.next!= null)
        {
            temp = listNode.next;
            listNode.next = temp.next;
            temp.next = newHead;
            newHead = temp;
        }
        ArrayList<Integer> target = new ArrayList<>();
        while(newHead!=null)
        {
            target.add(newHead.val);
            newHead = newHead.next;
        }
//        throw new RuntimeException();
        return target;
    }
    //endregion
    //region 根据前序和中序遍历 重建二叉树
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length != in.length)
            return null;

        return construct(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    /**
     *
     * @param pre    前序遍历
     * @param ps    前序遍历的开始位置
     * @param pe    前序遍历的结束位置
     * @param in    中序遍历
     * @param is    中序遍历的开始位置
     * @param ie    中序遍历的结束位置
     * @return        数的根节点
     */
    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps > pe) return null;

        // 取前序遍历的第一个数字就是根节点
        int value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if(index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);

        return node;
    }
    //endregion
    //region 使用两个栈实现一个队列 完成push、pop操作
    Stack<Integer> stack2 = new Stack<Integer>();
    Stack<Integer> stack1 = new Stack<Integer>();
    public void push(int node)
    {
        stack1.push(node);
    }
    public int pop()
    {
        while(!stack1.empty())
            stack2.push(stack1.pop());
        int peek = stack2.pop();
        while(!stack2.empty())
            stack1.push(stack2.pop());
       return peek;
    }
    //endregion
    //region 旋转数组的最小数字
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        quickSort(array,0,array.length-1);
        return array[0];
    }
    public void quickSort(int[] array,int left,int right)
    {
        if(left<right)
        {
            int pivot = partition(array,left,right);
            quickSort(array,left,pivot-1);
            quickSort(array,pivot+1,right);
        }
    }
    public int partition(int[] array,int left, int right)
    {
        int temp = array[left];
        while(left!=right)
        {
            while(right>left&&!less(array[right],temp))
                right--;
            array[left] = array[right];
            while(right>left&&less(array[left],temp))
                left++;
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }
    public boolean less(int i,int j)
    {
        return i<j;
    }
    //endregion
    //region 斐波那契数列
    public int getFibonacci(int target)
    {
        if(target == 0) return 0;
        if(target == 1||target == 2) return 1;
        int result = 0,prePreResult = 0,preResult = 1;
        for(int i = 1;i<=target;i++)
        {
            result= prePreResult+preResult;
            prePreResult = preResult;
            preResult = result;
        }
        return result;
    }
    //endregion
}

class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }


