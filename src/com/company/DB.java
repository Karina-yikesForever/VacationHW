package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
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




public Connection printTrainers(){
        String SQL="select * from trainers";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                String name=rs.getString("name");
                int salary=rs.getInt("salary");
                System.out.println(rs.getString("name" + " "));
                System.out.println(rs.getString("salary" + " "));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect();
    }
    public void sumTrainersSalary(){
        String SQL = "select sum(st.salary) \n" +
                "from trainers tt\n" +
                "join sport_types st on sport_type = st.id";

        try
                (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL))
        {
            while (rs.next()){
                int sumSalary = rs.getInt("sum");
                System.out.println(sumSalary);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void trainersName(){
        String SQL = "select length(t.\"name\") \n" +
                "from trainers t\n" +
                "where length(name)>=6";

        try
                (Connection conn = connect();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(SQL))
        {
            while (rs.next()){
                int sumSalary = rs.getInt("length");
                System.out.println(sumSalary + " молодец");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}




