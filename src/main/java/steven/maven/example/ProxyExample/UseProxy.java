package steven.maven.example.ProxyExample;


// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.Method;

import java.lang.reflect.Proxy;

public class UseProxy {
    // 代理类
    public static UserService createProxy(UserService getobj) {
        UserService proxy = (UserService) Proxy.newProxyInstance(
                getobj.getClass().getClassLoader(),
                getobj.getClass().getInterfaces(),
                (proxy1, method, args) -> {
                    long startTime = System.currentTimeMillis();
                    Object result = method.invoke(getobj, args);
                    long endTime = System.currentTimeMillis();
                    System.out.println(method.getName() + "接口耗时: " + (endTime - startTime) + "ms");
                    return result;
                });
        return proxy;
    }
}
