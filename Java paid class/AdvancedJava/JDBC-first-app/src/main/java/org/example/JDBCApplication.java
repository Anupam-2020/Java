package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApplication {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "";

        try {
            // To lead and register `driver`... Now, not required
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            System.out.println("1. Fetch data \n2. Insert data \n3. Delete data \n4. Add Batch data");
            Scanner sc1 = new Scanner(System.in);
            int choice = sc1.nextInt();

            switch (choice) {
                case 1:
                    Operations.fetchData(statement);
                    break;
                case 2:
                    Operations.insertData(statement);
                    break;
                case 3:
                    Operations.deleteData(statement);
                    break;
                case 4:
                    Operations.batchAdd(statement);
                default:
                    System.out.println("Invalid input");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
