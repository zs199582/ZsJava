package pers.jzoffer;
import pers.utils.*;

public class ReverseList {
    public static void main(String[]args)
    {
        int[] num = {1,2,3,4,5,6,7,8,9,10};
        ListUtils.printListNode(ReverseList.ReverseList(ListUtils.getListNode(num)));
    }
    public static pers.utils.ListNode ReverseList(pers.utils.ListNode head) {
        if(head == null||head.next==null) return head;
        if(head.next.next == null)
        {
            pers.utils.ListNode temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }
        pers.utils.ListNode tail = head;
        pers.utils.ListNode newHead = head.next;
        pers.utils.ListNode newHeadNext = newHead.next;
        tail.next = null;
        while(newHead!=null)
        {
            newHead.next = tail;
            tail = newHead;
            newHead = newHeadNext;
            if(newHeadNext!=null)
            newHeadNext=newHeadNext.next;
        }
        return tail;
    }
}
