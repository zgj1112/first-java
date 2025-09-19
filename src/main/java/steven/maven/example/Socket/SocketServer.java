package steven.maven.example.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 9999;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP 服务端已启动，等待客户端连接...");

            Socket clientSocket = serverSocket.accept(); //等客户端
            System.out.println("客户端已连接: " + clientSocket.getInetAddress().getHostAddress());

            InputStream in = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            String msg = dis.readUTF();
            int id = dis.readInt();

            System.out.println("id=" + id + "收到客户端消息：" + msg);


        } catch (IOException e) {
            // e.printStackTrace();
        }
    }
}
