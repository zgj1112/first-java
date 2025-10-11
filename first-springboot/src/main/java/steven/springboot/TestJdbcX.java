package steven.springboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestJdbcX {
    private Integer id;
    private String username;
    private String age;
    private String gender;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        TestJDBC testJDBC = new TestJDBC();
        testJDBC.getUser();
    }
}
