package com.mmall.niuke.dp;

import java.util.*;
/**
 * @author Poffy Zhang
 * @date 2021/8/19 13:30
 * @desc
 */
public class HJ66 {
    private static Map<String,String> map = new HashMap<>();
    static{
        map.put("reset","reset what");
        map.put("reset board","board fault");
        map.put("board add","where to add");
        map.put("board delete","no board at all");
        map.put("reboot backplane","impossible");
        map.put("backplane abort","install first");
        map.put("he he","unkown command");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String zhiling = sc.nextLine();

            boolean isEquals = false;
            for(Map.Entry<String,String> entry: map.entrySet()){
                if(entry.getKey().equals(zhiling)){
                    System.out.println(entry.getValue());
                    isEquals = true;
                    break;
                }
            }

            if(!isEquals){
                for(Map.Entry<String,String> entry: map.entrySet()){
                    if(entry.getKey().contains(zhiling)){
                        System.out.println(entry.getValue());
                        break;
                    }
                }
            }

        }
    }
}
