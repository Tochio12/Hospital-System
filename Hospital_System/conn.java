package Hospital_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    Statement statement;

    public conn(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management", "root", "password");
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
