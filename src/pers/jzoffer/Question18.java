package pers.jzoffer;

import org.junit.Test;
import pers.utils.ListUtils;
import pers.utils.ListNode;

import java.util.List;

public class Question18 {
    //删除链表的节点
    //在O（1）的时间内删除链表节点 ,给出链表的头部和待删除的节点
    public void deleteNode(ListNode head,ListNode nodeToBeDeleted){
        if(head == null||nodeToBeDeleted == null) return;
        //如果不是最后一个节点，把后一个节点的内容拷贝到当前节点，把当前节点的next指向next.next
        if(nodeToBeDeleted.next!=null)
        {
            nodeToBeDeleted.val = nodeToBeDeleted.next.val;
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;
        }
        //如果是最后一个节点，要遍历链表查找
        else if(head.next == null) head = null;
        else{
            ListNode node = head;
            while(node.next!=null){
                if(node.next == nodeToBeDeleted){
                    node.next = node.next.next;
                }
            }
        }
    }
    //问题2 删除链表中的重复的节点
    public ListNode deleteDuplication(ListNode head){
        if(head == null) return null;
        //迭代删除
        ListNode target = new ListNode(0);
        target.next = head;
        ListNode currentNode = target;
        while(currentNode!=null&&currentNode.next!=null/*&&currentNode.next.next!=null*/){
            ListNode left = currentNode.next;
            ListNode right = currentNode.next;
            while(right.next!=null&&right.val==right.next.val){
                right = right.next;
            }
            if(right==left) currentNode = currentNode.next;
            else currentNode.next = right.next;
        }
//        ListNode result = target.next;
//        head = result;
        return target.next;
    }
    @Test
    public void test(){
        //0 2 2
        ListNode node = ListUtils.getListNode(new int[]{2,3});
        //ListNode head = node;
        //deleteNode(node,head);
//        node = deleteDuplication(node);
        //node = node.next;

//        delete(node);
        node = deleteDuplication(node);
        ListUtils.printListNode(node);
    }
    public void delete(ListNode head){
//        head = head.next;
        head.val =1;
    }
}