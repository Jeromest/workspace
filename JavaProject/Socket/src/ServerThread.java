import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    private final Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        String ip = socket.getLocalAddress().getHostAddress();
        int port = socket.getPort();
        try {
            while (true) {
                in = socket.getInputStream();
                byte[] buffer = new byte[1024];
                int index = in.read(buffer);
                String receive = new String(buffer, 0, index);
                System.out.println("服务器端接收到的消息：" + receive);
                if (receive.equals(("exit")))
                    break;
                out = socket.getOutputStream();
                String mes = "fuck";
                out.write(mes.getBytes());
                System.out.println("服务器发送的消息：" + mes);
            }
            System.out.println("服务器断开连接");
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
