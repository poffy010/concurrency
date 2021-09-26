package com.mmall.concurrency.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Poffy Zhang
 * @date 2021/9/26 14:15
 * @desc
 */
public class Consumer {

    public static void main(String[] args) {
        //1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //2.设置连接属性
        factory.setHost("121.4.142.63");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");

        Connection connection = null;
        Channel channel = null;

        try{
            //3. 从连接工厂 获取连接
            connection = factory.newConnection("消费者");

            //4. 从连接中 创建通道
            channel = connection.createChannel();

            //5. 生命队列
            channel.queueDeclare("queue1",false,false,false,null);

            //6. 定义收到消息后的回调
            DeliverCallback callback = new DeliverCallback() {
                @Override
                public void handle(String s,Delivery delivery) throws IOException {
                    System.out.println("收到消息:"  + new String(delivery.getBody(),"utf-8"));
                }
            };

            //7. 监听队列
            channel.basicConsume("queue1",true,callback,new CancelCallback() {
                @Override
                public void handle(String s) throws IOException {

                }
            });

            System.out.println("开始接受消息");
            System.in.read();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //7.关闭通道
            if(channel != null && channel.isOpen()){
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }

            //8.关闭连接
            if(connection != null && connection.isOpen()){
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
