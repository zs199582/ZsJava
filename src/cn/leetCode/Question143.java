package cn.leetCode;
import pers.utils.*;

import java.lang.annotation.Target;

public class Question143 {
    public static void main (String[] args)
    {
        int [] nums = new int[]{1,2,3,4,5};
        Question143 question143 = new Question143();
        ListNode listNode = question143.reorderList(ListUtils.getListNode(nums));
        ListUtils.printListNode(listNode);
    }
    public ListNode reorderList(ListNode head) {
        if(head == null ||head.next == null) return head;
        //快慢指针找到中点
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode target = head;
        while(fast!=null&&fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        //中点是slow
        //后半部本反转
        ListNode moveLocat = slow.next;
        ListNode temp;
        ListNode moveEle;
        while(moveLocat!=null&&moveLocat.next!=null)
        {

            moveEle = moveLocat.next;
            temp = slow.next;
            moveLocat.next = moveEle.next;
            slow.next = moveEle;
            moveEle.next = temp;

        }

        //将后半部分插到前面
        while(head!=null&&head.next!=null)
        {
            temp = slow.next;
            slow.next = slow.next.next;
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        return target;
    }
    public void quickSort(int[] nums)
    {
        sort(nums,0,nums.length);
    }
    public int[] sort(int[] nums,int start,int end)
    {
        if(start>=end) return nums;
        int pivot = partition(nums,start,end);
        sort(nums,start,pivot-1);
        sort(nums,pivot+1,end);
        return nums;
    }
    public int partition(int[] nums,int start,int end)
    {
        int temp = nums[start];
        while(start!=end)
        {
            while(end>start&&!less(nums[end],temp))
                end--;
            nums[start] = nums[end];
            while(end>start&&less(nums[start],temp))
                start++;
            nums[end] = nums[start];
        }
        nums[start] = temp;
        return start;
    }
    public boolean less(int a,int b)
    {
        return a<b;
    }
}
