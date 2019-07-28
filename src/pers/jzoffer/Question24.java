package pers.jzoffer;
import pers.utils.ListNode;

public class Question24 {
    //反转链表
    //输入一个链表的头节点，反转该链表并输出反转后链表的头节点
//    public ListNode reverseList(ListNode head){
//
//    }
    //迭代方式实现
    public ListNode reverseList(ListNode head){
        if(head == null||head.next==null) return head;
        ListNode p = head;
        ListNode prev = null;
        while(p!=null){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
    //递归方式实现
    public ListNode reverseListRecursive(ListNode head){
        if(head == null|| head.next ==null)
            return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}