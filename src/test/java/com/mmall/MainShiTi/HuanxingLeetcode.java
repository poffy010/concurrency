package com.mmall.MainShiTi;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class HuanxingLeetcode {
    /*下一个排列*/
    public int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
        return nums;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*交集*/
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap();

        for(int n1:nums1){
            if(map.containsKey(n1)){
                continue;
            }
            for(int n2:nums2){
                if(map.containsKey(n2)){
                    continue;
                }
                if(n1 == n2){
                    map.put(n1,1);
                }
            }
        }

        if(!map.isEmpty()){
            int[] result = new int[map.size()];
            int index = 0;
            for(int mapkey:map.keySet()){
                result[index] = mapkey;
                index ++;
            }
            return result;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new HuanxingLeetcode().intersection(new int[]{4,9,5},new int[]{9,4,9,8,4})));
    }
}


