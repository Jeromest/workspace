import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public SocketServer() {
        Socket socket = null;
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            while (true) {
                System.out.println("服务器等待客户端连接....");
                socket = serverSocket.accept();
                String ip = socket.getLocalAddress().getHostAddress();
                int port = socket.getPort();
                System.out.println("连接上的客户端ip:" + ip + "端口号:" + port);
                new ServerThread((socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SocketServer();
    }

}
