package cn.leetCode;
import pers.utils.*;
public class Question234 {
    public static void main(String[]args)
    {
        int[] num = {1,2};
        System.out.println(Question234.isPalindrome(ListUtils.getListNode(num)));
    }
    public static boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null) return false;
        //快慢指针找到链表中点
        ListNode slow = head;
        ListNode fast = head;
        ListNode second = null;
        while(fast!=null&&fast.next!=null)
        {
            second = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        second.next = null;
        slow = reverseList(slow);
        while(slow!=null&&head!=null)
        {
            if(slow.val!=head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        if(slow!=null||head!=null) return false;
        return true;

    }
    //
    public static ListNode reverseList(ListNode head) {
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
    public double Power(double base, int exponent) {
        return Math.pow(base,exponent);
    }

}
