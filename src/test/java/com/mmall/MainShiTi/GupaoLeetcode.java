package com.mmall.MainShiTi;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 咕泡2020年 算法题 训练~~~加油
 * PoffyZhang
 */
public class GupaoLeetcode {
    /**
     * 1.翻转链表 一 (用栈的方法)
     * @param
     */
    public ListNode reverseListStack(ListNode head){
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        //利用栈设计先进后出的翻转效果
        Stack<ListNode> stackNode = new Stack();
        while (head != null){
            stackNode.push(head);
            head = head.next;
        }
        //取出 第一个节点作为哨兵的下一个
        ListNode newHead = new ListNode(0);
        if(!stackNode.isEmpty()){
            newHead = stackNode.pop();
            dummy.next = newHead;
        }
        while (!stackNode.isEmpty()){
            newHead.next = stackNode.pop();
            newHead = newHead.next;
        }
        //最后做一个ending
        newHead.next = null;
        return dummy.next;
    }

    /**
     * 1.翻转链表 一 (普通遍历的方法)
     * @param
     */
    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode prev = head;
        ListNode current = head.next;

        prev.next = null;
        while (current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    /**
     * 2.翻转链表 二
     * @param
     */
    public ListNode reverseList2(ListNode head,int m,int n){
        if(head == null || m >= n){
            return head;
        }
        //哨兵节点
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

        return dummy.next;
    }

    /**
     * 3. 复制随机指针的链表
     */
    public RandomNode copyRandomNode (RandomNode head){
        if(head == null){
            return null;
        }

        return head;
    }

    public static void main(String[] args) {
        //1 翻转链表 一
//        ListNode head = new ListNode(1);
//        (((head.next = new ListNode(2)).next = new ListNode(3)).next = new ListNode(4)).next = new ListNode(5);
//        System.out.print("翻转链表前结果:::");
//        new LeetCodeUtils().getDataByRecursion(head);
//        System.out.println("");
//        ListNode resultReverseList = new GupaoLeetcode().reverseList(head);
//        System.out.print("翻转链表后结果:::");
//        new LeetCodeUtils().getDataByRecursion(resultReverseList);

        //2 翻转链表 二
//        ListNode head = new ListNode(1);
//        (((head.next = new ListNode(2)).next = new ListNode(3)).next = new ListNode(4)).next = new ListNode(5);
//        System.out.print("翻转链表(2)前结果:::");
//        int m = 2,n = 4;
//        new LeetCodeUtils().getDataByRecursion(head);
//        System.out.println("");
//        System.out.println("m:" + m + ",n:" + n);
//        ListNode resultReverseList = new GupaoLeetcode().reverseList2(head,m,n);
//        System.out.print("翻转链表(2)后结果:::");
//        new LeetCodeUtils().getDataByRecursion(resultReverseList);

        //3. 复制随机指针的链表
        RandomNode head = new RandomNode(0);
        System.out.println(new GupaoLeetcode().copyRandomNode(head));
    }
}

/**
 * 随机指针的节点
 */
class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode (int val){
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
