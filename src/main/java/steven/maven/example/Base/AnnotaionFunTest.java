package steven.maven.example.Base;

import org.testng.annotations.Test;

// 注解的用法
@TestInterface
public class AnnotaionFunTest {
    @Test
    public void test1() {
        System.out.println("==test1()==");
    }

    //不要注解
    public void NoTest() {
        System.out.println("==test2()==");
    }

    @Test
    public void test3() {
        System.out.println("==test3()==");
    }

}
