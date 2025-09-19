package steven.maven.example.ProxyExample;

import java.util.Arrays;
import java.util.Objects;

public class UserServiceImplete implements UserService {
    // 登录模拟
    public void login(String username, String password) throws Exception {
        if (Objects.equals(username, "admin") && Objects.equals(password, "123456")) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
        Thread.sleep(1000);
    }

    public void query() throws Exception {
        System.out.println("查询成功");
        Thread.sleep(1000);
        // 返回用户
        String[] returnQuery = new String[]{"zhangsan", "李四", "王二麻子"};
        System.out.println(Arrays.toString(returnQuery));
        // return returnQuery;
    }

    public void delete() throws Exception {
        System.out.println("删除成功");
        Thread.sleep(1000);
        // return new String[]{"1", "2", "3"};
        // return null;
    }
}
