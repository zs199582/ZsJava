package cn.leetCode;
import pers.utils.*;
/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 */
public class Question109 {
    /**
     * 主要是构建二叉搜索树 找到链表的中点 左边为左子树 右边为右子树
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        //快慢指针法
        return buildBST(head,null);
    }
    public TreeNode buildBST(ListNode start, ListNode end)
    {
        if(start == end) return null;
        //
        ListNode oneStepNode = start;
        ListNode twoStepNode = start;
        while(twoStepNode != end&&twoStepNode.next!=end)
        {
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
        }
        TreeNode target = new TreeNode(oneStepNode.val);
        target.left = buildBST(start,oneStepNode);
        target.right = buildBST(oneStepNode.next,end);
        return target;
    }
}
