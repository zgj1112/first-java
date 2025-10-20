package steven.springboot.example.mybatisfirst.UserQuery;

import org.apache.ibatis.annotations.*;
import steven.springboot.example.mybatisfirst.UserClass.UserClass;

import java.util.List;


//===============绑定xml文件 resources\mybatis-first\UserQuery\TestXml.xml===================
// 查询所有用户
@Mapper // 自动实现类
public interface UserSql {
    @Select("select  id, username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time from empx")
    List<UserClass> findAll();

    @Delete("delete from empx where id=#{id}")
    void deleteById(Integer id);

    @Insert("insert into empx(username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time) values(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{entry_date}, #{image}, #{create_time}, #{update_time})")
    void insert(UserClass userClass);

    @Update("update empx set username=#{username}, password=#{password}, name=#{name}, gender=#{gender}, phone=#{phone}, job=#{job}, salary=#{salary}, entry_date=#{entry_date}, image=#{image}, create_time=#{create_time}, update_time=#{update_time} where id=#{id}")
    void update(UserClass userClass);

    @Select("select * from empx where username != #{username}")
    List<UserClass> queryUser(String username);

    @Select("select username,job, avg(salary) avg_salary,entry_date,create_time from empx " +
            "where entry_date <= '2023-01-01'" +
            "group by username,job, salary,entry_date,create_time " +
            "having avg_salary > 8000 " +
            "order by avg_salary desc,entry_date")
    List<UserClass> queryGroup();
}