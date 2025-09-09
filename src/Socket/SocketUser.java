package Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketUser {
    public static void main(String[] args) {
        String serverIp = "127.0.0.1";
        int serverPort = 9999;

        try (Socket socket = new Socket(serverIp, serverPort)) {
            System.out.println("已连接到服务端: " + serverIp);

            while (true) {
                //2.创建数据输出流
                OutputStream out = socket.getOutputStream();
                //3.创建数据输入流
                DataOutputStream dout = new DataOutputStream(out);
                System.out.println("输入消息：" );
                Scanner scanner = new Scanner(System.in);
                byte[] data = scanner.nextLine().getBytes();

                dout.writeUTF("Hello, Server!");
                dout.writeInt(123);
                System.out.println("已发送数据: Hello, Server!");
            }

        } catch (IOException e) {
            // e.printStackTrace();
        }
    }

}
