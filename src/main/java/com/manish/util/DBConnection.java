package com.manish.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/student_management_SystemJDBC";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "982105";

    private DBConnection(){  // Prevent object creation;

    }

    public static Connection getConnection(){

        Connection connection = null;

        try{

            connection = DriverManager.getConnection(
                    URL,
                    USERNAME,
                    PASSWORD
            );
        }
        catch(SQLException e){
           System.out.println("Database connection failed");
        }
        return connection;
    }
}
