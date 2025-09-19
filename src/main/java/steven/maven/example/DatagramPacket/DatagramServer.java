package steven.maven.example.DatagramPacket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
// import java.util.Arrays;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        // 1. 创建 DatagramSocket，监听 9999 端口
        DatagramSocket socket = new DatagramSocket(9999);
        System.out.println("UDP 服务端已启动，等待消息...");

        byte[] buffer = new byte[1024]; // 存放接收数据的缓冲区
        boolean flag = true;
        while (true) {
            // 2. 封装数据报
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet); // 阻塞等待接收数据

            // 3. 获取客户端数据
            String msg = new String(packet.getData(), 0, packet.getLength());
            String msg1 = packet.getAddress().getHostAddress();
            int msg2 = packet.getPort();
            System.out.println("收到客户端消息：" + msg);
            System.out.println("客户端ip：" + msg1);
            System.out.println("客户端端口：" + msg2);

            // 4. 发送响应给客户端
            byte[] responseBytes = msg1.getBytes();

            // responseBytes,           // 要发送的数据字节数组
            // responseBytes.length,    // 发送数据的长度
            // packet.getAddress(),     // 目标地址（客户端地址）
            // packet.getPort()         // 目标端口号（客户端端口）
            DatagramPacket responsePacket = new DatagramPacket(
                    responseBytes,
                    responseBytes.length,
                    packet.getAddress(),
                    packet.getPort()
            );
            // socket.send(responsePacket);
            //     flag = false;
        }
        // 5. 关闭
        // socket.close();
    }
}
