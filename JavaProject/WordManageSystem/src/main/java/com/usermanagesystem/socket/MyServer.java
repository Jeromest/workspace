package com.usermanagesystem.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket��������
 * 1����8080�˿�
 * 2���Ӷ�����ȡ����������
 * 3����ȡһ�����������
 * 4��������Ŀͻ��˷����ַ���
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
