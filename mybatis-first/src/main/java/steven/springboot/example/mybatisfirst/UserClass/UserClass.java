package steven.springboot.example.mybatisfirst.UserClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserClass {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String job;
    private Double salary;
    private String entry_date;
    private String image;
    private String create_time;
    private String update_time;
}
