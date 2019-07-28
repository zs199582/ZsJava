package pers.jzoffer;

import org.junit.Test;
import pers.utils.ListNode;
import pers.utils.ListUtils;
import pers.utils.UtilsMethod;

import java.util.Stack;

public class Question6 {
    //从尾到头打印链表
    //递归的方式
    public void printList(ListNode head){
        if(head == null) return ;
        printList(head.next);
        System.out.println(head.val+" ");
    }
    //使用栈来实现后进先出
    public void printList2(ListNode head){
        if(head == null) return;
        Stack<Integer> stack = new Stack<>();
        while(head!=null) {
            stack.push(head.val);
            head = head.next;
        }
        while(stack.size()!=0)
            System.out.println(stack.pop());
    }
    @Test
    public void test(){
        pers.utils.ListNode node = ListUtils.getListNode(new int[]{1,2,3,4,5,6,7});
//        printList(node);
        printList2(node);
    }
}
