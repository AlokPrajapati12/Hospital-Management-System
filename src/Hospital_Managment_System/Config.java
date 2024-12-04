package Hospital_Managment_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Config {
    Connection connection;
    Statement statement;
    public Config(){
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital_management","root","root123");
            statement=connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
