package com.mmall.MainShiTi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeTest {
    public int getMinimumDifference(TreeNode root) {
        int minCount = 0;

        List<Integer> treeSet = new ArrayList <>();
        while (root.left != null || root.right != null) {
            treeSet.add( root.val );
            root = root.left == null ? root.right : root.left;
        }

        for (int i = 0; i < treeSet.size(); i++) {
            for (int j = 1; j < treeSet.size(); j++) {
                minCount = Math.min(minCount,Math.abs(treeSet.get(i) - treeSet.get(j)));
            }
        }

        return minCount;
    }

    public static void main(String[] args) {

    }
}


