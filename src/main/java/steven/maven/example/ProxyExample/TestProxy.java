package steven.maven.example.ProxyExample;

public class TestProxy {
    public static void main(String[] args) throws Exception {
        UserService userService = UseProxy.createProxy(new UserServiceImplete());
        userService.login("admin", "123456");
        // 打印查询到的信息
        userService.query();
        userService.delete();
    }
}
