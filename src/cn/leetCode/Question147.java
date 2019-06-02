package cn.leetCode;
import pers.utils.*;
public class Question147 {
    public static void main(String[]args)
    {
        int [] nums = new int[]{4};
        ListNode listNode = Question147.insertionSortList(ListUtils.getListNode(nums));
        ListUtils.printListNode(listNode);
        String str = "1 2 3 4 5";Question147.test(str);
        System.out.println(str);
    }
    public static void test(String str)
    {
        str.trim();

    }
    public int maxProduct(int[] nums) {
        if(nums == null||nums.length == 0) return 0;
        int length = nums.length;
        int max = nums[0];
        int num = nums[0];
        for(int i = 1;i<length;i++)
        {
            max = Math.max(max,nums[i]*num);
            num = nums[i];
        }
        return max;
    }
    public static ListNode insertionSortList(ListNode head) {
    if(head == null ||head.next == null) return head;
    ListNode target = new ListNode(0);
    target.next = head;
    //
    ListNode temp;
    ListNode start = target;
    while(head.next!=null)
    {
        if(head.next.val<head.val)
        {
            temp = head.next;
            while(start.next!= head)
            {
                if(start.next.val>temp.val)
                    break;
                else start = start.next;
            }
            head.next = temp.next;
            temp.next = start.next;
            start.next = temp;
            start = target;
        }
        else head = head.next;
    }
    return target.next;
}
}
