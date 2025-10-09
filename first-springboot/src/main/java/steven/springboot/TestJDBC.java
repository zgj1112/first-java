
package steven.springboot;

import java.sql.*;
import java.util.*;

public class TestJDBC {
    public static List<Map<String, Object>> getEmpList() {
        List<Map<String, Object>> list = new ArrayList<>();

        try {
            // 1️⃣ 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ 建立连接
            String url = "jdbc:mysql://localhost:3306/testdb01?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "123456";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery("select * from empx")) {

                // 3️⃣ 遍历结果集
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("id", rs.getInt("id"));
                    row.put("username", rs.getString("username"));
                    row.put("name", rs.getString("name"));
                    row.put("salary", rs.getInt("salary"));
                    row.put("entry_date", rs.getDate("entry_date"));
                    list.add(row);
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }

        return list;
    }
}

// package steven.springboot;
//
// import java.sql.*;
//
// public class TestJDBC {
//     public static void main(String[] args) throws SQLException, ClassNotFoundException {
//         System.out.println("Hello JDBC");
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         String url = "jdbc:mysql://localhost:3306/testdb01";
//         String user = "root";
//         String password = "123456";
//         Connection conn = DriverManager.getConnection(url, user, password);
//         System.out.println(conn);
//         Statement st = conn.createStatement();
//         ResultSet rs = st.executeQuery("select * from empx");
//         while (rs.next()) {
//             System.out.println(rs.getString("username"));
//         }
//         rs.close();
//         st.close();
//         conn.close();
//     }
// }
