package steven.springboot.example.mybatisfirst;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import steven.springboot.example.mybatisfirst.UserClass.UserClass;
import steven.springboot.example.mybatisfirst.UserQuery.UserSql;

import java.util.List;

@SpringBootTest
class MybatisFirstApplicationTests {

    @Autowired
    private UserSql userSql;

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

    @Test
    void testInsert() {
        System.out.println("插入");
        // userSql.insert(null,'user10', 'mysql@888', '阿美', 0, '13800000010', 2, 8700, '2023-12-25', 'avatar10.png', now(), now());
    }
}
