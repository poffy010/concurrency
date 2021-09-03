package com.mmall.niuke.dp;

import java.util.*;
/**
 * @author Poffy Zhang
 * @date 2021/8/19 13:44
 * @desc
 */
public class HJ74 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();

            //先干掉空格
            s = s.replaceAll(" ","");

            //先算小括号
            while (s.contains("(") || s.contains(")")){
                String innerStr = s.substring(s.indexOf("(") + 1,s.indexOf(")"));

                String innerResult = jisuan(innerStr.intern());

                s = s.replace("(" + innerStr + ")",innerResult);
            }

            s = jisuan(s);

            System.out.println(s);
        }
    }

    private static String jisuan(String s) {
        //再算乘除
        while (s.contains("*") || s.contains("/")){
            //从左算起
            int chengfa = s.indexOf("*");
            int chufa = s.indexOf("/");

            if((chengfa < chufa && chengfa > -1) || chufa == -1){
                String[] splitChengfa = s.split("\\*");
                int leftNum = 0;
                int rightNum = 0;
                if(splitChengfa[0].matches("\\d+")){
                    leftNum = Integer.parseInt(splitChengfa[0]);
                }else{
                    leftNum = qiefenLeft(splitChengfa[0]);
                }

                if(splitChengfa[1].matches("\\d+")){
                    rightNum = Integer.parseInt(splitChengfa[1]);
                }else{
                    rightNum = qiefenRight(splitChengfa[1]);
                }

                String result = (leftNum * rightNum) + "";
                s = s.replace(leftNum + "*" + rightNum,result);
            }else{
                String[] splitChufa = s.split("/");
                int leftNum = 0;
                int rightNum = 0;
                if(splitChufa[0].matches("\\d+")){
                    leftNum = Integer.parseInt(splitChufa[0]);
                }else{
                    leftNum = qiefenLeft(splitChufa[0]);
                }

                if(splitChufa[1].matches("\\d+")){
                    rightNum = Integer.parseInt(splitChufa[1]);
                }else{
                    rightNum = qiefenRight(splitChufa[1]);
                }

                String result = (leftNum / rightNum) + "";
                s = s.replace(leftNum + "/" + rightNum,result);
            }
        }

        //再算加减
        while (s.contains("+") || s.contains("-")){
            //从左算起
            int jiafa = s.indexOf("+");
            int jianfa = s.indexOf("-");

            if((jiafa < jianfa && jiafa > -1) || jianfa == -1){
                String[] splitJianfa = s.split("\\+");
                int leftNum = 0;
                int rightNum = 0;
                if(splitJianfa[0].matches("\\d+")){
                    leftNum = Integer.parseInt(splitJianfa[0]);
                }else{
                    leftNum = qiefenLeft(splitJianfa[0]);
                }

                if(splitJianfa[1].matches("\\d+")){
                    rightNum = Integer.parseInt(splitJianfa[1]);
                }else{
                    rightNum = qiefenRight(splitJianfa[1]);
                }

                String result = (leftNum + rightNum) + "";
                s = s.replace(leftNum + "+" + rightNum,result);
            }else{
                String[] splitJianfa = s.split("-");
                int leftNum = 0;
                int rightNum = 0;
                if(splitJianfa[0].matches("\\d+")){
                    leftNum = Integer.parseInt(splitJianfa[0]);
                }else{
                    leftNum = qiefenLeft(splitJianfa[0]);
                }

                if(splitJianfa[1].matches("\\d+")){
                    rightNum = Integer.parseInt(splitJianfa[1]);
                }else{
                    rightNum = qiefenRight(splitJianfa[1]);
                }

                String result = (leftNum - rightNum) + "";
                s = s.replace(leftNum + "-" + rightNum,result);
            }
        }
        return s;
    }

    //左边的数 一直切分到 成为数
    private static int qiefenLeft(String s) {
        while(!s.matches("\\d+")){
            if(s.contains("+")){
                s = s.split("\\+")[1];
            }else if(s.contains("-")){
                s = s.split("-")[1];
            }else if(s.contains("*")){
                s = s.split("\\*")[1];
            }else if(s.contains("/")){
                s = s.split("/")[1];
            }
        }
        return Integer.parseInt(s);
    }

    //右边的数 一直切分到 成为数
    private static int qiefenRight(String s) {
        while(!s.matches("\\d+")){
            if(s.contains("+")){
                s = s.split("\\+")[0];
            }else if(s.contains("-")){
                s = s.split("-")[0];
            }else if(s.contains("*")){
                s = s.split("\\*")[0];
            }else if(s.contains("/")){
                s = s.split("/")[0];
            }
        }
        return Integer.parseInt(s);
    }
}
