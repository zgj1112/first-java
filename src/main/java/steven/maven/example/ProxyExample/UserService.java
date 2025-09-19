package steven.maven.example.ProxyExample;

public interface UserService {
    // 登录
    void login(String username, String password) throws Exception;

    // 查询
    void query() throws Exception;

    // 删除
    void delete() throws Exception;
}
