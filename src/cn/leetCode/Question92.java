package cn.leetCode;
import pers.utils.*;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 1 ≤ m ≤ n ≤ 链表长度。
 *输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class Question92 {
    public static void main(String[]args)
    {
        Question92 question92 = new Question92();
        int[] nums = new int[]{1,2,3,4,5};
        ListNode listNode = question92.reverseBetween(ListUtils.getListNode(nums),2,4);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
        if(m==n) return head;
        ListNode target = head;
        ListNode nextNode = head.next;
        ListNode temp;
        ListNode moveEleLocat;
        //插入次数
        int chageCount = n-m;
        //找到插入位置
        m-=2;
        while(m!=0)
        {
            head = head.next;  //2-4  0为head
            m--;
        }
        moveEleLocat = head.next.next;
        //
        while(chageCount!=0)
        {
            temp = moveEleLocat;
            //head.next.next = temp.next;
            nextNode.next = temp.next;
            temp.next = head.next;
            head.next = temp;
            chageCount--;
            moveEleLocat = moveEleLocat.next;
        }
        return target;
    }
}
