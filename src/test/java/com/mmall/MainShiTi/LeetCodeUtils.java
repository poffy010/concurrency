package com.mmall.MainShiTi;

public class LeetCodeUtils {
    /**
     * 遍历链表
     * @param node
     */
     public void getDataByRecursion(ListNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "->");
        getDataByRecursion(node.next);
    }
}
