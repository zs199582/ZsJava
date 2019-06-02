package cn.dataStruct;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

/**
 * 找终止条件：当head指向链表只剩一个元素的时候，自然是不可能重复的，因此return
 * 想想应该返回什么值：应该返回的自然是已经去重的链表的头节点
 * 每一步要做什么：宏观上考虑，此时head.next已经指向一个去重的链表了，而根据第二步，我应该返回一个去重的链表的头节点。
 * 因此这一步应该做的是判断当前的head和head.next是否相等，如果相等则说明重了，返回head.next，否则返回head
 * 如果独立写递归函数有困难的，可以参考一下我写的一个博客，附有详细的图文介绍，直接学会套路后就可以秒这种递归题了。
 * 博客链接 (很菜的博客，是这学期开了一门互联网开发课，刚学了前端和springboot然后从找教程0搭的搞着玩的，大佬轻喷哈）
 * @param <T>
 */
public class SEList<T> {
    public static void main(String[] args)
    {
        Integer[] arr = {2,1};
        SEList<Integer> seList = new SEList<>();
        ListNode listNode = seList.generateList(arr);
        ListNode test = seList.partition(listNode,2);
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode header = new ListNode(0);
        header.next = head;
        boolean returnFlag = false;
        //找到分割点
        while(header.next!=null&&header.next.val<x) header = header.next;
        //保留分割点
        ListNode addPoint = header;
        if(addPoint.next ==  head)
        {
            head = addPoint;
            returnFlag = true;
        }
        while(header.next!=null)
        {
            if(header.next.val<x)
            {
                ListNode newNode = new ListNode(header.next.val);
                newNode.next = addPoint.next;
                addPoint.next = newNode;
                addPoint = newNode;
                header.next = header.next.next;
            }
            else
            {
                header = header.next;
            }
        }
        return returnFlag?head.next:head;
    }
//    public ListNode uniqueDuplicates(ListNode head) {
//        if(head == null) return head;
//        ListNode target = new ListNode(0);
//        ListNode returnList = target;
//        Set<Integer> hashSet = new HashSet();
//        while(head!=null)
//        {
//            hashSet.add(head.val);
//            head = head.next;
//        }
//        Iterator iterator = hashSet.iterator();
//        while(iterator.hasNext())
//        {
//            target.next = new ListNode((int)iterator.next());
//            target = target.next;
//        }
//        return returnList.next;
//    }
public ListNode uniqueDuplicates(ListNode head) {
    if(head == null) return head;
    ListNode header = new ListNode(-1);
    header.next = head;
    ListNode cur = header;
    Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
    while(cur.next!=null)
    {
        if(hashMap.get(cur.next.val) == null)
            hashMap.put(cur.next.val,1);
        else
            hashMap.put(cur.next.val,hashMap.get(cur.next.val)+1);
        cur = cur.next;
    }
    cur = header;
    while(cur.next!= null)
    {
        if(hashMap.get(cur.next.val)!=null)
        {
            hashMap.remove(cur.next.val);
            cur = cur.next;
        }
        else
        {
            cur.next = cur.next.next;
        }
    }
    return header.next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        while(cur.next!=null)
        {
            if(hashMap.get(cur.next.val) == null)
                hashMap.put(cur.next.val,1);
            else
                hashMap.put(cur.next.val,hashMap.get(cur.next.val)+1);
            cur = cur.next;
        }
        cur = header;
        while(cur.next!= null)
        {
            if(hashMap.get(cur.next.val)!=1)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return header.next;
        /** 评论里c++的解 22赞
         * ListNode* deleteDuplicates(ListNode* head) {
         *         ListNode* p=new ListNode(0);
         *         p->next=head;
         *         head=p;
         *         ListNode *left,*right;
         *         while(p->next)
         *         {
         *             left=p->next;
         *             right=left;
         *             while(right->next && right->next->val==left->val)
         *                 right=right->next;
         *             if(left == right) p=p->next;
         *             else p->next=right->next;
         *         }
         *         return head->next;
         *     }
         */
    }
    public ListNode generateList(Integer[] values)
    {
        if(values.length == 0) return null;
        ListNode list= new ListNode((int)values[0]);
        ListNode returnList = list;
        for(int i = 1;i<values.length;i++)
        {
            list.next = new ListNode((int)values[i]);
            list = list.next;
        }
        return returnList;
    }
}
class ListNode
{
    int val;
    ListNode next;
    ListNode(int val){this.val = val;}
}
