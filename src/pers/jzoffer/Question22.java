package pers.jzoffer;

import org.junit.Test;
import pers.utils.ListUtils;
import pers.utils.ListNode;
public class Question22 {
    //链表倒数第k个节点
    public ListNode getLastKthNode(ListNode head,int k){
        if(head == null||k<=0) return null;
        ListNode fast = head;
        ListNode slow = head;
        k--;
        //快指针提前走k步
        while(k!=0){
            k--;
            fast = fast.next;
            //防止k大于链表的长度
            if(fast==null) return null;
        }
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    @Test
    public void test(){
        ListNode head = ListUtils.getListNode(new int[]{1,2,3,4,5,6});
        head = getLastKthNode(head,7);
        System.out.println(head.val);
    }
}
