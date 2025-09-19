package steven.maven.example.DatagramPacket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
// import java.util.Arrays;
import java.util.Scanner;

public class DatagramUser {
    public static void main(String[] args) {
        try {
            while (true) {
                // 1. 创建 DatagramSocket
                DatagramSocket socket = new DatagramSocket();

                // 2. 要发送的数据
                // String msg = "Hello UDP Server!";
                System.out.println("输入消息：" );
                Scanner scanner = new Scanner(System.in);

                byte[] data = scanner.nextLine().getBytes();

                // 3. 封装数据报，指定发送地址和端口
                InetAddress serverAddr = InetAddress.getByName("127.0.0.1"); // 本机
                DatagramPacket packet = new DatagramPacket(data, data.length, serverAddr, 9999);

                // 4. 发送数据
                socket.send(packet);
                System.out.println("客户端发送消息：" +  new String(data));

                // 5. 接收服务端的响应
                byte[] buffer = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                System.out.println("服务端ip" + response);

                // 6. 关闭
                // socket.close();
            }

        }
        catch (Exception e) {
            // e.printStackTrace();
        }
    }
}
