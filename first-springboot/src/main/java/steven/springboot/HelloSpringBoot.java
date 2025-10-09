package steven.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// 请求类
@RestController
public class HelloSpringBoot {
    public static void main(String[] args) {
        System.out.println("Hello SpringBoot");
    }

    @RequestMapping("/helloTest")
    public String helloTest(String name) {
        return name + "Hello SpringBoot";
    }
    @RequestMapping("/helloJDBC")
    public List<Map<String, Object>> helloJDBC() {
        return TestJDBC.getEmpList(); // ✅ 调用 JDBC 查询结果并返回 JSON
    }
}
