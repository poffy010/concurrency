package com.mmall.concurrency.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author Poffy Zhang
 * @date 2021/9/26 11:29
 * @desc
 */
public class Producer {

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
            connection = factory.newConnection("生产者");

            //4. 从连接中 创建通道
            channel = connection.createChannel();

            //5. 生命队列
            channel.queueDeclare("queue1",false,false,false,null);

            //
            String message = "Hello World";

            //6.发送消息
            channel.basicPublish("","queue1",null,message.getBytes());
            System.out.println("消息已发送");

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
