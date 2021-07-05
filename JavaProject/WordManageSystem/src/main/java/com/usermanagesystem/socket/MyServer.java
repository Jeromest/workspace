package com.usermanagesystem.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket服务器端
 * 1、绑定8080端口
 * 2、从队列中取出连接请求
 * 3、获取一个输出流对象
 * 4、向请求的客户端返回字符串
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true) {
                Socket client = server.accept();
                OutputStream out = client.getOutputStream();
                String msg = "Hello Android!";
                out.write(msg.getBytes());
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
