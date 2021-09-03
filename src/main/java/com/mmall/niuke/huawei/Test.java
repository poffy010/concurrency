package com.mmall.niuke.huawei;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.io.*;

/**
 * @author Poffy Zhang
 * @date 2021/8/18 13:50
 * @desc
 */
public class Test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null){
            String[] ips = str.split("\\.");

            Boolean flag = true;
            for(String ip : ips){
                if(!ip.matches("\\d+") || Integer.parseInt(ip) < 0 ||
                        Integer.parseInt(ip) > 255){
                    flag = false;
                }
            }

            System.out.println(flag ? "YES" : "NO");
        }
    }
}
