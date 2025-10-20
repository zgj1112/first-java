package steven.springboot.example.mybatisfirst;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import steven.springboot.example.mybatisfirst.UserClass.UserClass;
import steven.springboot.example.mybatisfirst.UserQuery.TestXml;
import steven.springboot.example.mybatisfirst.UserQuery.UserSql;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisFirstApplicationTests {

    @Autowired
    private UserSql userSql;
    @Autowired
    private TestXml testXml;

    @Disabled
    void testFindAll() {
        System.out.println("测试");
        List<UserClass> list = userSql.findAll();
        list.forEach(System.out::println);
    }

    @Disabled
    void testDeleteById() {
        System.out.println("删除");
        userSql.deleteById(15);
    }

    @Disabled
    void testInsert() {
        System.out.println("插入");
        String now = LocalDateTime.now().toString();
        UserClass userClass = new UserClass(null, "xxxx", "test", "test", "1", "test", "2", 0.0, now, "test", now, now);
        userSql.insert(userClass);
    }

    @Disabled
    void testUpdate() {
        System.out.println("更新");
        String now = LocalDateTime.now().toString();
        userSql.update(new UserClass(2, "xx", "test", "test", "1", "1340816152", "2", 0.0, "2021-07-05T09:05:05.000", "test", now, now));
    }

    @Disabled
    void testQuery() {
        System.out.println("查询");
        List<UserClass> list = userSql.queryUser("xxxx");
        list.forEach(System.out::println);
    }

    @Disabled
    void testQueryGroup() {
        List<UserClass> list = userSql.queryGroup();
        list.forEach(System.out::println);
    }

    @Test
    void testXmlFindAll() {
        System.out.println("测试");
        List<UserClass> list = testXml.findAll();
        list.forEach(System.out::println);
    }
}
