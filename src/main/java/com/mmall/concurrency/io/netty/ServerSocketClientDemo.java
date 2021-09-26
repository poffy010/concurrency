package com.mmall.concurrency.io.netty;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Classname ServerSocketClientDemo
 * @Description
 * @Date 2021/9/3 7:28
 * @Created by PoffyZhang
 */
public class ServerSocketClientDemo {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",8080);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("我是客户 发送了一个信息\n");
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverLine = br.readLine();
            System.out.println("服务端发送来消息:" + serverLine);

            bw.flush();

            br.close();
            bw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
