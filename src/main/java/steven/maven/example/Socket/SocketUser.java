
package steven.maven.example.Socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketUser {
    public static void main() {
        String serverIp = "127.0.0.1";
        int serverPort = 9999;

        try (Socket socket = new Socket(serverIp, serverPort);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("已连接到服务端: " + serverIp);

            while (true) {
                // 创建数据输出流
                OutputStream out = socket.getOutputStream();
                DataOutputStream dout = new DataOutputStream(out);

                System.out.println("输入消息（输入'exit'退出）：");
                String message = scanner.nextLine();

                // 检查是否需要退出
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("正在断开连接...");
                    break;
                }

                // 发送用户输入的消息
                dout.writeUTF(message);
                dout.writeInt(123);
                System.out.println("已发送数据: " + message);
            }
        } catch (IOException e) {
            System.err.println("连接异常: " + e.getMessage());
            // e.printStackTrace();
        }

        System.out.println("客户端已退出");
    }
}