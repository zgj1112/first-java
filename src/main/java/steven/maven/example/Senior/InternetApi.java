package steven.maven.example.Senior;

import java.io.IOException;
// import java.net.UnknownHostException;
import java.net.InetAddress;

public class InternetApi {
    public static void main(String[] args) throws IOException {
        // 获取本地地址ip信息
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1);
        System.out.println(ip1.getHostAddress());// 获取ip
        System.out.println(ip1.getHostName());// 获取主机名
        System.out.println(ip1.getCanonicalHostName());// 获取主机全名

        //获取对方ip信息
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println();
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getCanonicalHostName());
        System.out.println(ip2.isReachable(5000));// 判断对方5秒是否可达
    }
}
