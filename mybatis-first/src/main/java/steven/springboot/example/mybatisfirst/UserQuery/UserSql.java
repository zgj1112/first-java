package steven.springboot.example.mybatisfirst.UserQuery;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import steven.springboot.example.mybatisfirst.UserClass.UserClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 查询所有用户
@Mapper //自动实现类
public interface UserSql {
    @Select("select  id, username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time from empx")
    public List<UserClass> findAll();

    @Delete("delete from empx where id=#{id}")
    public void deleteById(Integer id);

    @Insert("insert into empx(username, password, name, gender, phone, job, salary, entry_date, image, create_time, update_time) values(#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{entry_date}, #{image}, #{create_time}, #{update_time})")
    public void insert(UserClass userClass);
}

