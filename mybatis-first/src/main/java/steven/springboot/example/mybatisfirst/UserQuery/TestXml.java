package steven.springboot.example.mybatisfirst.UserQuery;

import org.apache.ibatis.annotations.*;
import steven.springboot.example.mybatisfirst.UserClass.UserClass;

import java.util.List;

// 查询所有用户
@Mapper // 自动实现类
public interface TestXml {
    List<UserClass> findAll();

    // void deleteById(Integer id);
    //
    // void insert(UserClass userClass);
    //
    // void update(UserClass userClass);

    // List<UserClass> queryUser(String username);

    // @Select("select username,job, avg(salary) avg_salary,entry_date,create_time from empx " +
    //         "where entry_date <= '2023-01-01'" +
    //         "group by username,job, salary,entry_date,create_time " +
    //         "having avg_salary > 8000 " +
    //         "order by avg_salary desc,entry_date")
    // List<UserClass> queryGroup();
}


