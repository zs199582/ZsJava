package pers.jzoffer;
import org.junit.Test;
import pers.utils.ListNode;
import pers.utils.ListUtils;

public class Question25 {
    //合并两个排序的链表
    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
    public ListNode mergeTwoList(ListNode headA,ListNode headB){
        //参数检查
        if(headA==null&&headB==null) return null;
        else if(headA ==null) return headB;
        else if(headB == null) return headA;
        else{
            //两个链表都不为空
            //1 3 4 6 8
            //2 9 10
            //向A中插入B链表 a的两个节点
            ListNode target = headA;   //保留头节点
            ListNode bNext = headB.next;
            while(headA!=null&&headA.next!=null&&headB!=null) {
//                boolean condition = (headB.val > headA.val) && (headB.val <= headA.next.val);
                if ((headB.val > headA.val) && (headB.val <= headA.next.val)) {
                    //插入b链表节点
                    headB.next = headA.next;
                    headA.next = headB;
                    //a链表后移
                    headA = headA.next;
                    headB = bNext;
                    if (headB != null)
                        bNext = headB.next;
                }
                else headA = headA.next;
            }
            if(headB!=null)
                headA.next = headB;
            return target;  //返回头节点
        }
    }
    //或者采用递归的方式来合并链表
    public ListNode mergeTwoList2(ListNode nodeA,ListNode nodeB){
        //
        ListNode mergeHead;
        if(nodeA==null&&nodeB==null) return null;
        else if(nodeA ==null) return nodeB;
        else if(nodeB == null) return nodeA;
        else{
            if(nodeA.val<nodeB.val){
                mergeHead = nodeA;
                mergeHead.next = mergeTwoList2(nodeA.next,nodeB);
            }
            else{
                mergeHead = nodeB;
                mergeHead.next = mergeTwoList2(nodeB.next,nodeA);
            }
        }
        return mergeHead;
    }
    @Test
    public void test(){
        ListNode nodeA = ListUtils.getListNode(new int[]{1,3,4,6,8});
        ListNode nodeB = ListUtils.getListNode(new int[]{2,8,10,64,102});
        ListNode target = mergeTwoList2(nodeA,nodeB);
        ListUtils.printListNode(target);
    }
}
