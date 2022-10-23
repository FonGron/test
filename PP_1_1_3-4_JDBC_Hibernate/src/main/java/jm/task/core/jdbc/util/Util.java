package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/datauser";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "KAPriz148";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            System.out.println("CONNECTION OK");
        } catch (SQLException e) {
            System.out.println("NOT CONNECTION");
            throw new RuntimeException(e);

        }
        return connection;
    }
    public static void disconnected() {

        if(connection!=null){
            try {
                System.out.println("Disconnected OK");
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
