package com.mmall.concurrency.interrupt;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname DianTest
 * @Description
 * @Date 2021/9/13 21:27
 * @Created by PoffyZhang
 */
public class DianTest {
    public int numberOfBoomerangs(int[][] points) {
        //记录总数
        int ans = 0;
        //遍历节点
        for (int[] p0 : points){
            //记录以距离和数量
            Map<Integer,Integer> map = new HashMap<>();
            //遍历节点，记录每个点到p0的距离
            for (int[] p1 : points){
                //计算距离
                int key = (p0[0]-p1[0])*(p0[0]-p1[0]) + (p0[1] - p1[1])*(p0[1] - p1[1]);
                map.put(key,map.getOrDefault(key,0)+1);
            }



            //遍历map，计算出每个距离下可以选择的数量
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int value = entry.getValue();
                //计算相同距离下的数量，并计入总数
                ans += value*(value-1);
            }
        }
        //返回
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][2];
        arr[0][0] = 1;
        arr[0][1] = 1;

        arr[1][0] = 2;
        arr[1][1] = 2;

        arr[2][0] = 3;
        arr[2][1] = 3;

        System.out.println(new DianTest().numberOfBoomerangs(arr));
    }
}
