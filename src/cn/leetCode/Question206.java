package cn.leetCode;
import pers.utils.*;

import java.util.List;
import java.util.Stack;

public class Question206 {
    public static void main(String[]args)
    {
        int[] nums = {1,2,3,4,5};
        Question206 question206 = new Question206();
        ListNode listNode = question206.reverseList(ListUtils.getListNode(nums));

    }
    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode target = new ListNode(0);
        ListNode start;
        target.next = head;
        ListNode temp = null;
        while(head!=null&&head.next!=null)
        {
            temp = head.next;
            head.next = temp.next;
            temp.next = target.next;
            target.next = temp;
        }
        return target.next;
    }
}
