package com.mmall.MainShiTi;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static int capacity;
    private static Map<Integer,CacheNode> valModelMap = new HashMap<>();
    private static CacheNode head = new CacheNode(-1,-1);
    private static CacheNode tail = new CacheNode(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public static CacheNode get(int key) {
        if(!valModelMap.containsKey(key)){
            return null;
        }
        CacheNode current = valModelMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);//移动到最后一位
        return valModelMap.get(key);
    }

    private static void moveToTail(CacheNode current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }

    public static void put(int key, int value) {
        if(get(key) != null){
            valModelMap.get(key).value = value;
            return;
        }

        if(valModelMap.size() == capacity){
            valModelMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        CacheNode insert = new CacheNode(key,value);
        valModelMap.put(key,insert);
        moveToTail(insert);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
//        CacheNode cache1 = new CacheNode(1,1);
//        CacheNode cache2 = new CacheNode(2,2);
//        CacheNode cache3 = new CacheNode(3,3);
//        cache1.next = cache2;
//        cache2.prev = cache1;
//        cache2.next = cache3;
//        cache3.prev = cache2;
        put(3,3);
        put(4,4);
        put(2,2);
        System.out.println(get(2).prev.value);
        System.out.println(get(4).prev.value);
        System.out.println(get(3).prev.value);
    }
}

class CacheNode {
    CacheNode next;
    CacheNode prev;
    int key;
    int value;

    public CacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}