package cn.Algorithms;

import pers.utils.ListNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//LRU算法
//实现一个数据结构，完成对数据页的存储。当数据在最近一段时间被访问，那么它在以后也会经常被访问
//基于链表+hash表
//
public class LRUCache<V> {
    //双向链表
    public static class ListNode<K,V>{
        private K key;
        private V value;
        ListNode<K,V> next;
        ListNode<K,V> prev;
        public ListNode(K key,V value){
            this.key = key;
            this.value = value;
        }
        public ListNode(){

        }
    }
    //缓存容量
    private int capacity = 1024;
    //Node记录表
    private Map<String, ListNode<String,V>> table = new ConcurrentHashMap<>();
    //
    private ListNode<String,V> head;
    //
    private ListNode<String,V> tail;

    public LRUCache(int capacity){
        this();
        this.capacity = capacity;
    }
    public LRUCache()
    {
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
    }
    public V get(String key){
        //从table中取某个节点
        ListNode<String,V> node = table.get(key);
        //如果table中没有，返回null
        if(node == null)
            return null;
        //如果有。则需要把node提到链表的头部
        //先把node剥离前后两个node
        node.prev.next = node.next;
        node.next.prev = node.prev;
        //提到头部
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        //???存在缓存表
//        table.put(key,node);
        return node.value;
    }
    //存入缓存表中
    public void put(String key,V value){
        ListNode<String,V> node = table.get(key);
        if(node == null){
            if(table.size() == capacity){
                //如果超出容量了，需要先把尾部的节点移除
                //先把hash表中的数据移除
                table.remove(tail.prev.key);
                //再把双向链表中的数据移除
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            }
            //新建一个node 把数据移到头部
            node = new ListNode<>(key,value);
            table.put(key,node);
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }
        //如果不为空
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
