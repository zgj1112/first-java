package steven.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
