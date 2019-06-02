package pers.utils;

import java.util.List;

public class ListUtils {
    public static ListNode getListNode(int[] nums)
    {
        int length = nums.length;
        if(length==0) return null;
        ListNode listNode = new ListNode(nums[0]);
        ListNode target = listNode;
        int i = 1;
        length--;
        while(length!=0)
        {
            listNode.next = new ListNode(nums[i++]);
            listNode = listNode.next;
            length--;
        }
        return target;
    }
    public static void printListNode(ListNode head)
    {
        System.out.print("[");
        while(head!=null)
        {
            System.out.print(head.val+",");
            head = head.next;
        }
        System.out.print("]");
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode startNode = new ListNode(0);
        ListNode start;
        startNode.next = head;
        ListNode temp = null;
        while(head!=null&&head.next!=null)
        {
            temp = head.next;
            head.next = temp.next;
            temp.next = startNode.next;
            startNode.next = temp;
        }
        return startNode.next;
    }
}
