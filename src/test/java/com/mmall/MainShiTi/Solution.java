package com.mmall.MainShiTi;

public class Solution {
    /*反转*/
    public static ListNode reverse (ListNode head,int m,int n){
        if(head == null || m >= n){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for(int i = 1;i < m;i++){
            head = head.next;
        }

        ListNode prevM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        for(int i = m;i < n;i++){
            ListNode next = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = next;
        }
        mNode.next = postN;
        prevM.next = nNode;
        System.out.println(dummy.next.next.val);
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = reverse(head,2,4);
        System.out.println(head.next.val);
    }
}

class ListNode {
    int val;
    ListNode next;   // 下一个链表对象
    ListNode(int x) { val = x; }  //赋值链表的值
}