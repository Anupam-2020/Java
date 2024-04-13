package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class Operations {
    public static void fetchData(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        while (resultSet.next()) {
            System.out.println("Student id:" + resultSet.getInt("st_id"));
            System.out.println("Student name:" + resultSet.getString("name"));
            System.out.println("Student email:" + resultSet.getString("email"));
            System.out.println("Student phone no.:" + resultSet.getString("phoneNo"));
            System.out.println("---------------------------------");
        }
    }

    public static void insertData(Statement statement) throws SQLException {
        ResultSet max_id_set = statement.executeQuery("select MAX(st_id) as max_st_id from students");
        int maxId = 0;
        while(max_id_set.next()) {
//            System.out.println(max_id_set.getInt("max_st_id"));
            maxId = max_id_set.getInt("max_st_id");
        }
        maxId++;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
        System.out.println("Enter phNo.");
        String phno = sc.next();
        int rowCount = statement.executeUpdate("insert into students values("+maxId+", '"+name+"', '"+email+"', '"+phno+"')");
        if(rowCount > 0) {
            System.out.println("Data entered successfully");
        } else {
            System.out.println("Failed");
        }
    }

    public static void deleteData(Statement statement) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id to be deleted");
        int id = sc.nextInt();
        int row = statement.executeUpdate("DELETE FROM students WHERE st_id="+id);
        if(row > 0) {
            System.out.println(id+" :Deleted successfully");
        } else {
            System.out.println("Failed to delete");
        }
    }

    public static void batchAdd(Statement statement) throws SQLException{
        System.out.println("Do you want to add data ?");
        Scanner sc = new Scanner(System.in);
        String check = sc.next();
        boolean val = !Objects.equals(check, "No");
        while(val) {
            insertData(statement);
            System.out.println("Do you want to add data ?");
            check = sc.next();
            val = !Objects.equals(check, "No");
        }
    }
}
