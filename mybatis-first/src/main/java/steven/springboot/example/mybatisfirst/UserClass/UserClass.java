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
}
