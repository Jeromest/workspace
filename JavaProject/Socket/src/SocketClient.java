import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
    public SocketClient() {
        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            socket = new Socket("localhost", 8000);
            out = socket.getOutputStream();
            while (socket != null) {
                System.out.println("请输入:");
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.next();
                System.out.println("客户端发送消息:" + msg);
                out.write(msg.getBytes());
                in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int index = in.read(buffer);
                String receive = new String(buffer, 0, index);
                System.out.println("服务器返回的消息:" + receive);
            }
            System.out.println("客户端断开连接");
            in.close();
            out.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketClient();
    }
}
