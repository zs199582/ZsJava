package pers.jzoffer;

public class Question23 {
    //链表中环的入口节点
    //如果一个链表中包含环，如何找到环的入口节点
    public ListNode getEnterOfRing(ListNode head){
        if(head == null) return null;
        int numOfRing = 0;
        //求环中节点的个数k
        ListNode fast = head.next.next;
        ListNode slow = head;
        while(fast!=slow){
            fast = fast.next.next;
            slow = slow.next;
        }
        while(fast.next.next!=slow.next) numOfRing++;
        numOfRing++;
        //指针归0
        fast = head;
        slow = head;
        //快指针提前走k步，当两个指针相遇的时候，所在位置就是环的入口
        while(numOfRing!=0){
            numOfRing--;
            fast = fast.next;
        }
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

}
