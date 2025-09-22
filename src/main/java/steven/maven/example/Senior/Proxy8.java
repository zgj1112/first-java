package steven.maven.example.Senior;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy8 {
    // 提供一个可测试的方法
    public static String runProxy() {
        StringBuilder sb = new StringBuilder();

        // 创建目标对象
        UserService target = new UserServiceImpl();

        // 创建 InvocationHandler
        DynamicProxyHandler handler = new DynamicProxyHandler(target, sb);

        // 动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),  // 目标接口
                handler                             // InvocationHandler
        );

        // 调用代理方法
        proxy.addUser("赵");

        // 返回收集到的日志内容
        return sb.toString();
    }

    // 保留 main，方便直接运行
    public static void main() {
        System.out.println(runProxy());
    }
}

// 1. 定义接口和目标类
interface UserService {
    void addUser(String username);
}

class UserServiceImpl implements UserService {
    @Override
    public void addUser(String username) {
        System.out.println("Adding user: " + username);
    }
}

// 2. 定义 InvocationHandler
class DynamicProxyHandler implements InvocationHandler {
    private final Object target;   // 目标对象
    private final StringBuilder sb; // 用来收集日志

    public DynamicProxyHandler(Object target, StringBuilder sb) {
        this.target = target;
        this.sb = sb;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        sb.append("登陆前 ").append(method.getName()).append("\n");
        Object result = method.invoke(target, args); // 调用目标方法
        sb.append("登陆后 ").append(method.getName()).append("\n");
        return result;
    }
}