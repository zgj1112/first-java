package DatagramPacket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) throws IOException {
        // try {
        // 1. 创建 DatagramSocket，监听 9999 端口
        try (DatagramSocket socket = new DatagramSocket(9999)) {
            System.out.println("UDP 服务端已启动，等待消息...");

            byte[] buffer = new byte[1024]; // 存放接收数据的缓冲区
            boolean flag = true;
            while (flag) {
                // 2. 封装数据报
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet); // 阻塞等待接收数据

                // 3. 获取客户端数据
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("收到客户端消息：" + msg);

                // 4. 发送响应给客户端
                String response = "服务端已收到: " + msg;
                byte[] responseBytes = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseBytes,
                        responseBytes.length,
                        packet.getAddress(),
                        packet.getPort()
                );
                socket.send(responsePacket);
                flag = false;
            }
        }
        // } catch (Exception e) {
        //     // e.printStackTrace();
        // }
    }
}
