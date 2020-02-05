package B.ex;

import com.company.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

 class DB {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "55555555k";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostegreSQL server successfully.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }

    public class B {
        public List<Student> printAllStudents() {
            List<Student> studentList = new ArrayList<>();
            String SQL = "select count* from students_2 ";
            try (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL)) {
                while (rs.next()) {
                    Student st = new Student();
                    System.out.println(rs.getInt("ID") + " ");
                    System.out.println(rs.getString("NAME") + " ");
                    System.out.println(rs.getString("GROUP_ID") + " ");
                    System.out.println(rs.next());
                    studentList.add(st);
                }

            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            return studentList;
        }

    }
}


