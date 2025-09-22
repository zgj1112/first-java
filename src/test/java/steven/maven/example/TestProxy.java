package steven.maven.example;

import org.junit.jupiter.api.Test;
import steven.maven.example.Senior.Proxy8;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestProxy {

    @Test
    void testProxyRun() {
        String result = Proxy8.runProxy();

        // 断言结果包含预期的日志信息
        assertTrue(result.contains("登陆前 addUser"));
        assertTrue(result.contains("登陆后 addUser"));
    }
}
