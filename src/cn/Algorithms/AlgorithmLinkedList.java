package cn.Algorithms;

import java.util.List;

public class AlgorithmLinkedList {
    public void reverseLinkedList(ListNode node)
    {
            System.out.println("aa");
    }
    /**
     * 给定一个带头结点的单链表，请将其逆序。head->7->6->5->4->3 变成 head->3->4->5->6->7
     */
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        ListNode cursor = head;
        head = head.next;
        System.out.println(cursor.data);
    }
}
class ListNode
{

    public int data;

    public ListNode next;

    public ListNode(int data)
    {
        this.data = data;
    }
}