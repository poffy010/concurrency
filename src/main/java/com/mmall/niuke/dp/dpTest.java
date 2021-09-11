package com.mmall.niuke.dp;

import java.util.*;
import java.io.*;

/**
 * @author Poffy Zhang
 * @date 2021/8/18 16:12
 * @desc 动态规划
 */
public class dpTest {
    public static void main(String[] args) throws IOException{
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        String s1 = st.sval;
        st.nextToken();
        String s2 = st.sval;

        System.out.println(stringDistance(s1.toCharArray(),s2.toCharArray()));
    }

    private static int stringDistance(char[] a, char[] b) {
        int[][] len = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            len[i][0] = i;
        }
        for (int j = 0; j <b.length + 1; j++) {
            len[0][j] = j;
        }
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    len[i][j] = len[i - 1][j - 1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }
        return len[a.length][b.length];
    }

}
