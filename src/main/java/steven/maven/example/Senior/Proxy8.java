package steven.maven.example.Senior;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxy8 {
    // 3. 测试动态代理
    public static void main(String[] args) {
        // 创建目标对象
        UserService target = new UserServiceImpl();

        // 创建 InvocationHandler
        DynamicProxyHandler handler = new DynamicProxyHandler(target);

        // 动态生成代理对象
        UserService proxy = (UserService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(),  // 目标接口
                handler                            // InvocationHandler
        );

        // 调用代理方法
        proxy.addUser("Bob");
    }
}

// 1. 定义接口和目标类（同静态代理）
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
    private final Object target; // 目标对象

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Dynamic Proxy: Logging before " + method.getName());
        Object result = method.invoke(target, args); // 调用目标方法
        System.out.println("Dynamic Proxy: Logging after " + method.getName());
        return result;
    }
}
